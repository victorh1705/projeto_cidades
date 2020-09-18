import { createStore, combineReducers, compose } from "redux";

/* ducks */
import { reducer as cidades } from "./ducks/cidades";

/* reducers */
const reducers = combineReducers({
  cidades,
});

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(reducers, composeEnhancers());

export default store;
