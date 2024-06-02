const getUniqueIdentifier = () => {
    return 'com.cc.link3';
};


export default {
    name: "CyberDune",
    ios: {
        buildNumber: "1.0.0",
        bundleIdentifier: "com.cc.link3",
        "associatedDomains": [
            "webcredentials:link3.to"
        ],
        supportsTablet: true
    },
    android: {
        versionCode: 1,
        adaptiveIcon: {
            foregroundImage: "./assets/images/logo.png",
            backgroundColor: "#FFFFFF"
        },
        package: "com.cyberconnnect.link3"
    },
    scheme: "cyberdune",
    slug: "cyber-dune",
    version: "1.0.0",
    orientation: "portrait",
    icon: "./assets/images/logo.png",
    userInterfaceStyle: "light",
    splash: {
        image: "./assets/images/splash.png",
        resizeMode: "contain",
        backgroundColor: "#25292e"
    },
    platforms: ["ios", "android", "web"],
    updates: {
        fallbackToCacheTimeout: 0
    },
    assetBundlePatterns: [
        "**/*"
    ],
    web: {
        favicon: "./assets/images/favicon.png"
    },
    plugins: [
        "expo-router",
        [
            "expo-build-properties",
            {
                ios: {
                    deploymentTarget: '16.0'
                }
            }
        ],
        [
            "expo-camera",
            {
              "cameraPermission": "Allow $(PRODUCT_NAME) to access your camera",
              "microphonePermission": "Allow $(PRODUCT_NAME) to access your microphone",
              "recordAudioAndroid": true
            }
          ]
    ],
    owner: "damien8201",
    extra: {
        eas: {
          projectId: "204e3d50-9b8f-4bf8-921d-2a4d1b2e535f"
        }
      },
      "updates": {
        "url": "https://u.expo.dev/204e3d50-9b8f-4bf8-921d-2a4d1b2e535f"
      },
      "runtimeVersion": "1.0.0"
};

