import axios from 'axios';
import { useState, useEffect } from 'react';

export const OGames = () => {
    const[games, setGames] = useState([]);
    

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 


    return(
        <> 
            <tbody>
                        {games.map((game) =>{
                            return(
                                <img class="gameSize" src="placeholder.png" alt="game" />
                            );
                        })}
            </tbody> 
        </> 
    );
}
