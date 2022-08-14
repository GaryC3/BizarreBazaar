import axios from "axios";
import { useState, useEffect } from 'react';

export const MDelete = () => {

    var temp;
    
    const[games, setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets gamelist state to be that array of games
        }, []),
        {
            headers: {'Authorization': ''}
        }; 

        const handleDelete = async (e) =>{
            try{
                console.log(document.getElementById('gameid').options[document.getElementById('gameid').selectedIndex].value)
                temp = document.getElementById('gameid').options[document.getElementById('gameid').selectedIndex].value;
                await axios.delete(`http://localhost:8080/gameList/${temp}`);
                window.location.reload();
            }catch(err){
                console.log(err); 
            }
        }

    return(
        <>
        
        <div className="input-group mb-3 long">
        <select className="form-control bg-light centeredSelGame" searchable="Search here.." name="gameid" id="gameid">
        <option disabled selected>Select Game</option>
        {games.map((game, i, e) =>{
                    return(
                         <option value={game.gameid}>{game.title}</option> 
                        
                         
                    )
                }
                )}
            </select> 
            {/* <input type="number" className="form-control bg-light" placeholder="" ara-label="quantity" required /> */}
            
        </div>
        <div className= "input-group mb-3 long3 centeredSelGame">
            <button className="btn btn-danger button1 signTwo" type="button" onClick={handleDelete}>Delete</button>

            {/* <button className="btn btn-primary active button1" type="button" onClick={handleUpdate}>Update</button> */}
        </div>    
        </>   
        
        
    );
}