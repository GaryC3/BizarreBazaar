import axios from 'axios';

const GET_USERS = "http://localhost:8080/test-api/";

//export and return the result of this function calling an API
export const GetUsers = () => {
    return axios.get(GET_USERS);
}