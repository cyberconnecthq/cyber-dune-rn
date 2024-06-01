//
//  Color+Extensions.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation
import UIKit

extension UIColor {
    public static let Brand_200 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.65, green: 0.96, blue: 0.84, alpha: 1)
        } else {
            return UIColor(red: 0.65, green: 0.96, blue: 0.84, alpha: 1)
        }
    }
    public static let Brand_500 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.05, green: 0.71, blue: 0.55, alpha: 1)
        } else {
            return UIColor(red: 0.05, green: 0.71, blue: 0.55, alpha: 1)
        }
    }
    public static let Brand_900 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.02, green: 0.31, blue: 0.26, alpha: 1)
        } else {
            return UIColor(red: 0.02, green: 0.31, blue: 0.26, alpha: 1)
        }
    }
    public static let Brand_Background = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.14, green: 0.20, blue: 0.19, alpha: 1)
        } else {
            return UIColor(red: 0.14, green: 0.20, blue: 0.19, alpha: 1)
        }
    }
    public static let Primary_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        } else {
            return UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        }
    }
    public static let Primary_Active = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        } else {
            return UIColor(red: 1, green: 1, blue: 1, alpha: 1)
        }
    }
    
    public static let Primary_Disabled = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        } else {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        }
    }
    
    public static let Background_0 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.00, green: 0.00, blue: 0.00, alpha: 1)
        } else {
            return UIColor(red: 0.00, green: 0.00, blue: 0.00, alpha: 1)
        }
    }
    
    public static let Background_100 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.12, green: 0.12, blue: 0.12, alpha: 1)
        } else {
            return UIColor(red: 0.12, green: 0.12, blue: 0.12, alpha: 1)
        }
    }

    public static let Background_200 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.08, green: 0.08, blue: 0.08, alpha: 1)
        } else {
            return UIColor(red: 0.08, green: 0.08, blue: 0.08, alpha: 1)
        }
    }
    
    public static let Background_250 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.17, green: 0.17, blue: 0.17, alpha: 1)
        } else {
            return UIColor(red: 0.17, green: 0.17, blue: 0.17, alpha: 1)
        }
    }
    
    public static let Background_300 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.12, green: 0.12, blue: 0.12, alpha: 1)
        } else {
            return UIColor(red: 0.12, green: 0.12, blue: 0.12, alpha: 1)
        }
    }
    
    public static let Background_400 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.26, green: 0.26, blue: 0.26, alpha: 1)
        } else {
            return UIColor(red: 0.26, green: 0.26, blue: 0.26, alpha: 1)
        }
    }
    
    public static let Grey_9 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.16, green: 0.16, blue: 0.16, alpha: 1)
        } else {
            return UIColor(red: 0.16, green: 0.16, blue: 0.16, alpha: 1)
        }
    }
    
    public static let Grey_10 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let Grey_11 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.14, green: 0.14, blue: 0.14, alpha: 1)
        } else {
            return UIColor(red: 0.14, green: 0.14, blue: 0.14, alpha: 1)
        }
    }
    
    public static let Grey_12 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.13, green: 0.13, blue: 0.13, alpha: 1)
        } else {
            return UIColor(red: 0.13, green: 0.13, blue: 0.13, alpha: 1)
        }
    }
    
    public static let Grey_100 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.96, green: 0.96, blue: 0.96, alpha: 1)
        } else {
            return UIColor(red: 0.96, green: 0.96, blue: 0.96, alpha: 1)
        }
    }
    
    public static let Grey_400 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.75, green: 0.75, blue: 0.75, alpha: 1)
        } else {
            return UIColor(red: 0.75, green: 0.75, blue: 0.75, alpha: 1)
        }
    }
    
    public static let Grey_500 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        } else {
            return UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        }
    }
    
    public static let SeparatorLine = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let SeparatorLine_Light = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let SeparatorLine_Vertical = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let chat_separator_opposite = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.23, green: 0.23, blue: 0.23, alpha: 1)
        } else {
            return UIColor(red: 0.23, green: 0.23, blue: 0.23, alpha: 1)
        }
    }
    
    public static let chat_separator_me = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.24, green: 0.76, blue: 0.64, alpha: 1)
        } else {
            return UIColor(red: 0.24, green: 0.76, blue: 0.64, alpha: 1)
        }
    }
}
extension UIColor {
    public static let Border_100 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let Border_200 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        } else {
            return UIColor(red: 0.15, green: 0.15, blue: 0.15, alpha: 1)
        }
    }
    
    public static let Border_300 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        } else {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        }
    }
    
    public static let Gradient_Card_Start = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.188, green: 0.188, blue: 0.188, alpha: 1)
        } else {
            UIColor(red: 0.188, green: 0.188, blue: 0.188, alpha: 1)
        }
    }
    
    
    public static let Gradient_Card_End = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.146, green: 0.146, blue: 0.146, alpha: 1)
        } else {
            UIColor(red: 0.146, green: 0.146, blue: 0.146, alpha: 1)
        }
    }
}

extension UIColor {
    public static let Text_100 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.94, green: 0.94, blue: 0.94, alpha: 1)
        } else {
            return UIColor(red: 0.94, green: 0.94, blue: 0.94, alpha: 1)
        }
    }
    
    public static let Text_200 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.75, green: 0.75, blue: 0.75, alpha: 1)
        } else {
            return UIColor(red: 0.75, green: 0.75, blue: 0.75, alpha: 1)
        }
    }
    
    public static let Text_250 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        } else {
            return UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        }
    }
    
    public static let Text_250_back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.24, green: 0.24, blue: 0.24, alpha: 1)
        } else {
            return UIColor(red: 0.24, green: 0.24, blue: 0.24, alpha: 1)
        }
    }
    
    public static let Text_300 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        } else {
            return UIColor(red: 0.35, green: 0.35, blue: 0.35, alpha: 1)
        }
    }
    
    public static let Text_1000 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            return UIColor(red: 0, green: 0, blue: 0, alpha: 1)
        } else {
            return UIColor(red: 0, green: 0, blue: 0, alpha: 1)
        }
    }
    
    public static let Grey_07_secondary_text = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        } else {
            UIColor(red: 0.55, green: 0.55, blue: 0.55, alpha: 1)
        }
    }
    
    public static let Text_link = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        } else {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        }
    }
    
    public static let Chat_To_Be_Earned_Back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.19, green: 0.19, blue: 0.19, alpha: 1)
        } else {
            UIColor(red: 0.19, green: 0.19, blue: 0.19, alpha: 1)
        }
    }
    
    public static let Chat_Expired_Font = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        } else {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        }
    }

}

extension UIColor {
    public static let Success_Default_Tint = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.56, green: 0.87, blue: 0.33, alpha: 1)
        } else {
            UIColor(red: 0.56, green: 0.87, blue: 0.33, alpha: 1)
        }
    }
    
    public static let Success_Default_Back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.13, green: 0.16, blue: 0.11, alpha: 1)
        } else {
            UIColor(red: 0.13, green: 0.16, blue: 0.11, alpha: 1)
        }
    }
    
    public static let Success_Default_Back_1 = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.19, green: 0.22, blue: 0.17, alpha: 1)
        } else {
            UIColor(red: 0.19, green: 0.22, blue: 0.17, alpha: 1)
        }
    }
    
    public static let Warning_Default_Tint = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 1, green: 0.84, blue: 0.31, alpha: 1)
        } else {
            UIColor(red: 1, green: 0.84, blue: 0.31, alpha: 1)
        }
    }
    
    public static let Warning_Default_Back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.17, green: 0.16, blue: 0.11, alpha: 1)
        } else {
            UIColor(red: 0.17, green: 0.16, blue: 0.11, alpha: 1)
        }
    }
    
    public static let Error_Default_Tint = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.89, green: 0.37, blue: 0.32, alpha: 1)
        } else {
            UIColor(red: 0.89, green: 0.37, blue: 0.32, alpha: 1)
        }
    }
    
    public static let Error_Default_Back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.16, green: 0.11, blue: 0.11, alpha: 1)
        } else {
            UIColor(red: 0.16, green: 0.11, blue: 0.11, alpha: 1)
        }
    }
    
    public static let Green_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.05, green: 0.71, blue: 0.55, alpha: 1)
        } else {
            UIColor(red: 0.05, green: 0.71, blue: 0.55, alpha: 1)
        }
    }
    public static let Blue_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        } else {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        }
    }
    public static let Yellow_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 1, green: 0.84, blue: 0.31, alpha: 1)
        } else {
            UIColor(red: 1, green: 0.84, blue: 0.31, alpha: 1)
        }
    }
    public static let Red_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.89, green: 0.37, blue: 0.32, alpha: 1)
        } else {
            UIColor(red: 0.89, green: 0.37, blue: 0.32, alpha: 1)
        }
    }
    public static let Grass_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.56, green: 0.87, blue: 0.33, alpha: 1)
        } else {
            UIColor(red: 0.56, green: 0.87, blue: 0.33, alpha: 1)
        }
    }
    public static let Purple_Default = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.59, green: 0.35, blue: 1, alpha: 1)
        } else {
            UIColor(red: 0.59, green: 0.35, blue: 1, alpha: 1)
        }
    }
    
    public static let Blue_EAS_Link = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        } else {
            UIColor(red: 0.06, green: 0.66, blue: 1, alpha: 1)
        }
    }
    
    public static let Progress_Bar_Back = UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.51, green: 0.52, blue: 0.52, alpha: 1)
        } else {
            UIColor(red: 0.51, green: 0.52, blue: 0.52, alpha: 1)
        }
    }
    
    public static let Name_Card_Text =  UIColor { (traitCollection) -> UIColor in
        if traitCollection.userInterfaceStyle == .dark {
            UIColor(red: 0.69, green: 0.69, blue: 0.69, alpha: 1)
        } else {
            UIColor(red: 0.69, green: 0.69, blue: 0.69, alpha: 1)
        }
    }
}

extension UIColor {
    func toHexString() -> String {
        guard let components = self.cgColor.components else {
            return "#000000" // 默认黑色
        }
        
        let red = Float(components[0])
        let green = Float(components[1])
        let blue = Float(components[2])
        
        let redHex = String(format: "%02lX", lroundf(red * 255))
        let greenHex = String(format: "%02lX", lroundf(green * 255))
        let blueHex = String(format: "%02lX", lroundf(blue * 255))
        
        return "#" + redHex + greenHex + blueHex
    }
}


