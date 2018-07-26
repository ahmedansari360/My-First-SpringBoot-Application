import React, { Component } from 'react';
import './App.css';

import { addUser } from './addUser.js';
import { removeUser } from './removeUser.js';
import { allPopulation } from './allPopulation.js';

import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const main = () => (
  <Router>
    <div>
      <ul>
        <li>
          <Link to="/allPopulation">All Population</Link>
        </li>
        <li>
          <Link to="/addUser">Add User</Link>
        </li>
        <li>
          <Link to="/removeUser">Remove User</Link>
        </li>

      </ul>
      <hr />

      <Route path="/allpopulation" component={allPopulation} />
      <Route path="/adduser" component={addUser} />
      <Route path="/removeuser" component={removeUser} />
    </div>
  </Router>
)
export default main;