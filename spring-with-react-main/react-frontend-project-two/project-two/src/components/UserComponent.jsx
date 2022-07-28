import React from "react";
import { GetUsers } from "../services/UserService"; // Getting our GET API result
import { useEffect, useState } from "react";
import axios from "axios";


export const UserList = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        GetUsers().then(response => setUsers(response.data));
        // axios.get(`http://localhost:8080/test-api/`)
        // .then(response => setUsers(response.data));
    }, []);

    return (
        <table className="table table-bordered table-striped">
            <thead>
                <tr>
                    <td>User Id</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                </tr>
            </thead>
            <tbody>
                {users.map((user) => {
                    return (
                        // May be a good spot to pass in props to other components
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.firstName}</td>
                            <td>{user.lastName}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};