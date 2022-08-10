import axios from 'axios';
import { useState, useEffect } from 'react';

export const CGames = () => {
    const[games, setGames] = useState([]);
    var total = 0;

        useEffect(() => {  
            axios.get('http://localhost:8080/invoicelines/1').then(res => {setGames(res.data)}) 
        }, []); 

        const handleAdd = async (e) =>{
            // try{
            //     const currentgameid = e.target.value
            //     await axios.post(`http://localhost:8080/invoice`,{ 
            //         "userList":{
            //             "id": 1
            //         },
            //         "gameList": {
            //             "gameid": currentgameid
            //         }
            //     });
            // }catch(err){
            //     console.log(err); 
            // }
            {games.map((game2, i, e) =>{
                try{
                    axios.post(`http://localhost:8080/invoice`,{ 
                        "userList":{
                            "id": 1
                        },
                        "gameList": {
                            "gameid": game2.gameList.gameid
                        }
                    });
                }catch(err){
                    console.log(err);
                }
            })}
        }

    return(
        <> 
            <div id ="container">
                {games.map((game, i, e) =>{
                    total += Math.ceil((game.gameList.price-game.gameList.price*game.gameList.discount.discount)*100)/100
                    return(
                        <div key ={game.gameList.gameid}>
                            <div>
                                <div>
                                    <img className="gameSize" src="placeholder.png" alt="game" />
                                    <div className="list-group">
                                        <div className="text-center">Title :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">{game.gameList.title}</div>
                                    </div>
                                    <div className="list-group">
                                        <div className="text-center">Price :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">${Math.ceil((game.gameList.price-game.gameList.price*game.gameList.discount.discount)*100)/100}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    );
                })}
                
            </div> 
            
            <div className="text-center ">
                <div className="space-up">
                    Total : ${ Math.floor((total)*100)/100}
                </div>
                <a href="/" className="btn btn-primary btn-lg active m-5 p-5" role="button" aria-pressed="true" style={{fontSize: "40px"}} onClick = {handleAdd}>Confirm</a>
            </div>
        </> 
    );
}