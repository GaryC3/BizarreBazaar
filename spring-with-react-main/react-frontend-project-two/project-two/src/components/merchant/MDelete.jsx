import axios from "axios";
import { useRef, useState, useEffect } from 'react';

export const MDelete = () => {

    const titleRef = useRef();
    const quantity = useRef();
    const gameid = useRef(); 
    var temp;
    
    const[games, setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets gamelist state to be that array of games
        }, []); 

        const handleDelete = async (e) =>{
            try{
                e.preventDefault(); 
                console.log(document.getElementById('gameid').options[document.getElementById('gameid').selectedIndex].value)
                temp = document.getElementById('gameid').options[document.getElementById('gameid').selectedIndex].value;
                await axios.delete(`http://localhost:8080/gameList/${temp}`);
                console.log("pass"); 
            }catch(err){
                console.log("fail"); 
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
        console.log()
    return(
        <>
        
        <div class="input-group mb-3 long">
        <select class="form-control bg-light" searchable="Search here.." name="gameid" id="gameid">
        <option disabled selected>Select Game</option>
        {games.map((game, i, e) =>{
                    return(
                         <option value={game.gameid}>{game.gameid}{game.title}</option> 
                        
                         
                    )
                }
                )}
            </select> 
            <input type="number" class="form-control bg-light" placeholder="" ara-label="quantity" required />
            
        </div>
        <div class= "input-group mb-3 long3">
            <button class="btn btn-primary active button1" type="button" onClick={handleDelete}>Delete</button>

            <button class="btn btn-primary active button1" type="button" /*onClick={handleUpdate}*/>Update</button>
        </div>    
        </>   
        
        
    );
}