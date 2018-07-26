import React, { Component } from 'react';
import axios from 'axios';

export class allPopulation extends Component {
    constructor() {
        super();

        this.state = {
            'users': []
        }

    }
    componentDidMount() {
        this.getUsers();

    }
    getUsers() {
        axios.get('http://localhost:8080/allPopulation')
            .then(results => results.data)
            .then(results => this.setState({ 'users': results }))
    };


    render() {
        return (

            <table border='1'>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>User Name</td>
                    <td>Password</td>
                </tr>
                {this.state.users.map(function (user, index) {
                    return (
                        <tr key={index} >
                            <td>{user.id} </td>
                            <td> {user.name} </td>
                            <td>{user.username} </td>
                            <td>{user.password} </td>
                        </tr>
                    )
                }
                )}
            </table>
        );
    }
}