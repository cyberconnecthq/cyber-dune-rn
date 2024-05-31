import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { CyberWidgetViewProps } from './CyberWidget.types';

const NativeView: React.ComponentType<CyberWidgetViewProps> =
  requireNativeViewManager('CyberWidget');

export default function CyberWidgetView(props: CyberWidgetViewProps) {
  return <NativeView {...props} />;
}
