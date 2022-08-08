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
            <tbody id ="container">
                {games.map((game, i, e) =>{
                    return(
                        <div>
                            <div>
                                <div>
                                    <img class="gameSize" src="placeholder.png" alt="game" />
                                    <input type="checkbox" id="exampleCheck1"/>
                                    <div class="list-group">
                                        <a class="text-center">Title :</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">{game.title}</a>
                                    </div>
                                    <div class="list-group">
                                        <a class="text-center">Price :</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">${Math.ceil((game.price-game.price*game.discount.discount)*100)/100}</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    );
                })}
            </tbody> 
        </> 
    );
}