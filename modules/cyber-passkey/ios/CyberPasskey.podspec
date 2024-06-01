Pod::Spec.new do |s|
  s.name           = 'CyberPasskey'
  s.version        = '1.0.0'
  s.summary        = 'A sample project summary'
  s.description    = 'A sample project description'
  s.author         = ''
  s.homepage       = 'https://docs.expo.dev/modules/'
  s.platforms      = { :ios => '16.0', :tvos => '16.0' }
  s.source         = { git: '' }
  s.static_framework = true

  s.dependency 'ExpoModulesCore'
  s.dependency 'AFNetworking'
  s.dependency 'Apollo', '~> 1.7.1'
  s.dependency 'ProgressHUD', '~> 13.8.6'
  s.dependency 'ActiveLabel'
  s.dependency 'SwiftMessages', '~> 9.0.9'
  s.dependency 'SnapKit', '~> 5.6.0'

  # Swift/Objective-C compatibility
  s.pod_target_xcconfig = {
    'DEFINES_MODULE' => 'YES',
    'SWIFT_COMPILATION_MODE' => 'wholemodule'
  }

  s.source_files = "**/*.{h,m,mm,swift,hpp,cpp}"
end
