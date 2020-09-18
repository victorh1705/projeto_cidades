/**
 * Constants Types
 */
const SET_LIST_CIDADES = "SET_LIST_CIDADES";
const SET_FILTER_CIDADES = "SET_FILTER_CIDADES";

/**
 * Actions creators
 */
const actions = {
  setListCidades: (data) => ({
    type: SET_LIST_CIDADES,
    payload: data,
  }),
  setFilterCidades: (data) => ({
    type: SET_FILTER_CIDADES,
    payload: data,
  }),
};

const INITIAL_STATE = {
  data: [],
  loading: false,
};

/**
 * Reducers
 */
const reducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case SET_LIST_CIDADES:
      return { ...state, data: action.payload };
    default:
      return state;
  }
};

export { actions, reducer };
