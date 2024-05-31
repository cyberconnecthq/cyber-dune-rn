//
//  CyberPasskeyProcessor.swift
//  CyberPasskey
//
//  Created by spantar on 2024/5/31.
//

import Foundation
import AuthenticationServices
import Foundation
@_exported import os
import CryptoKit

protocol PassKeyProcessorDelegate: AnyObject {
    func createPassKeyFinished(
        _ result:Bool, _ shouldToast:Bool, _ toastText:String?,
        _ registeringChallenge:String,
        _ regsiteringUsername:String,
        _ credentialID:String,
        _ clientDataJSON:String,
        _ attestationObject:String
    )

    func passKeySignFinished(
        _ result:Bool, _ shouldToast:Bool, _ toastText:String?,
        _ signingChallenge:String,
        _ credentialID:String,
        _ signature:String,
        _ clientDataJSON:String,
        _ authenticatorData:String
    )
}

enum PassKeyOnGoingType {
    case create_passkey
    case passkey_sign
}

class PassKeyProcessor: NSObject, ASAuthorizationControllerPresentationContextProviding, ASAuthorizationControllerDelegate {
    let domain = "link3.to"
    var authenticationAnchor: ASPresentationAnchor?
    
    public weak var delegate:PassKeyProcessorDelegate?
    public var registeringChallenge:String = ""
    public var regsiteringUsername:String = ""
    public var signingChallenge:String = ""
    public var onGoingType:PassKeyOnGoingType = .passkey_sign
    
    func generateRandomData(length: Int) -> Data {
        return Data((0..<length).map { _ in UInt8.random(in: .min ... .max) })
    }
    
    func createPasskey(
        anchor: ASPresentationAnchor
    ) {
        onGoingType = .create_passkey
        self.authenticationAnchor = anchor
        let publicKeyCredentialProvider = ASAuthorizationPlatformPublicKeyCredentialProvider(relyingPartyIdentifier: domain)
        
        // Fetch the challenge from the server. The challenge needs to be unique for each request.
        // The userID is the identifier for the user's account.
        let randomData = generateRandomData(length: 32)
        self.registeringChallenge = randomData.base64URLEncodedString()
        
        guard let dateStr = Date().toString(format: .custom("yyyy-MM-dd HH:mm:ss")) else {
            Logger().log("error, generate date string failed")
            return
        }
        let userName = dateStr + " CyberAccount"
        self.regsiteringUsername = userName
        
        let userID = generateRandomData(length: 32)
        Logger().log("[passkey]: create account : username = \(userName), userID = \(userID), challenge: \(self.registeringChallenge)")
        
        
        let registrationRequest = publicKeyCredentialProvider.createCredentialRegistrationRequest(
            challenge: randomData,
            name: userName,
            userID: userID)
        // Use only ASAuthorizationPlatformPublicKeyCredentialRegistrationRequests or
        // ASAuthorizationSecurityKeyPublicKeyCredentialRegistrationRequests here.
        let authController = ASAuthorizationController(authorizationRequests: [ registrationRequest ] )
        authController.delegate = self
        authController.presentationContextProvider = self
        authController.performRequests()
    }
    
    func getChallengeFromPayload(payload: String) -> Data {
        let messageBuffer = payload.data(using: .utf8)!
        let hashBuffer = SHA256.hash(data: messageBuffer)
        let hexString = hashBuffer.map { String(format: "%02hhx", $0) }.joined()
        let hexBuffer = Data(hexString.utf8)
        return hexBuffer
    }
    
    func passkeySign(payload:String, anchor: ASPresentationAnchor, preferImmediatelyAvailableCredentials: Bool) {
        onGoingType = .passkey_sign
        
        self.authenticationAnchor = anchor
        let publicKeyCredentialProvider = ASAuthorizationPlatformPublicKeyCredentialProvider(relyingPartyIdentifier: domain)
        
        let randomData = getChallengeFromPayload(payload: payload)
        self.signingChallenge = randomData.base64URLEncodedString()
        
        let assertionRequest = publicKeyCredentialProvider.createCredentialAssertionRequest(challenge: randomData)
        
        // Also allow the user to use a saved password, if they have one.
//        let passwordCredentialProvider = ASAuthorizationPasswordProvider()
//        let passwordRequest = passwordCredentialProvider.createRequest()
        
        // Pass in any mix of supported sign-in request types.
        let authController = ASAuthorizationController(authorizationRequests: [ assertionRequest ] )
        authController.delegate = self
        authController.presentationContextProvider = self
        
        if preferImmediatelyAvailableCredentials {
            // If credentials are available, presents a modal sign-in sheet.
            // If there are no locally saved credentials, no UI appears and
            // the system passes ASAuthorizationError.Code.canceled to call
            // `PassKeyProcessor.authorizationController(controller:didCompleteWithError:)`.
            authController.performRequests(options: .preferImmediatelyAvailableCredentials)
        } else {
            // If credentials are available, presents a modal sign-in sheet.
            // If there are no locally saved credentials, the system presents a QR code to allow signing in with a
            // passkey from a nearby device.
            authController.performRequests()
        }
        
    }
    
    func beginAutoFillAssistedPasskeySignIn(anchor: ASPresentationAnchor) {
        self.authenticationAnchor = anchor
        
        let publicKeyCredentialProvider = ASAuthorizationPlatformPublicKeyCredentialProvider(relyingPartyIdentifier: domain)
        
        // Fetch the challenge from the server. The challenge needs to be unique for each request.
        let randomData = generateRandomData(length: 32)
        let assertionRequest = publicKeyCredentialProvider.createCredentialAssertionRequest(challenge: randomData)
        
        // AutoFill-assisted requests only support ASAuthorizationPlatformPublicKeyCredentialAssertionRequest.
        let authController = ASAuthorizationController(authorizationRequests: [ assertionRequest ] )
        authController.delegate = self
        authController.presentationContextProvider = self
        authController.performAutoFillAssistedRequests()
    }
    
    func authorizationController(controller: ASAuthorizationController, didCompleteWithAuthorization authorization: ASAuthorization) {
        let logger = Logger()
        switch authorization.credential {
        case let credentialRegistration as ASAuthorizationPlatformPublicKeyCredentialRegistration:
            Logger().log("[passkey]: A new passkey was registered: \(credentialRegistration)")
            // Verify the attestationObject and clientDataJSON with your service.
            // The attestationObject contains the user's new public key to store and use for subsequent sign-ins.
            guard let attestationObject = credentialRegistration.rawAttestationObject else {
                Logger().log("[passkey]: nil attestationObject")
                return
            }
            let clientDataJSON = credentialRegistration.rawClientDataJSON
            let credentialID = credentialRegistration.credentialID
            
            let encodedCredentialID = credentialID.base64URLEncodedString()
            let encodedClientDataJSON = clientDataJSON.base64URLEncodedString()
            let encodedAttestationObject = attestationObject.base64URLEncodedString()
            
            self.delegate?.createPassKeyFinished(true, false, nil,
                                                 registeringChallenge,
                                                 regsiteringUsername,
                                                 encodedCredentialID, encodedClientDataJSON, encodedAttestationObject)
            
        case let credentialAssertion as ASAuthorizationPlatformPublicKeyCredentialAssertion:
            Logger().log("[passkey]: A passkey was used to sign in: \(credentialAssertion)")
            // Verify the below signature and clientDataJSON with your service for the given userID.
            let signature = credentialAssertion.signature
            let clientDataJSON = credentialAssertion.rawClientDataJSON
            let _ = credentialAssertion.userID
            let authenticatorData = credentialAssertion.rawAuthenticatorData
            let credentialID = credentialAssertion.credentialID
            
            let encodedCredentialID = credentialID.base64URLEncodedString()
            let encodedClientDataJSON = clientDataJSON.base64URLEncodedString()
            guard let encodedSignature = signature?.base64URLEncodedString(),
                  let encodedAuthenticatorData = authenticatorData?.base64URLEncodedString() else {
                Logger().log("[passkey]: sign in base64URLEncodedString failed")
                return
            }
            self.delegate?.passKeySignFinished(true, false, nil, signingChallenge, encodedCredentialID, encodedSignature, encodedClientDataJSON, encodedAuthenticatorData)
        case let passwordCredential as ASPasswordCredential:
            Logger().log("A password was provided: \(passwordCredential)")
            // Verify the userName and password with your service.
            // let userName = passwordCredential.user
            // let password = passwordCredential.password
            
            // After the server verifies the userName and password, sign in the user.
        default:
            fatalError("Received unknown authorization type.")
        }
        
    }
    
    func authorizationController(controller: ASAuthorizationController, didCompleteWithError error: Error) {
        let logger = Logger()
        guard let authorizationError = error as? ASAuthorizationError else {
            logger.error("[passkey]: Unexpected authorization error: \(error.localizedDescription)")
            switch onGoingType {
            case .create_passkey:
                self.delegate?.createPassKeyFinished(false, true,
                                                     registeringChallenge,
                                                     regsiteringUsername,
                                                     "Unexpected Authorization Error: \(error.localizedDescription)", "", "", "")
            case .passkey_sign:
                self.delegate?.passKeySignFinished(false, true, "Unexpected Authorization Error: \(error.localizedDescription)",signingChallenge, "", "", "", "")
            }
            return
        }
        
        if authorizationError.code == .canceled {
            // Either the system doesn't find any credentials and the request ends silently, or the user cancels the request.
            // This is a good time to show a traditional login form, or ask the user to create an account.
            Logger().log("[passkey]: Request canceled.")
            switch onGoingType {
            case .create_passkey:
                self.delegate?.createPassKeyFinished(false, true, "Cancelled",
                                                     registeringChallenge,
                                                     regsiteringUsername,
                                                     "", "", "")
            case .passkey_sign:
                self.delegate?.passKeySignFinished(false, true, "Cancelled",signingChallenge, "", "", "", "")
            }
        } else {
            // Another ASAuthorization error.
            // Note: The userInfo dictionary contains useful information.
            logger.error("[passkey]: Error: \((error as NSError).userInfo)")
            switch onGoingType {
            case .create_passkey:
                self.delegate?.createPassKeyFinished(false, true,
                                                     registeringChallenge,
                                                     regsiteringUsername,
                                                     "Unexpected Network Error: \((error as NSError).userInfo)", "", "", "")
            case .passkey_sign:
                self.delegate?.passKeySignFinished(false, true, "Unexpected Network Error: \((error as NSError).userInfo)",signingChallenge, "", "", "", "")
            }
        }
    }
    
    func presentationAnchor(for controller: ASAuthorizationController) -> ASPresentationAnchor {
        return authenticationAnchor!
    }
}

