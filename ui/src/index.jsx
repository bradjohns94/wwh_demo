import React from 'react';
import {render} from 'react-dom';

import 'whatwg-fetch';

const App = () => (
  <div>
    Hello, world!
  </div>
);

render(<App />, document.getElementById('app'));
