import React, { Component } from 'react';
import Nav from './component/nav/index';
import Welcome from './page/welcome';
import Goods from './page/goods';
import './App.css';
import { Route, Routes } from 'react-router-dom';

const LIST = [{
  text: 'welcome',
  url: '/welcome'
}, {
  text: 'goods',
  url: '/goods'
}];

class App extends Component {
  render() {
    return (
      <div className='App'>
        <div className='nav_bar'>
          <Nav list={LIST} />
        </div>
        <div className='content'>
          <Routes>
            <Route path='/welcome' element={<Welcome />} />
            <Route path='/goods' element={<Goods />} />
          </Routes>
        </div>
      </div>
    )
  }
}

export default App;
