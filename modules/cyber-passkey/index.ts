import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to CyberPasskey.web.ts
// and on native platforms to CyberPasskey.ts
import CyberPasskeyModule from './src/CyberPasskeyModule';
import CyberPasskeyView from './src/CyberPasskeyView';
import { ChangeEventPayload, CyberPasskeyViewProps } from './src/CyberPasskey.types';

// Get the native constant value.
export const PI = CyberPasskeyModule.PI;

export function presentPasskeyViewController() {
  return CyberPasskeyModule.presentPasskeyViewController();
}

export function getEOA() {
  return CyberPasskeyModule.getEOA()
}

export function getAvatar() {
  return CyberPasskeyModule.getAvatar()
}

export async function setValueAsync(value: string) {
  return await CyberPasskeyModule.setValueAsync(value);
}

const emitter = new EventEmitter(CyberPasskeyModule ?? NativeModulesProxy.CyberPasskey);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { CyberPasskeyView, CyberPasskeyViewProps, ChangeEventPayload };
