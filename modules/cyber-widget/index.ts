import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to CyberWidget.web.ts
// and on native platforms to CyberWidget.ts
import CyberWidgetModule from './src/CyberWidgetModule';
import CyberWidgetView from './src/CyberWidgetView';
import { ChangeEventPayload, CyberWidgetViewProps } from './src/CyberWidget.types';

// Get the native constant value.
export const PI = CyberWidgetModule.PI;

export function hello(): string {
  return CyberWidgetModule.hello();
}

export async function setValueAsync(value: string) {
  return await CyberWidgetModule.setValueAsync(value);
}

const emitter = new EventEmitter(CyberWidgetModule ?? NativeModulesProxy.CyberWidget);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { CyberWidgetView, CyberWidgetViewProps, ChangeEventPayload };
