import ExpoModulesCore

public class CyberPasskeyModule: Module {
    // Each module class must implement the definition function. The definition consists of components
    // that describes the module's functionality and behavior.
    // See https://docs.expo.dev/modules/module-api for more details about available components.
    public func definition() -> ModuleDefinition {
        // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
        // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
        // The module will be accessible from `requireNativeModule('CyberPasskey')` in JavaScript.
        Name("CyberPasskey")
        
        // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
        Constants([
            "PI": Double.pi
        ])
        
        // Defines event names that the module can send to JavaScript.
        Events("onChange")
        Events("onLogin")
        
        // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
        Function("presentPasskeyViewController") {
            print("present passkey vc")
            DispatchQueue.main.async {
                if let rootViewController = UIApplication.shared.delegate?.window??.rootViewController {
                    let entryVC = PSPEntryViewController()
                    entryVC.onDismiss = {
                        self.sendEvent("onLogin", [:])
                    }
                    let navigatorVC = PSPEntryNavigationViewController(rootViewController: entryVC)
                    navigatorVC.modalPresentationStyle = .fullScreen
                    rootViewController.present(navigatorVC, animated: true)
                }
            }
        }
      
      Function("getEOA") { () -> String? in
          if PassportManager.sharedInstance.logined {
              return PassportManager.sharedInstance.getEOA()
          } else {
              return nil
          }
      }
      
      
      Function("getAvatar") { () -> String? in
          if PassportManager.sharedInstance.logined {
              return PassportManager.sharedInstance.getEOA().generateUserAvatar()
          } else {
              return nil
          }
      }
        
        Function("logout") {
            if PassportManager.sharedInstance.logined {
                PassportManager.sharedInstance.performLogout()
            }
        }

      
      Function("setTotalStakedCyber") { (total: String) -> Void in
        UserDefaults.standard.set(total, forKey:"totalStakedCyber")
      }

      
    // Defines a JavaScript function that always returns a Promise and whose native code
    // is by default dispatched on the different thread than the JavaScript runtime runs on.
    AsyncFunction("setValueAsync") { (value: String) in
      // Send an event to JavaScript.
      self.sendEvent("onChange", [
        "value": value
      ])
    }

    // Enables the module to be used as a native view. Definition components that are accepted as part of the
    // view definition: Prop, Events.
    View(CyberPasskeyView.self) {
      // Defines a setter for the `name` prop.
      Prop("name") { (view: CyberPasskeyView, prop: String) in
        print(prop)
      }
    }
  }
}
