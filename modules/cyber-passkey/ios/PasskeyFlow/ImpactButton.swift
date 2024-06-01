//
//  ImpactButton.swift
//  CyberPasskey
//
//  Created by spantar on 2024/6/1.
//

import Foundation
import UIKit
import SwiftUI

class ImpactStateManager: NSObject {
    @objc dynamic var state: Bool = false
}

class ImpactButton : UIButton {
    // 创建触觉反馈生成器
    private let feedbackGenerator = UIImpactFeedbackGenerator(style: .soft)
    public var stateManager = ImpactStateManager()
    private let activityIndicatorView:UIActivityIndicatorView = {
        let loading = UIActivityIndicatorView(style: .medium)
        loading.color = .Grey_500
        return loading
    }()

    
    convenience init(image:UIImage?, frame:CGRect, backgroundColor:UIColor? = nil) {
        self.init(frame: frame)
        if let image = image {
            self.setImage(image, for: .normal)
        }
        self.imageEdgeInsets = UIEdgeInsets(top: 0, left: -10, bottom: 0, right: 0) // 调整左侧边距
        if let color = backgroundColor {
            self.backgroundColor = color
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        self.layer.cornerRadius = Radius.button_radius
        self.layer.masksToBounds = true
        
        // 设置按钮的正常状态背景颜色
        self.setBackgroundImage(UIImage.imageWithColor(color: .Primary_Default), for: .normal)
        // 设置按钮的高亮状态背景颜色
        self.setBackgroundImage(UIImage.imageWithColor(color: .Grey_400), for: .highlighted)
        self.setTitleColor(.Grey_10, for: .normal)
        self.setTitleColor(.Grey_500, for: .highlighted)
        self.titleLabel?.font = UIFont.systemFont(ofSize: 16, weight: .bold)
        
        self.addTarget(self, action: #selector(buttonTapped), for: .touchUpInside)
        
        // 设置 activityIndicatorView 的属性
        self.addSubview(activityIndicatorView)
        activityIndicatorView.isHidden = true
        
        setupObservation()
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        activityIndicatorView.frame = .init(x: 2 * Distance.primary_margin, y: (frame.size.height - SizeSet.common_icon_size)*0.5, width: SizeSet.common_icon_size, height: SizeSet.common_icon_size)
    }
    
    @objc func buttonTapped() {
        // 触发触觉反馈
        feedbackGenerator.prepare()
        feedbackGenerator.impactOccurred()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupObservation() {
        stateManager.addObserver(self, forKeyPath: "state", options: [.new], context: nil)
    }

    // 当状态变化时触发的 KVO 回调
    override func observeValue(forKeyPath keyPath: String?, of object: Any?, change: [NSKeyValueChangeKey : Any]?, context: UnsafeMutableRawPointer?) {
        if keyPath == "state" {
            if let newState = change?[.newKey] as? Bool {
                // 处理状态变化
                activityIndicatorView.isHidden = !newState
                if newState {
                    activityIndicatorView.startAnimating()
                } else {
                    activityIndicatorView.stopAnimating()
                }
            }
        }
    }

    deinit {
        stateManager.removeObserver(self, forKeyPath: "state")
    }
}
