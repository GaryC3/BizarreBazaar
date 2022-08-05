import axios from 'axios';
import { useState, useEffect } from 'react';

export const PGames = () => {
    const[games, setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 


    return(
        <> 
            <tbody>
                <div class="container-fluid">
                    <div class="row">
                        {games.map((game) =>{
                            return(
                                //<SoftwareDeveloper key={dev.id} dev={dev} developers={devs} setDevs={setDevs} />
                                // <div class="container-fluid">
                                     <div class="row">
                                        <img class="gameSize" src="placeholder.png" alt="game" />
                                        {/* <div class="caption">
                                            {game.title}
                                        </div> */}
                                     {/* </div>    */}
                                </div> 
                            );
                        })}
                    </div>   
                </div>
            </tbody> 
        </> 
    );
}