import axios from "axios";
import { useRef, useState, useEffect } from 'react';

export const MDelete = () => {

    const title = useRef();
    const quantity = useRef();

    
    const[setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 
    return(
        <>
        <div class="input-group mb-3 long">
            <select class="form-control bg-light" searchable="Search here..">
                <option value="" disabled selected>Select Game</option>
                <option value="1">a</option>
                <option value="2">b</option>
                <option value="3">c</option>
                <option value="4">d</option>
                <option value="5">e</option>
            </select>
            <input type="number" class="form-control bg-light" placeholder="Quantity" ara-label="quantity" required />
            
        </div>
        <div class= "input-group mb-3 long3">
            <button class="btn btn-primary active button1" type="button" /*onClick={handleSubmit}*/>Delete</button>

            <button class="btn btn-primary active button1" type="button" /*onClick={handleSubmit}*/>Update</button>
        </div>
        
       
        
            
                
                    
                    {/* <input type= "textarea" class="bg-light bigtextbox" placeholder="Description" aria-label="description" /> */}
                    {/* <button class="btn btn-primary active merchantaddsubmit" type="button" /*onClick={handleSubmit}*//*>Submit</button> */}
                    
                
        
        
        </>   
        
        
    );
}