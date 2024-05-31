import * as React from 'react';

import { CyberWidgetViewProps } from './CyberWidget.types';

export default function CyberWidgetView(props: CyberWidgetViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
