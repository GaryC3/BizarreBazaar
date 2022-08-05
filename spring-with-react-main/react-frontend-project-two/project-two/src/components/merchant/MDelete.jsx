import axios from "axios";
import { useRef, useState, useEffect } from 'react';

export const MDelete = () => {

    const title = useRef();
    const quantity = useRef();

    
    const[games, setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 

        const handleDelete = async (e) =>{
            try{
                e.preventDefault();
                await axios.delete(`http://localhost:8080/gameList?gameid}`, {
                    // first_name: firstRef.current.value,
                    // last_name: lastRef.current.value,
                    // email: emailRef.current.value,
                    // password: passwordRef.current.value
                });
            }catch(err){
                console.log(err); 
            }
        }
        const handleUpdate = async (e) =>{
            try{
                e.preventDefault();
                await axios.put(`http://localhost:8080/gameList}`, {
                    // first_name: firstRef.current.value,
                    // last_name: lastRef.current.value,
                    // email: emailRef.current.value,
                    // password: passwordRef.current.value
                });
            }catch(err){
                console.log(err); 
            }
        }
    return(
        <>
        
        <div class="input-group mb-3 long">
        <select class="form-control bg-light" searchable="Search here..">
        <option value="" disabled selected>Select Game</option>
        {games.map((game, i, e) =>{
                    return(
                         <option value="game">{game.title} </option> 
                    )
                }
                )}
            </select> 
            <input type="number" class="form-control bg-light" placeholder="quantity" ara-label="quantity" required />
            
        </div>
        <div class= "input-group mb-3 long3">
            <button class="btn btn-primary active button1" type="button" /*onClick={handleDelete}*/>Delete</button>

            <button class="btn btn-primary active button1" type="button" /*onClick={handleUpdate}*/>Update</button>
        </div>    
        </>   
        
        
    );
}