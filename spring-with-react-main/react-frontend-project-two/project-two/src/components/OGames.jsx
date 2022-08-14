import axios from 'axios';
import { useState, useEffect } from 'react';

export const OGames = () => {
    const[games, setGames] = useState([]);
    

        useEffect(() => {  
        axios.get(`http://localhost:8080/gameList/my/${localStorage.getItem("id")}`)
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 


    return(
        <> 
            <tbody>
                        {games.map((game) =>{
                            return(
                                <img className="gameSize" data-toggle="popover" title={game.description} data-bs-content={game.description} src={`${game.title}.png`} onError={(e)=>{e.target.onerror = null; e.target.src="placeholder.png"}}/>
                            );
                        })}
            </tbody> 
        </> 
    );
}
