//
//  Device+Extensions.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation
import UIKit

extension UIDevice {
    
    /// 顶部安全区高度
    static func xp_safeDistanceTop() -> CGFloat {
        if #available(iOS 13.0, *) {
            let scene = UIApplication.shared.connectedScenes.first
            guard let windowScene = scene as? UIWindowScene else { return 0 }
            guard let window = windowScene.windows.first else { return 0 }
            return window.safeAreaInsets.top
        }
        return 0;
    }
    
    /// 底部安全区高度
    static func xp_safeDistanceBottom() -> CGFloat {
        if #available(iOS 13.0, *) {
            let scene = UIApplication.shared.connectedScenes.first
            guard let windowScene = scene as? UIWindowScene else { return 0 }
            guard let window = windowScene.windows.first else { return 0 }
            return window.safeAreaInsets.bottom
        }
        return 0;
    }
    
    /// 顶部状态栏高度（包括安全区）
    static func xp_statusBarHeight() -> CGFloat {
        var statusBarHeight: CGFloat = 0
        if #available(iOS 13.0, *) {
            let scene = UIApplication.shared.connectedScenes.first
            guard let windowScene = scene as? UIWindowScene else { return 0 }
            guard let statusBarManager = windowScene.statusBarManager else { return 0 }
            statusBarHeight = statusBarManager.statusBarFrame.height
        }
        return statusBarHeight
    }
    
    /// 导航栏高度
    static func xp_navigationBarHeight() -> CGFloat {
        return 44.0
    }
    
    /// 状态栏+导航栏的高度
    static func xp_navigationFullHeight() -> CGFloat {
        return UIDevice.xp_statusBarHeight() + UIDevice.xp_navigationBarHeight()
    }
    
    /// 底部导航栏高度
    static func xp_tabBarHeight() -> CGFloat {
        return 49.0
    }
    
    /// 底部导航栏高度（包括安全区）
    static func xp_tabBarFullHeight() -> CGFloat {
        return UIDevice.xp_tabBarHeight() + UIDevice.xp_safeDistanceBottom()
    }
    
    /// 屏幕宽度
    static func xp_screenWidth() -> CGFloat {
        return min(UIScreen.main.bounds.width, UIScreen.main.bounds.height)
    }
    
    /// 屏幕高度
    static func xp_screenHeight() -> CGFloat {
        return max(UIScreen.main.bounds.width, UIScreen.main.bounds.height)
    }
}

extension UIView {
    //radius:切圆角的半径
    //corner:要切四个角中的哪个角
    func cornerCut(radius:Int,corner:UIRectCorner){
        let maskPath = UIBezierPath.init(roundedRect: bounds, byRoundingCorners: corner, cornerRadii: CGSize.init(width: radius, height: radius))
        let maskLayer = CAShapeLayer()
        maskLayer.frame = bounds
        maskLayer.path = maskPath.cgPath
        layer.mask = maskLayer
    }
}
