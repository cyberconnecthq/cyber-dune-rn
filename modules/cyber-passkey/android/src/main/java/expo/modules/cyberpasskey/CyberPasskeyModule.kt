package expo.modules.cyberpasskey

import android.app.Activity
import android.content.Context
import android.content.Intent
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class CyberPasskeyModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('CyberPasskey')` in JavaScript.
    Name("CyberPasskey")

    // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
    Constants(
      "PI" to Math.PI
    )

    // Defines event names that the module can send to JavaScript.
    Events("onChange")

    // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    Function("hello") {
      "Hello world! 👋"
    }

    Function("getEOA") {
        val sharedPref = appContext.currentActivity?.getSharedPreferences("com.cyberconnect.link3.preference", Context.MODE_PRIVATE)
        if (sharedPref != null) sharedPref.getString("wallet", null) else null
    }

    Function("getAvatar") {
      "https://ccgateway.infura-ipfs.io/ipfs/QmUjoJbH21wJZWtib3zQarhewyazXY4VWfQzeV8F4v5nPc"
    }

    Function("startActivity") {
      appContext.currentActivity?.let {
//        it.startActivity(Intent(it, PasskeyActivity::class.java))
        it.startActivity(Intent("com.cyberconnect.link3.PASSKEY"))
      }
    }

    // Defines a JavaScript function that always returns a Promise and whose native code
    // is by default dispatched on the different thread than the JavaScript runtime runs on.
    AsyncFunction("setValueAsync") { value: String ->
      // Send an event to JavaScript.
      sendEvent("onChange", mapOf(
        "value" to value
      ))
    }

    // Enables the module to be used as a native view. Definition components that are accepted as part of
    // the view definition: Prop, Events.
    View(CyberPasskeyView::class) {
      // Defines a setter for the `name` prop.
      Prop("name") { view: CyberPasskeyView, prop: String ->
        println(prop)
      }
    }
  }
}
