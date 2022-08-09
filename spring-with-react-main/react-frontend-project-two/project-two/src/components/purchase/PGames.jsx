import axios from 'axios';
import { useState, useEffect } from 'react';

export const PGames = () => {
    const[games, setGames] = useState([]);

        useEffect(() => {  
            axios.get('http://localhost:8080/gameList').then(res => {setGames(res.data)}) 
            axios.delete(`http://localhost:8080/invoicelines/1`)////////////////////////////////
            /////////////////////////////////////////////////^////////
            ////////////////////////////////////////////////^^^///////
            ///////////////////Fix when id available///////^^^^^//////
            //////////////////////////////////////////////^^^^^^^/////
            /////////////////////////////////////////////^^^^^^^^^////
            ////////////////////////////////////////////^^^^^^^^^^^///
            ///////////////////////////////////////////^^^^^^^^^^^^^//
        }, []); 

        const handleAdd = async (e) =>{
            try{
                const currentgameid = e.target.value
                await axios.post(`http://localhost:8080/invoicelines`,{ 
                    "userList":{
                        "id": 1
                    },
                    "gameList": {
                        "gameid": currentgameid
                    }
                });
            }catch(err){
                console.log(err); 
            }
        }


    return(
        <> 
            <div id ="container">
                {games.map((game, i, e) =>{
                    return(
                        <div key ={game.gameid}>
                            <div>
                                <div>
                                    <img className="gameSize" src="placeholder.png" alt="game" />
                                    <input type="checkbox" value={game.gameid} onChange = {handleAdd}/>
                                    <div className="list-group">
                                        <div className="text-center">Title :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">{game.title}</div>
                                    </div>
                                    <div className="list-group">
                                        <div className="text-center">Price :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">${Math.ceil((game.price-game.price*game.discount.discount)*100)/100}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    );
                })}
            </div> 
        </> 
    );
}