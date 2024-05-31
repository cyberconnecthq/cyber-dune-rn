import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { CyberPasskeyViewProps } from './CyberPasskey.types';

const NativeView: React.ComponentType<CyberPasskeyViewProps> =
  requireNativeViewManager('CyberPasskey');

export default function CyberPasskeyView(props: CyberPasskeyViewProps) {
  return <NativeView {...props} />;
}
