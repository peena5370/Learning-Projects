import React from 'react';
import './index.css';
import { Link } from 'react-router-dom';

const Nav = props => (
    <ul className="nav">
        {
            props.list.map((element, index) => (
                <Link to={element.url} key={index}>
                    <li>{element.text}</li>
                </Link>
            ))
        }
    </ul>
);

export default Nav;