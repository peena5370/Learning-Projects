import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../action/goods';

class Goods extends Component {
    componentDidMount() {
        let dispatch = this.props.dispatch;
        dispatch(actions.getGoods());
    }
    render() {
        return this.props.isFetching ? (<h1>Loading...</h1>) : (
            <ul className='goods'>
                {
                    this.props.goods.map((element, index) => (
                        <li key={index} style={{marginBottom: 20, listStyle: 'none'}}>
                            <span>{element.name}</span> | 
                            <span>$ {element.price}</span> | 
                            <span>balance {element.amount} pcs</span>
                        </li>
                    ))
                }
            </ul>
        )
    }
}

const mapStateToProps = (state, ownProps) => ({
    isFetching: state.goods.isFetching,
    goods: state.goods.data
});

// export default Goods;
export default connect(mapStateToProps)(Goods);