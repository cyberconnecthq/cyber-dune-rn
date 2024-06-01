//
//  CustomTextField.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation
import UIKit
let kCloseIconSize = 24.0
class InsetIndicatorTextField : UITextField {
    // 定义您想要的边距
    var contentInset = UIEdgeInsets.zero
    
    override func textRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: contentInset)
    }
    
    override func placeholderRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: contentInset)
    }
    
    override func editingRect(forBounds bounds: CGRect) -> CGRect {
        return bounds.inset(by: contentInset)
    }
    
    private lazy var indicator : UILabel = {
        let view = UILabel(frame: .zero)
        view.textColor = UIColor.Text_250
        view.font = UIFont.systemFont(ofSize: 16)
        view.text = "0/30"
        view.textAlignment = .right
        return view
    }()
    
    private lazy var closeIMG:UIImageView = {
        let view = UIImageView(frame: .zero)
        view.contentMode = .scaleAspectFill
        view.image = UIImage(named: "text_close")
        view.isUserInteractionEnabled = true
        view.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(tappedCloseAction)))
        return view
    }()
    
    public var clearTapped:(()->())?
    
    convenience init(frame:CGRect, contentInset:UIEdgeInsets, showIndicator:Bool = false, showCloseIcon:Bool = false) {
        self.init(frame: frame)
        
        self.contentInset = contentInset
        if showIndicator {
            self.addSubview(self.indicator)
            self.indicator.snp.makeConstraints { make in
                make.right.equalToSuperview().offset(-12)
                make.centerY.equalToSuperview()
            }
        }
        
        if showCloseIcon {
            self.addSubview(self.closeIMG)
            self.closeIMG.snp.makeConstraints { make in
                make.right.equalToSuperview().offset(-8)
                make.centerY.equalToSuperview()
                make.width.height.equalTo(kCloseIconSize)
            }
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func updateCharacterCount(_ count:Int, total:Int) {
        self.indicator.text = "\(count)/\(total)"
    }
    
    @objc func tappedCloseAction() {
        self.text = nil
//        self.updateCloseEnable(false)
        self.clearTapped?()
    }
    
    func updateCloseEnable(_ enable:Bool) {
        self.closeIMG.isHidden = !enable
    }
}

class SearchTextField : InsetIndicatorTextField {
    public var cancelTapped:(()->())?
    private lazy var searchIcon:UIImageView = {
        let view = UIImageView(frame: .zero)
        view.contentMode = .scaleAspectFill
        view.image = UIImage(named: "search")
        return view
    }()
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    convenience init(frame: CGRect, showSearchIcon:Bool=true, showCloseIcon:Bool=true) {
        self.init(frame: frame, contentInset: UIEdgeInsets(top: 0, left: 8+20+8, bottom: 0, right: 8+20+8), showIndicator: false, showCloseIcon: true)
        
        setUp(showSearchIcon, showCloseIcon)
    }
    
    func setUp(_ showSearchIcon:Bool, _ showCloseIcon:Bool) {
        if showSearchIcon {
            self.addSubview(self.searchIcon)
            self.searchIcon.snp.makeConstraints { make in
                make.left.equalToSuperview().offset(8)
                make.centerY.equalToSuperview()
                make.width.height.equalTo(20)
            }
        }
        self.updateCloseEnable(showCloseIcon)
    }
}
