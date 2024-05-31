const getUniqueIdentifier = () => {
    return 'com.cc.link3';
};


export default {
    name: "CyberDune",
    ios: {
        buildNumber: "1.0.0",
        bundleIdentifier: "com.cc.link3",
        supportsTablet: true
    },
    android: {
        versionCode: 1,
        adaptiveIcon: {
            foregroundImage: "./assets/images/logo.png",
            backgroundColor: "#FFFFFF"
        },
        package: "com.cc.link3"
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
        "expo-router"
    ],
    owner: "darx"
};
