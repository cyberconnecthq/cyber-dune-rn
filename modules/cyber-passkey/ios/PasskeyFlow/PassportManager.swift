//
//  PassportManager.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation
import UIKit
import SwiftMessages
import AuthenticationServices

let USER_LOGIN_CHANGED_EVENT = "UserLoginChanged"
let USER_PROFILE_CHANGED = "UserProfileChanged"
let USER_UNREAD_MESSAGE_COUNT_UPDATE_EVENT = "UserUnreadMessageCountUpdate"
let USER_UNREAD_NOTIFICATION_COUNT_UPDATE_EVENT = "UserUnreadNotificationCountUpdate"
let USER_EAS_STATUS_CHANGED = "UserEASStatusChanged"
let USER_REMARK_CHANGED_EVENT = "UserRemarkChanged"

enum UserType:String, Codable {
    case passkey = "passkey"
    case eoa = "eoa"
}

struct CyberIdStruct : Identifiable, Codable {
    var id : String
    var handle:String
    var isPrimary:Bool
}

struct PointAccount : Codable {
    var completedTasksCount: Int
    var totalPoints: Int
}


class UserInfo : Codable {
    var id: String
    var userType:UserType
    var avatar: String?
    var displayName: String?
    var bio: String?
    var EOAAddress: String?
    var formattedEOAAddress: String?
    var cyberAccountAddress: String?
    var formattedCyberAccountAddress: String?
    var v3SdkToken: String?
    var profileID: String?
    var profileHandle: String?
    
    //current identity
    var headlineTitle: String?
    var headlineOrgDisplayName: String?
    var headlineOrgTwitterHandle: String?
    var headlineOrgTwitterId: String?
    var headlineOrgTwitterAvatar:String?
    
    //identities
    var identitiesCount:Int
        
    // only for passkey users
    var turnkeyUserId: String?
    var turnkeySubOrgId: String?
    
    //start from chat function - onchain gas credit
    var v3Info_gasCreditValue: String?
    var v3Info_gasDecimals: Int?
    
    //start from chat function - offchain credit, centralized
    var link3CreditCurrency: String?
    var link3CreditTotalValue: String?
    var link3CreditWithdrawalbeValue: String?
    var link3CreditNonwithdrawalbeValue: String?
    var link3CreditDecimals: Int?
    
    //start from chat function - my dm price
    var my_price_currency: String?
    var my_price_value: String?
    var my_price_decimals: Int?
    
    var totalEarned_value:String?
    var totalEarned_decimals: Int?
    
    var discordId: String?
    var twitterId: String?
    var twitterAuthorized: Bool?
    var email: String?
    var linkedinId: String?
    var githubId: String?
    var telegram: String?
    
    //price feed back
    var priceFeedback_description:String?
    var priceFeedback_feedback:String?
    
    var isVerified:Bool
    var EAS_uid:String?
    var EAS_status:String?
    
    var cyberIds:[CyberIdStruct]
    
    
    var isDeleted:Bool
    
    var profileCompletionRate:Float
    
    var nonnullDisplayName:String {
        if let _displayName = self.displayName,
           _displayName.isEmpty == false {
            return _displayName
        }
        return self.formattedEOAAddress ?? ""
    }
    
    init(
        id: String,
        userType: UserType,
        avatar: String?,
        displayName: String?,
        bio: String?,
        EOAAddress: String?,
        formattedEOAAddress: String?,
        cyberAccountAddress: String?,
        v3SdkToken: String?,
        profileID:String?,
        profileHandle: String?,
        
        headlineTitle: String?,
        headlineOrgDisplayName: String?,
        headlineOrgTwitterHandle: String?,
        headlineOrgTwitterId: String?,
        headlineOrgTwitterAvatar: String?,
        
        identitiesCount:Int,
        
        turnkeyUserId: String?,
        turnkeySubOrgId: String?,
        
        gasCreditValue: String?,
        gasDecimals: Int?,
        link3CreditTotalValue: String?,
        link3CreditWithdrawalbeValue: String?,
        link3CreditNonwithdrawalbeValue: String?,
        link3CreditDecimals: Int?,
        link3CreditCurrency: String?,
        
        my_price_currency: String?,
        my_price_value: String?,
        my_price_decimals: Int?,
        
        totalEarned_value:String?,
        totalEarned_decimals: Int?,
        
        discordId: String?,
        twitterId: String?,
        twitterAuthorized: Bool?,
        email: String?,
        linkedinId: String?,
        githubId: String?,
        telegram: String?,
        
        priceFeedback_description:String?,
        priceFeedback_feedback:String?,
        
        isVerified:Bool,
        EAS_uid:String?,
        EAS_status:String?,
        
        cyberIds:[CyberIdStruct],
        
        isDeleted:Bool,
        profileCompletionRate:Float
    ) {
        self.id = id
        self.userType = userType
        self.avatar = avatar
        self.displayName = displayName
        self.bio = bio
        self.EOAAddress = EOAAddress
        self.formattedEOAAddress = formattedEOAAddress
        self.cyberAccountAddress = cyberAccountAddress
        self.isVerified = isVerified
        self.EAS_uid = EAS_uid
        self.EAS_status = EAS_status
        self.v3SdkToken = v3SdkToken
        self.profileID = profileID
        self.profileHandle = profileHandle
        
        self.headlineTitle = headlineTitle
        self.headlineOrgDisplayName = headlineOrgDisplayName
        self.headlineOrgTwitterHandle = headlineOrgTwitterHandle
        self.headlineOrgTwitterId = headlineOrgTwitterId
        self.headlineOrgTwitterAvatar = headlineOrgTwitterAvatar
        
        self.identitiesCount = identitiesCount
        
        self.turnkeyUserId = turnkeyUserId
        self.turnkeySubOrgId = turnkeySubOrgId
        
        self.v3Info_gasCreditValue = gasCreditValue
        self.v3Info_gasDecimals = gasDecimals
        self.link3CreditTotalValue = link3CreditTotalValue
        self.link3CreditWithdrawalbeValue = link3CreditWithdrawalbeValue
        self.link3CreditNonwithdrawalbeValue = link3CreditNonwithdrawalbeValue
        self.link3CreditDecimals = link3CreditDecimals
        self.link3CreditCurrency = link3CreditCurrency
        self.my_price_value = my_price_value
        self.my_price_currency = my_price_currency
        self.my_price_decimals = my_price_decimals
        
        self.totalEarned_value = totalEarned_value
        self.totalEarned_decimals = totalEarned_decimals
        
        self.discordId = discordId
        self.twitterId = twitterId
        self.twitterAuthorized = twitterAuthorized
        self.email = email
        self.linkedinId = linkedinId
        self.githubId = githubId
        self.telegram = telegram
        
        self.priceFeedback_description = priceFeedback_description
        self.priceFeedback_feedback = priceFeedback_feedback
        
        self.cyberIds = cyberIds
        
        self.isDeleted = isDeleted
        self.profileCompletionRate = profileCompletionRate
    }
}

protocol PassPortManagerWCDelegate : AnyObject {
    func viewControllerForSignRequest() -> UIViewController
}

protocol PassPortManagerPassKeyDelegate : AnyObject {
    func createPassKeyFinished(
        _ result:Bool, _ shouldToast:Bool, _ toastText:String?,
        _ registeringChallenge:String,
        _ regsiteringUsername:String,
        _ credentialID: String,
        _ clientDataJSON: String,
        _ attestationObject: String
    )
    
    func passKeySignFinished(
        _ result:Bool, _ shouldToast:Bool, _ toastText:String?,
        _ signingChallenge:String,
        _ credentialID:String,
        _ signature: String,
        _ authenticatorData: String,
        _ clientDataJSON: String
    )
}

class PassportManager {
    
    static let sharedInstance = PassportManager()
    weak var wcDelegate:PassPortManagerWCDelegate?
    weak var passKeyDelegate:PassPortManagerPassKeyDelegate?
    
    
    init() {
        self.initProcessors()
        
        NotificationCenter.default.addObserver(self, selector: #selector(handleNotification(_:)), name: Notification.Name(USER_EAS_STATUS_CHANGED), object: nil)
    }
    
    private func initProcessors() {
        
    }
    
    @objc private func handleNotification(_ notification: Notification) {
        if let userInfo = notification.object as? [String:Any] {
            // 从通知的 userInfo 中获取额外的信息
            if let eas_uid = userInfo["eas_uid"] as? String {
                if let user = PassportManager.sharedInstance.getUser() {
                    user.isVerified = true
                    user.EAS_uid = eas_uid
                    self.saveUser(user: user)
                    Logger().log("[PassportManager]: update user eas, uid = \(eas_uid)")
                }
            }
        }
    }
    
    /*lazy var metaMaskProcessor:MetaMaskProcessor = {
     let processer = MetaMaskProcessor()
     return processer
     }()*/
    
    lazy var passKeyProcessor:PassKeyProcessor = {
        let processer = PassKeyProcessor()
        processer.delegate = self
        return processer
    }()
    
    var logined:Bool {
        //MARK: simulator - on
        //        return true
        let token = getToken()
        return  token != nil && token?.isEmpty == false
    }
    
    var userInfo:UserInfo? {
        return self.getUser()
    }
    
    public func processInfoAfterLogin(token:String) {
        //1. 持久化token 2.setHttpHeader 3. 请求 me 接口 4. 渲染ui
        self.saveToken(token)
//        ApolloClientTools.sharedInstance.setGlobalHttpHeaderToken(token)
        self.fetchMeInfo { result in
            if result {
            }
        }
    }
    
    public func performLogout() {
        if InputConfig.demonstrationMode() {
            InputConfig.setDemonstrationMode(false)
        }
        PassportManager.sharedInstance.saveToken(nil)
//        PassportManager.sharedInstance.saveUser(nil)
        self.postLoginStatusChanged(false)
    }
    
    public func postLoginStatusChanged(_ login:Bool) {
        DispatchQueue.main.async {
            NotificationCenter.default.post(name: Notification.Name(USER_LOGIN_CHANGED_EVENT), object: ["status":login])
        }
    }
}

extension PassportManager : PassKeyProcessorDelegate {
    
    
    //call passkey processor
    public func createPasskey(
        anchor: ASPresentationAnchor,
        passKeyDelegate:PassPortManagerPassKeyDelegate
    ) {
        self.passKeyDelegate = passKeyDelegate
        self.passKeyProcessor.createPasskey(anchor: anchor)
    }
    
    //passkey processor call back
    internal func createPassKeyFinished(_ result: Bool, _ shouldToast: Bool, _ toastText: String?,
                                        _ registeringChallenge:String,
                                        _ regsiteringUsername:String,
                                        _ credentialID: String,
                                        _ clientDataJSON: String,
                                        _ attestationObject: String) {
        self.passKeyDelegate?.createPassKeyFinished(result, shouldToast, toastText,
                                                    registeringChallenge,
                                                    regsiteringUsername,
                                                    credentialID,
                                                    clientDataJSON,
                                                    attestationObject)
    }
    
    public func passKeySign(
        payload:String,
        anchor: ASPresentationAnchor,
        preferImmediatelyAvailableCredentials: Bool,
        passKeyDelegate:PassPortManagerPassKeyDelegate) {
            self.passKeyDelegate = passKeyDelegate
            self.passKeyProcessor.passkeySign(payload: payload, anchor: anchor, preferImmediatelyAvailableCredentials: preferImmediatelyAvailableCredentials)
        }
    
    //passkey processor call back
    internal func passKeySignFinished(_ result: Bool, _ shouldToast: Bool, _ toastText: String?, _ signingChallenge: String, _ credentialID: String, _ signature: String, _ clientDataJSON: String, _ authenticatorData: String) {
        self.passKeyDelegate?.passKeySignFinished(result, shouldToast, toastText,
                                                  signingChallenge, credentialID, signature, authenticatorData, clientDataJSON)
    }
}

extension PassportManager {
    public func saveToken(_ accessToken:String?) {
        UserDefaults.standard.setValue(accessToken, forKey: "User.AccessToken")
    }
    
    public func getToken() -> String? {
        if InputConfig.demonstrationMode() {
            let defaultAccessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI4NTk0ZWViNC03OGU5LTQ2MzgtOThjZS05Y2RlOTNhMGZiNWIiLCJlb2EiOiIweGFlZTJhYTMwNTM4MzBlY2Q5MGQxNzYzZTE3NDRjMjk1ZWYwN2RlOTciLCJhYSI6IjB4MWQ5YTkyNmQwMGQ2ZWIyMzY4NjlkNTE2MjhlOWU1MzJiMmU3ZDQ0YiIsImV4cCI6MTcxNDU0NzE1MCwiaWF0IjoxNzEzOTQyMzUwLCJpc3MiOiJsaW5rMy50byJ9.6GArBEQ2xLWeXHnYKPEaG-SzqI9vcTqdLML-_zBhrRc"
            return defaultAccessToken
        } else {
            return UserDefaults.standard.string(forKey: "User.AccessToken")
        }
    }
    
//    public func saveUser(_ data:Namespace_link3.MeQuery.Data.Me.Data?, pointAccount:PointAccount? = nil, pointTasks:[PointTask] = []) {
//        let defaults = UserDefaults.standard
//        guard let data = data else {
//            defaults.set(nil, forKey: "User.UserInfo")
//            Logger().log("remove local user info")
//            return
//        }
//        
//        let avatarUrl = data.lightInfo.avatar.isEmpty ? data.lightInfo.formattedAddress.generateUserAvatar() : data.lightInfo.avatar
//        let name = data.lightInfo.displayName.isEmpty ? data.lightInfo.formattedAddress : data.lightInfo.displayName
//        let type:UserType = data.turnkeyUserInfo != nil ? .passkey : .eoa
//        Logger().log("[saveUser], userType: \(type.rawValue), eoa:\(data.privateInfo?.address ?? ""), cyberaccount: \(data.v3Info?.cyberAccount ?? "")")
//        let blocks = data.profile?.asPerProfile?.blocks
//        let profileCompletionRate = 0.0
//        let userInfo = UserInfo(
//            id: data.id,
//            userType: type,
//            avatar: avatarUrl,
//            displayName: name,
//            bio: nil,
//            EOAAddress: data.privateInfo?.address,
//            formattedEOAAddress: data.lightInfo.formattedAddress,
//            cyberAccountAddress: data.v3Info?.cyberAccount,
//            v3SdkToken: data.privateInfo?.v3SdkToken,
//            profileID: data.profile?.asPerProfile?.id ?? "",
//            profileHandle: data.lightInfo.handle,
//            headlineTitle: data.profile?.asPerProfile?.headline.title,
//            headlineOrgDisplayName: data.profile?.asPerProfile?.headline.displayName,
//            headlineOrgTwitterHandle: data.profile?.asPerProfile?.headline.twitterHandle,
//            headlineOrgTwitterId: data.profile?.asPerProfile?.headline.twitterId,
//            headlineOrgTwitterAvatar: data.profile?.asPerProfile?.headline.avatar,
//            identitiesCount: data.profile?.asPerProfile?.identities?.count ?? 0,
//            turnkeyUserId:data.turnkeyUserInfo?.turnkeyUserId,
//            turnkeySubOrgId:data.turnkeyUserInfo?.subOrgId,
//            gasCreditValue:data.v3Info?.credits[safe: 0]?.balance,
//            gasDecimals: data.v3Info?.credits[safe: 0]?.decimals,
//            link3CreditTotalValue:data.dmCreditAccount.balance.value,
//            link3CreditWithdrawalbeValue:data.dmCreditAccount.withdrawableBalance.value,
//            link3CreditNonwithdrawalbeValue:data.dmCreditAccount.nonWithdrawableBalance.value,
//            link3CreditDecimals:data.dmCreditAccount.balance.decimal,
//            link3CreditCurrency: data.dmCreditAccount.balance.currency,
//            my_price_currency: data.price.price.currency,
//            my_price_value: data.price.price.value,
//            my_price_decimals: data.price.price.decimal,
//            totalEarned_value: data.totalEarned.value,
//            totalEarned_decimals: data.totalEarned.decimal,
//            discordId: data.privateInfo?.discordId,
//            twitterId: data.privateInfo?.twitterId,
//            twitterAuthorized: data.privateInfo?.twitterAuthorized,
//            email: data.privateInfo?.email ?? "asdlfjalksjdf@ss.com",
//            linkedinId: data.privateInfo?.linkedinId,
//            githubId: data.privateInfo?.githubId,
//            telegram: data.privateInfo?.telegram?.username,
//            priceFeedback_description: data.priceFeedback.description,
//            priceFeedback_feedback: data.priceFeedback.feedback?.rawValue ?? nil,
//            isVerified: data.lightInfo.isVerified,
//            EAS_uid: data.lightInfo.attestation?.uid,
//            EAS_status: data.lightInfo.attestation?.status.value?.rawValue,
//            cyberIds: data.cyberIds.map({ cyberid in
//                    .init(id: cyberid.tokenId, handle: cyberid.handle, isPrimary: cyberid.isPrimary)
//            }),
//            pointAccount: pointAccount,
//            pointTasks: pointTasks,
//            isDeleted: data.lightInfo.isDeleted,
//            profileCompletionRate: profileCompletionRate
//        )
//        // 使用 JSONEncoder 编码并存储自定义对象
//        if let encodedData = try? JSONEncoder().encode(userInfo) {
//            defaults.set(encodedData, forKey: "User.UserInfo")
//        }
//    }
    
    public func saveUser(user:UserInfo) {
        let newUser = user
        // 使用 JSONEncoder 编码并存储自定义对象
        if let encodedData = try? JSONEncoder().encode(newUser) {
            let defaults = UserDefaults.standard
            defaults.set(encodedData, forKey: "User.UserInfo")
        }
    }
    
    public func getUser() -> UserInfo? {
        let defaults = UserDefaults.standard
        // 使用 JSONDecoder 解码并获取自定义对象
        if let decodedData = defaults.data(forKey: "User.UserInfo"),
           let decodedObject = try? JSONDecoder().decode(UserInfo.self, from: decodedData) {
            return decodedObject
        }
        return nil
    }
}

extension PassportManager {
    
    public func presentPSPEntry(delay:Bool = false, delegate:PassPortManagerWCDelegate?) {
        let messageView = MessageView.viewFromNib(layout: .messageView)
        messageView.configureContent(title: "Not Login!", body: "Please connect your wallet", iconImage: nil, iconText: nil, buttonImage: nil, buttonTitle: "Connect", buttonTapHandler: { button in
            SwiftMessages.hide()
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.25) {
                self.showWCModal(delegate: delegate)
            }
        })
        var config = SwiftMessages.defaultConfig
        config.presentationStyle = .bottom
        config.duration = .forever
        config.dimMode = .gray(interactive: true)
        config.presentationContext  = .window(windowLevel: UIWindow.Level.statusBar)
        SwiftMessages.show(config: config, view: messageView)
    }
    
    public func showWCModal(delegate:PassPortManagerWCDelegate?) {
    }
}

extension PassportManager {
    public func postUserProfileChanged() {
        DispatchQueue.main.async {
            NotificationCenter.default.post(name: Notification.Name(USER_PROFILE_CHANGED), object: nil)
        }
    }
    
    public func fetchMeInfo(postLogined:Bool = true, finished:((Bool)->())? = nil) {
//        ApolloClientTools.sharedInstance.client.fetch(query: Namespace_link3.MeQuery(), cachePolicy: .fetchIgnoringCacheCompletely) { result in
//            switch result {
//            case .success(let response):
//                guard let data = response.data?.me.data else {
//                    Logger().log("[login] header query failed : \(String(describing: response.data?.me.status))")
//                    finished?(false)
//                    return
//                }
//                PassportManager.sharedInstance.saveUser(data, pointAccount: pointAccount, pointTasks: tasks)
//                if postLogined {
//                    PassportManager.sharedInstance.postLoginStatusChanged(true)
//                }
//                Logger().log("[login] header query success, \(data.lightInfo.displayName)")
//                finished?(true)
//            case .failure(let error):
//                Logger().log("[login] header query error : \(error)")
//                finished?(false)
//            }
//        }
    }
}

extension PassportManager {
    public func getUUID() -> String? {
        guard let eoaAddress = self.getUser()?.EOAAddress else {
            return nil
        }
        
        if let savedUUID = UserDefaults.standard.string(forKey: eoaAddress) {
            return savedUUID
        } else {
            return renewUUID()
        }
    }
    
    private func renewUUID() -> String {
        let uuid = UUID()
        self.saveUUID(uuid.uuidString)
        return uuid.uuidString
    }
    
    private func saveUUID(_ uuid:String) {
        guard let eoaAddress = self.getUser()?.EOAAddress else {
            return
        }
        UserDefaults.standard.set(uuid, forKey:eoaAddress)
    }
}

extension PassportManager {
    private func onboardingSwitch() -> Bool {
        return false
    }
    
    public func userBoarded() -> Bool {
        guard let userInfo = self.getUser(),
              let eoaAddress = userInfo.EOAAddress else {
            return false
        }
        let result = UserDefaults.standard.bool(forKey: "\(eoaAddress).Boarded")
        return result
    }
    
    public func setUserBoarded(boarded:Bool) {
        guard let userInfo = self.getUser(),
              let eoaAddress = userInfo.EOAAddress else {
            return
        }
        UserDefaults.standard.setValue(boarded, forKey: "\(eoaAddress).Boarded")
    }
    
    public func checkShowOnboardingV2() -> Bool {
//        return true//to be deleted
        guard onboardingSwitch() else {
            return false
        }
        guard let userInfo = self.getUser() else {
            return false
        }
        let userBoarded = userBoarded()
        Logger().log("[checkShowOnboardingV2] userBoarded = \(userBoarded)")
        return !userBoarded
    }
}
