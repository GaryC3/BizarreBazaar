import axios from 'axios';
import { useState, useEffect } from 'react';

export const PGames = () => {
    const[games, setGames] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/gameList')
            .then(res => {setGames(res.data)}) // sets my devs state to be that array of devs
        }, []); 

        const handleAdd = async (e) =>{
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


    return(
        <> 
            <tbody id ="container">
                {games.map((game, i, e) =>{
                    return(
                        <div>
                            <div>
                                <div>
                                    <img class="gameSize" src="placeholder.png" alt="game" />
                                    <input type="radio" value={game.gameid} id="exampleCheck1" onClick={handleAdd}/>
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