import logo from './logo.svg';
import './App.css';
import Display from './display/Display';
import { createStore } from 'redux';
import rootReducer from './components/reducers';
import { Provider } from 'react-redux';

const store = createStore(
  rootReducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());
function App() {
  return (
    <div>
      <Provider store={store}>
        <Display/>
      </Provider>
    </div>
  );
}

export default App;
