import * as React from 'react';

import { CyberPasskeyViewProps } from './CyberPasskey.types';

export default function CyberPasskeyView(props: CyberPasskeyViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
