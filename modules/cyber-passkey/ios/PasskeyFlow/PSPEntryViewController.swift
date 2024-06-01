//
//  PSPEntryViewController.swift
//  DApp
//
//  Created by spantar on 2023/7/25.
//

import Foundation
import UIKit
import Combine
import ProgressHUD
//import metamask_ios_sdk
import ActiveLabel
import CryptoKit
import SnapKit
import Apollo

class PSPEntryViewController:UIViewController, PassPortManagerWCDelegate, UISheetPresentationControllerDelegate {
    
    func viewControllerForSignRequest() -> UIViewController {
        return self
    }
    
    private lazy var backImg = {
        let view = UIImageView(frame: .zero)
        view.contentMode = .scaleAspectFill
        view.image = UIImage(named: "ob_back")
        view.isUserInteractionEnabled = true
        view.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(tapBack)))
        return view
    }()
    private lazy var logoImg = {
        let view = UIImageView(frame: .zero)
        view.contentMode = .scaleAspectFit
        view.image = UIImage(named: "logo_white")
        return view
    }()
    
    private lazy var lineView = {
        let view = UIImageView(frame: .zero)
        view.contentMode = .scaleAspectFill
        view.image = UIImage(named: "separaotor_line_horizontal")
        view.isHidden = true
        return view
    }()
    
    private lazy var demonstrationMode:ImpactButton = {
        let view = ImpactButton(image: nil, frame: .zero)
        view.setTitleColor(UIColor(red: 0.08, green: 0.08, blue: 0.08, alpha: 1), for: .normal)
        view.titleLabel?.font = UIFont.systemFont(ofSize: 16)
        view.setTitle("Demonstration Mode", for: .normal)
        view.addTarget(self, action: #selector(enterDemonstrationMode), for: .touchUpInside)
        view.isHidden = !InputConfig.reviewSwitch()
        return view
    }()
    
    private lazy var sloganLbl = {
        let view = UILabel(frame: .zero)
        view.textColor = UIColor.white
        view.font = UIFont.systemFont(ofSize: 24, weight: .bold)
        
        view.numberOfLines = 0
        view.text = "Professional Networking Reimagined"
        view.isHidden = true
        return view
    }()
    
    private lazy var titleLbl = {
        let view = UILabel(frame: .zero)
        view.textColor = UIColor.white
        view.font = UIFont.systemFont(ofSize: 18, weight: .bold)
        view.text = "New to CyberDune?"
        return view
    }()
    
    private lazy var inputTextField:InsetIndicatorTextField = {
        let view = InsetIndicatorTextField(frame: .zero, contentInset: UIEdgeInsets(top: 0, left: Distance.secondary_margin, bottom: 0, right: Distance.secondary_margin+kCloseIconSize), showIndicator: false, showCloseIcon: true)
        view.updateCloseEnable(false)
        view.clearTapped = {
            self.updateSendButtonStatus(false)
        }
        view.layer.cornerRadius = Radius.textfield_radius
        view.backgroundColor = UIColor.Border_200
        view.attributedPlaceholder = NSAttributedString(string: "Enter e-mail here", attributes: [NSAttributedString.Key.foregroundColor: UIColor.Grey_07_secondary_text, NSAttributedString.Key.font: UIFont.systemFont(ofSize: 16)])
        view.textColor = .white
        view.delegate = self
        return view
    }()
    
    private lazy var passkeyLogin:ImpactButton = {
        let view = ImpactButton(image: UIImage(named: "passkey_logo"), frame: .zero, backgroundColor: .clear)
        view.layer.borderColor = UIColor.white.cgColor
        view.layer.borderWidth = 1.0
        view.setBackgroundImage(nil, for: .normal)
        view.setBackgroundImage(nil, for: .highlighted)
        view.setTitleColor(.white, for: .normal)
        view.titleLabel?.font = UIFont.systemFont(ofSize: 16)
        view.setTitle("Sign in with your passkey", for: .normal)
        view.addTarget(self, action: #selector(passkeyLoginAction), for: .touchUpInside)
        return view
    }()
    
    private lazy var passkeyCreate:ImpactButton = {
        let view = ImpactButton(image: UIImage(named: "passkey_add"), frame: .zero)
        view.setTitleColor(.Background_200, for: .normal)
        view.titleLabel?.font = UIFont.systemFont(ofSize: 16)
        view.setTitle("Sign up with a passkey", for: .normal)
        view.addTarget(self, action: #selector(passkeyCreateAction), for: .touchUpInside)
        return view
    }()
    
    private func updateSendButtonStatus(_ enable:Bool) {
        passkeyLogin.isEnabled = enable
        passkeyLogin.setBackgroundImage(enable ? UIImage.imageWithColor(color: .Primary_Default) :  UIImage.imageWithColor(color: .Grey_400), for: .normal)
        passkeyLogin.setTitleColor(enable ? .Grey_10 : .Grey_500, for: .normal)
    }
    
    private lazy var orLbl:UILabel = {
        let view = UILabel(frame: .zero)
        view.textColor = UIColor.white
        view.font = UIFont.systemFont(ofSize: 18, weight: .bold)
        view.text = "Existing user?"
        return view
    }()
    
    private lazy var connectWalletButton:ImpactButton = {
        let view = ImpactButton(image: UIImage(named: "login_wallet"), frame: .zero)
        
        view.layer.borderColor = UIColor.Primary_Active.cgColor
        view.layer.borderWidth = 1.0
        view.backgroundColor = .clear
        view.setBackgroundImage(nil, for: .normal)
        view.setBackgroundImage(nil, for: .highlighted)
        view.setTitleColor(.white, for: .normal)
        view.setTitle("Connect Wallet", for: .normal)
        view.addTarget(self, action: #selector(connectAction), for: .touchUpInside)
        view.isHidden = true
        return view
    }()
    
    private lazy var confirmButton : ImpactButton = {
        let confirm = ImpactButton(image: nil, frame: .zero)
        confirm.setTitleColor(.Background_200, for: .normal)
        confirm.titleLabel?.font = UIFont.systemFont(ofSize: 16)
        confirm.setTitle("Confirm Authentication", for: .normal)
        confirm.addTarget(self, action: #selector(passkeyLoginAction), for: .touchUpInside)
        return confirm
    }()
    
    private lazy var infoLable : UILabel = {
        let view = UILabel(frame: .zero)
        view.textColor = UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        view.font = UIFont.systemFont(ofSize: 14)
        view.text = "*Recommended for existing users"
        view.isHidden = true
        return view
    }()
    
    private lazy var itemLabel : ActiveLabel = {
        let label = ActiveLabel(frame: .zero)
        let customType0 = ActiveType.custom(pattern: "\\ Privacy Policy")
        let customType1 = ActiveType.custom(pattern: "\\ End-User License Agreement")
        label.enabledTypes = [customType0, customType1]
        label.numberOfLines = 2
        let text = "Logging in signifies that you agree to our Privacy Policy and End-User License Agreement."
        label.text = text
        label.font = UIFont.systemFont(ofSize: 14)
        label.textColor = UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        label.customColor[customType0] = .white
        label.customColor[customType1] = .white
        label.handleCustomTap(for: customType0, handler: { (customType) in
            if let url = URL(string: InputConfig.PRIVACY_POLICY),
               UIApplication.shared.canOpenURL(url) {
                UIApplication.shared.open(url, options: [:], completionHandler: nil)
            }
        })
        label.handleCustomTap(for: customType1, handler: { (customType) in
            if let url = URL(string: InputConfig.EULA),
               UIApplication.shared.canOpenURL(url) {
                UIApplication.shared.open(url, options: [:], completionHandler: nil)
            }
        })
        label.isHidden = true
        return label
    }()
    
    func setUpSubviews() {
        self.view.addSubview(backImg)
        self.view.addSubview(logoImg)
        self.view.addSubview(sloganLbl)
        self.view.addSubview(titleLbl)
        self.view.addSubview(passkeyCreate)
        self.view.addSubview(passkeyLogin)
        self.view.addSubview(orLbl)
        self.view.addSubview(connectWalletButton)
        self.view.addSubview(infoLable)
        self.view.addSubview(lineView)
        self.view.addSubview(demonstrationMode)
        self.view.addSubview(itemLabel)
    }
    
    func makeConstraints() {
        backImg.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
        
        logoImg.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin_large)
            make.top.equalToSuperview().offset(UIDevice.xp_navigationFullHeight() + Distance.primary_margin_large)
            make.width.equalTo(112)
            make.height.equalTo(25)
        }
        
        sloganLbl.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.top.equalTo(logoImg.snp.bottom).offset(215.0/844.0 * UIDevice.xp_screenHeight())
        }
        demonstrationMode.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(SizeSet.button_height)
            make.bottom.equalTo(sloganLbl.snp.top).offset(-Distance.primary_margin_large)
        }
        titleLbl.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.top.equalToSuperview().offset(0.5 * UIDevice.xp_screenHeight())
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(24)
        }
        
        passkeyCreate.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.top.equalTo(titleLbl.snp.bottom).offset(Distance.primary_margin_large)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(SizeSet.button_height)
        }
        
        orLbl.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.top.equalTo(passkeyCreate.snp.bottom).offset(Distance.primary_margin_large)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(24)
        }
        
        passkeyLogin.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.top.equalTo(orLbl.snp.bottom).offset(Distance.primary_margin_large)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(SizeSet.button_height)
        }
        
        connectWalletButton.snp.makeConstraints { make in
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.top.equalTo(passkeyLogin.snp.bottom).offset(Distance.primary_margin)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
            make.height.equalTo(SizeSet.button_height)
        }
        infoLable.snp.makeConstraints { make in
            make.centerX.equalToSuperview()
            make.top.equalTo(connectWalletButton.snp.bottom).offset(Distance.padding_between_card)
        }
        itemLabel.snp.makeConstraints { make in
            make.centerX.equalToSuperview()
            make.bottom.equalToSuperview().offset(-Distance.padding_between_card - UIDevice.xp_safeDistanceBottom())
            make.left.equalToSuperview().offset(Distance.primary_margin)
            make.right.equalToSuperview().offset(-Distance.primary_margin)
        }
        
        lineView.snp.makeConstraints { make in
            make.top.equalToSuperview().offset(0.55 * UIDevice.xp_screenHeight())
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setUpSubviews()
        self.makeConstraints()
        self.observeNotification()
    }
    
    deinit {
        NotificationCenter.default.removeObserver(self)
    }
    
    @objc func enterDemonstrationMode() {
        InputConfig.setDemonstrationMode(true)
        guard let accessToken = PassportManager.sharedInstance.getToken() else {
            return
        }
        PassportManager.sharedInstance.processInfoAfterLogin(token: accessToken)
        self.navigationController?.dismiss(animated: true)
    }
    
    @objc func passkeyCreateAction() {
        guard let window = self.view.window else { fatalError("The view was not in the app's view hierarchy!") }
        PassportManager.sharedInstance.createPasskey(anchor: window, passKeyDelegate: self)
    }
    
    private func showOneLastStep() {
        self.passkeyLoginAction()
    }
    
    @objc func closeSheet() {
        DispatchQueue.main.async {
            
        }
    }
    
    @objc func passkeyLoginAction() {
        self.confirmButton.stateManager.state = true
        self.passkeyLogin.stateManager.state = true
        guard let window = self.view.window else { fatalError("The view was not in the app's view hierarchy!") }
        let turnkeyPayload = "{\"organizationId\":\"\(InputConfig.TURNKEY_ORG_ID)\"}"
        PassportManager.sharedInstance.passKeySign(payload: turnkeyPayload, anchor: window, preferImmediatelyAvailableCredentials: false, passKeyDelegate: self)
    }
    
    @objc private func connectAction() {
        PassportManager.sharedInstance.showWCModal(delegate: self)
    }
    
    func makeToast(text:String) {
    }
    
    private func observeNotification() {
        NotificationCenter.default.addObserver(self, selector: #selector(handleNotification(_:)), name: Notification.Name(USER_LOGIN_CHANGED_EVENT), object: nil)
    }
    
    @objc private func handleNotification(_ notification: Notification) {
        if let userInfo = notification.object as? [String:Any] {
            // 从通知的 userInfo 中获取额外的信息
            if let login = userInfo["status"] as? Bool,
               login == true {
                self.navigationController?.dismiss(animated: true)
            }
        }
    }
    
    @objc private func tapBack() {
        self.inputTextField.resignFirstResponder()
    }
}

extension PSPEntryViewController : UITextFieldDelegate {
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        // 检查输入的字符
        if let text = textField.text, let textRange = Range(range, in: text) {
            let updatedText = text.replacingCharacters(in: textRange, with: string)
            let enable = self.isValidEmail(updatedText)
            self.updateSendButtonStatus(enable)
            self.inputTextField.updateCloseEnable(!updatedText.isEmpty)
        }
        
        // 返回 true 允许输入字符，返回 false 则不允许输入字符
        return true
    }
    
    private func isValidEmail(_ email: String) -> Bool {
        // 定义邮箱地址的正则表达式模式
        let emailRegex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
        
        // 创建 NSPredicate 对象来匹配邮箱地址
        let emailTest = NSPredicate(format: "SELF MATCHES %@", emailRegex)
        
        // 使用 NSPredicate 进行匹配
        return emailTest.evaluate(with: email)
    }
    
}

extension PSPEntryViewController : PassPortManagerPassKeyDelegate {
    
    func createPassKeyFinished(_ result: Bool, _ shouldToast: Bool, _ toastText: String?,
                               _ registeringChallenge:String,
                               _ regsiteringUsername:String,
                               _ credentialID: String,
                               _ clientDataJSON: String,
                               _ attestationObject: String) {
//        let request = Namespace_link3.RegisterTurnkeyUserRequest.init(challenge: registeringChallenge, attestation: Namespace_link3.PasskeyAttestation(attestationObject: attestationObject, clientDataJson: clientDataJSON, credentialId: clientDataJSON, transports: .some([GraphQLEnum(Namespace_link3.PasskeyTransport.authenticatorTransportInternal)])), authenticatorName: regsiteringUsername)
//        guard result else {
//            if shouldToast {
//                self.makeToast(text: toastText ?? "Failed to create")
//            }
//            return
//        }
//        
//        ApolloClientTools.sharedInstance.client.perform(mutation: Namespace_link3.TurnkeyUserRegisterMutation(request: request)) { result in
//            switch result {
//            case .success(let response):
//                guard let data = response.data?.turnkeyUserRegister,
//                      data.status == .success else {
//                    Logger().log("[request_server]: turn key user register failed, \(String(describing: response.data?.__data))")
//                    self.makeToast(text: toastText ?? "Failed to Register")
//                    return
//                }
//                Logger().log("[passkey]: turn key register success")
//                self.showOneLastStep()
//            case .failure(let err):
//                Logger().log("[request_server]: turn key user register failed, \(err)")
//                self.makeToast(text: toastText ?? "Network error")
//            }
//        }
        
        self.showOneLastStep()
    }
    
    func passKeySignFinished(_ result: Bool, _ shouldToast: Bool, _ toastText: String?, _ signingChallenge: String, _ credentialID: String, _ signature: String, _ authenticatorData: String, _ clientDataJSON: String) {
        
        let turnKeyLoginUrl = "https://api.turnkey.com/public/v1/query/whoami"
        let turnKeyPayload = "{\"organizationId\":\"\(InputConfig.TURNKEY_ORG_ID)\"}"
        let turnKeyHeaderValue =  "{\"authenticatorData\":\"\(authenticatorData)\",\"clientDataJson\":\"\(clientDataJSON)\",\"credentialId\":\"\(credentialID)\",\"signature\":\"\(signature)\"}"
//        ApolloClientTools.sharedInstance.client.fetch(
//            query: Namespace_cyber_dune.TurnkeyUserLoginQuery(request: Namespace_link3.ForwardTurnkeyRequest.init(type: GraphQLEnum(Namespace_link3.TurnkeyRequestType.whoAmI), url:turnKeyLoginUrl, body: turnKeyPayload, stamp: Namespace_link3.TurnkeyStamp.init(stampHeaderName: "X-Stamp-Webauthn", stampHeaderValue: turnKeyHeaderValue))),
//            cachePolicy: .fetchIgnoringCacheCompletely) { result in
//                self.confirmButton.stateManager.state = false
//                self.passkeyLogin.stateManager.state = false
//                switch result {
//                case .success(let response):
//                    guard let data = response.data?.turnkeyUserLogin,
//                          data.status == .success else {
//                        Logger().log("[request_server]: turn key user login failed, \(String(describing: response.data?.__data))")
//                        self.makeToast(text: toastText ?? "Failed to login")
//                        return
//                    }
//                    Logger().log("[passkey]: turn key login success")
//                    guard let token = data.user?.privateInfo?.accessToken else {
//                        Logger().log("[passkey]: turn key login without accessToken return")
//                        return
//                    }
//                    
//                    PassportManager.sharedInstance.processInfoAfterLogin(token:token)
//                case .failure(let err):
//                    Logger().log("[request_server]: turn key user login failed, \(err)")
//                    self.makeToast(text: toastText ?? "Network error")
//                }
//            }
        let defaultAccessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI4NTk0ZWViNC03OGU5LTQ2MzgtOThjZS05Y2RlOTNhMGZiNWIiLCJlb2EiOiIweGFlZTJhYTMwNTM4MzBlY2Q5MGQxNzYzZTE3NDRjMjk1ZWYwN2RlOTciLCJhYSI6IjB4MWQ5YTkyNmQwMGQ2ZWIyMzY4NjlkNTE2MjhlOWU1MzJiMmU3ZDQ0YiIsImV4cCI6MTcxNDU0NzE1MCwiaWF0IjoxNzEzOTQyMzUwLCJpc3MiOiJsaW5rMy50byJ9.6GArBEQ2xLWeXHnYKPEaG-SzqI9vcTqdLML-_zBhrRc"
        PassportManager.sharedInstance.processInfoAfterLogin(token:defaultAccessToken)
        DispatchQueue.main.asyncAfter(deadline: .now()+1.0) {
            self.navigationController?.dismiss(animated: true)
        }
    }
}

extension UIImage {
    static func imageWithColor(color: UIColor) -> UIImage {
        let rect = CGRect(x: 0, y: 0, width: 1, height: 1)
        UIGraphicsBeginImageContext(rect.size)
        let context = UIGraphicsGetCurrentContext()
        context?.setFillColor(color.cgColor)
        context?.fill(rect)
        let image = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return image ?? UIImage()
    }
    
    func uniqueStringHash() -> String? {
        guard let imageData = self.pngData() else {
            return nil
        }

        let hashedData = SHA256.hash(data: imageData)
        let hashString = hashedData.compactMap { String(format: "%02x", $0) }.joined()

        return hashString
    }
}
