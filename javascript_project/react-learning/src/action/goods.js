import { createAction } from "redux-actions";

const GOODS = [{
    name: 'good 1',
    price: '5,999',
    amount: 25
  },{
    name: 'good 2',
    price: '4,999',
    amount: 45
  }, {
    name: 'good 3',
    price: '3,999',
    amount: 82
  }];

const requestGoods = createAction('REQUEST_GOODS');
const receiveGoods = createAction('RECEIVE_GOODS');

const fetchData = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(GOODS);
        }, 1500);
    });
};

export const getGoods = () => async dispatch => {
    dispatch(requestGoods());
    let goods = await fetchData();
    dispatch(receiveGoods(goods));
};