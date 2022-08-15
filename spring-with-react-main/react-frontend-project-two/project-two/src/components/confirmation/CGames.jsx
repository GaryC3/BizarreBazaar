import axios from 'axios';
import { useState, useEffect } from 'react';

export const CGames = () => {
    const[games, setGames] = useState([]);
    var total = 0;

        useEffect(() => {  
            axios.get(`http://localhost:8080/invoicelines/${localStorage.getItem("id")}`).then(res => {setGames(res.data)}) 
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
                            "id": `${localStorage.getItem("id")}`
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
                                    <img className="gameSize" data-toggle="popover" title={game.gameList.description} data-bs-content={game.gameList.description} src={`${game.gameList.title}.png`} onError={(e)=>{e.target.onerror = null; e.target.src="placeholder.png"}}/>
                                    <div className="list-group">
                                        <div className="text-center list-group-item-dark" >Title :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">{game.gameList.title}</div>
                                    </div>
                                    <div className="list-group">
                                        <div className="text-center list-group-item-dark">Price :</div>
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
                <a href="/" className="btn btn-basic m-3 px-5 py-4 signTwo" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}} onClick = {handleAdd}>Confirm</a>
            </div>
        </> 
    );
}