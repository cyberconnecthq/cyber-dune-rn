//
//  InputConfig.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation

enum RunningEnvironment {
    case prd
    case stg
}

struct InputConfig {
    
    static var projectId: String {
        guard let projectId = config(for: "PROJECT_ID"), !projectId.isEmpty else {
            fatalError("PROJECT_ID is either not defined or empty in Configuration.xcconfig")
        }
        
        return projectId
    }
    
    private static func config(for key: String) -> String? {
        return Bundle.main.object(forInfoDictionaryKey: key) as? String
    }
}
extension InputConfig {
    static var RUNNING_ENVIORNMENT:RunningEnvironment = {
        if let str = UserDefaults.standard.string(forKey: "InputConfig.RUNNING_ENVIORNMENT") {
            return str == "stg" ? .stg : .prd
        }
        return .prd
    }()
    
    static func changeEnv(env:RunningEnvironment) {
        UserDefaults.standard.setValue(env == .stg ? "stg" : "prd", forKey: "InputConfig.RUNNING_ENVIORNMENT")
    }
    
    static let apolloUrl = RUNNING_ENVIORNMENT == .stg ? "https://api.stg.cyberconnect.dev/profile/" : "https://api.cyberconnect.dev/profile/"
    
    static let link3Domain = "link3.to"
    static let link3Url = "https://link3.to"
    static let link3IconUrl = "https://ccgateway.infura-ipfs.io/ipfs/QmPg7VodxJRtWb9jbbJLxExAGoJUA18zj4UdPjoH9MPac9"
    
    static let loginChainId = 1
    
    static let chainId = RUNNING_ENVIORNMENT == .stg ? 11155420 : 10
    
    static let timeoutInterval = 30.0
}

extension InputConfig {
    static let APP_ID = RUNNING_ENVIORNMENT == .prd ? "943b6504-6f8e-438e-8cb4-65c30be7f1a4" : "0eb3b939-d21d-4759-8498-e91baeda88b2"
    static let ENTRY_POINT = "0x5FF137D4b0FDCD49DcA30c7CF57E578a026d2789"
    static let ENGINE_ADDRESS = "0x4bc54260ec3617b3f73fdb1fa22417ed109f372c"
    
    static let PAYMASTER_API_URL = RUNNING_ENVIORNMENT == .stg ? "https://api.stg.cyberconnect.dev/cyberaccount/paymaster/v1/rpc" :  "https://api.cyberconnect.dev/cyberaccount/paymaster/v1/rpc"
    static let BUNDLER_API_URL = RUNNING_ENVIORNMENT == .stg ?
    "https://api.stg.cyberconnect.dev/cyberaccount/bundler/v1/rpc" :
    "https://api.cyberconnect.dev/cyberaccount/bundler/v1/rpc"
    
    
    static let METHOD_ESTIMATE_GAS = "cc_estimateUserOperation"
    static let METHOD_USER_OPERATION = "cc_sponsorUserOperation"
    static let METHOD_REJECT = "cc_rejectUserOperation"
    static let METHOD_LIST_PENDING = "cc_listPendingUserOperations"
    static let METHOD_SEND_OPERATION = "eth_sendUserOperation"

    static let TURNKEY_ORG_ID = RUNNING_ENVIORNMENT == .stg ?
    "f583a354-edd1-4e33-bc59-1dacedd9c7d9" :
    "889d8cfa-e41c-410a-a097-252ca1ab0500"
    
    
    static let MULTI_SEND_ADDRESS = "0x8ae01fCF7c655655fF2c6Ef907b8B4718Ab4e17c"
    static let PAY_MESSAGE_CONTRACT_ADDRESS = RUNNING_ENVIORNMENT == .stg ? "0x5254857780901d6cc80e42946a7d101fe8667ea8" : "0x5b3A81f9B29E51518316B4E2B8FD5986a3785CA4"
    static let TOP_UP_SMART_GAS_ADDRESS = "0xcd97405fb58e94954e825e46db192b916a45d412"
    
    
    static let RECAPTCHAKEY = "6LdHgEopAAAAAFbe487wWfVKTpbwbIgIi0AXWDBB"
    
    static let PREVIEW_TOKEN_URL = "https://api.link3.to/api/previewToken"
    
    static let FIELD_OF_STUDY_QUERY = "https://api.link3.to/api/getOptions"
}

extension InputConfig {
    //TODO: may occur rate limited, better first infura, then fall back
    static let OP_NETWORK_URL = RUNNING_ENVIORNMENT == .stg ? "https://sepolia.optimism.io" : "https://mainnet.optimism.io"
    
    static let OP_ETHERSCAN = RUNNING_ENVIORNMENT == .stg ? "https://sepolia-optimism.etherscan.io/tx/" : "https://optimistic.etherscan.io/tx/"
    
    static let OP_NETWORK_CURRENCY = RUNNING_ENVIORNMENT == .stg ? "0x5fd84259d66Cd46123540766Be93DFE6D43130D7" : "0x94b008aa00579c1307b0ef2c499ad98a8ce58e58"
    
    static let PROFILE_SNAPSHOT_URI = "https://hub.snapshot.org/graphql"
    static let PROFILE_GALAXY_HOST_URI = "https://graphigo.prd.galaxy.eco/query"
    static let PROFILE_POAP_HOST_URI = "https://api.poap.tech/actions/scan/"
    static let PROFILE_EAS_DOMAIN = RUNNING_ENVIORNMENT == .stg ? "https://base-sepolia.easscan.org" : "https://optimism.easscan.org"
    
    static let PROFILE_EAS_URI = RUNNING_ENVIORNMENT == .stg ? "https://base-sepolia.easscan.org/graphql" : "https://optimism.easscan.org/graphql"
    
    
    static let DEPOSIT_WEB_URI = RUNNING_ENVIORNMENT == .stg ? "https://stg.link3.to/d/deposit?" : "https://link3.to/d/deposit?"
    
    static let MINT_CYBER_ID_URL = RUNNING_ENVIORNMENT == .stg ? "https://stg.link3.to/d/mint-cyberid" : "https://link3.to/d/mint-cyberid"
    
    static let PRIVACY_POLICY = "https://cyberconnect.notion.site/Privacy-Policy-6e40f8c5945e4a9a98bc5514b367061b?pvs=4"
    static let EULA = "https://cyberconnect.notion.site/END-USER-LICENSE-AGREEMENT-1f90d17943ee469b8627bc5399eb86d3?pvs=4"
    
}

struct FakePointsFromCredit : Codable {
    var value:Double
    var time:String
}

extension InputConfig {
    
    static func reviewSwitch() -> Bool {
        return false
    }
    
    static func usdtName() -> String {
        return "crd"
    }
    
    static func demonstrationMode() -> Bool {
        if InputConfig.reviewSwitch() {
            return UserDefaults.standard.bool(forKey: "User.DemonstrationMode")
        } else {
            return false
        }
    }
    
    static func setDemonstrationMode(_ open:Bool) {
        UserDefaults.standard.setValue(open, forKey: "User.DemonstrationMode")
    }
}
