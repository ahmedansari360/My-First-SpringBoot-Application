import React, { Component } from 'react';
import axios from 'axios';

export class removeUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            "id": ''
        }
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    removeUser() {
        axios.delete('http://localhost:8080/removeUser/' + this.state.id)
            .then(res => {
                console.log(res);
            })
    }
    render() {
        return (
            <form >
                <fieldset>
                    <legend>Remove User</legend>
                    Enter ID to Remove<br />
                    <input type="number" name="id" onChange={e => this.handleChange(e)} /><br />
                    <button type="button" onClick={() => this.removeUser()}>
                        Remove
                     </button>
                </fieldset>
            </form>
        );
    }
}