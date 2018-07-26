import React, { Component } from 'react';
import axios from 'axios';

export class addUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            "name": '',
            "username": '',
            "password": ''
        }
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    registerUser() {
        var payLoad = this.state;
        axios.post('http://localhost:8080/addUser', payLoad)
            .then(res => {
                console.log(res);
            })
    }
    render() {
        return (
            <form >
                <fieldset>
                    <legend>Register</legend>
                    Name<br />
                    <input type="text" name="name" onChange={e => this.handleChange(e)} /><br />
                    User Name<br />
                    <input type="text" name="username" onChange={e => this.handleChange(e)} /><br />
                    Password<br />
                    <input type="password" name="password" onChange={e => this.handleChange(e)} /><br /><br />
                    <button type="button" onClick={() => this.registerUser()}>
                        Register
            </button>
                </fieldset>
            </form>
        );
    }
}