import axios from 'axios';
import { useState, useEffect } from 'react';

export const PGames = () => {
    const[games, setGames] = useState([]);
    const yourJWTToken = localStorage.getItem("token");
    console.log("Testing: ---------------------")
    console.log(localStorage.getItem("token"))
    console.log(yourJWTToken)

    var Header = {
        headers: {
            'Access-Control-Allow-Origin':`*`,
            'Authorization': yourJWTToken
        //Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2LFJEYXZpc0BnbWFpbC5jb20iLCJpc3MiOiJCaXphcnJlQmF6YWFyIiwiaWF0IjoxNjYwMzk5MTkyLCJleHAiOjE2NjA0ODU1OTJ9.WdMLiD6CIZGnSdDI6UuUTN4AUKg3zoBM9hg-lwTCP9749BBzL8rdHvxmwNue5pO7U5DzyH70Jy15s2tAAyeRLA"
        }
     }

        useEffect(() => {  
            console.log(Header);
            
            axios.get('http://localhost:8080/gameList/1', Header).then(res => {setGames(res.data)}) 
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
            <button id ="container">
                {games.map((game, i, e) =>{
                    return(
                        <div key ={game.gameid}>
                            <div>
                                <div>
                                    <img className="gameSize" data-toggle="popover" title={game.description} data-bs-content={game.description} src={`${game.title}.png`} onError={(e)=>{e.target.onerror = null; e.target.src="placeholder.png"}}/>
                                    
            
                                    
                                    <input type="checkbox" value={game.gameid} onChange = {handleAdd}/>
                                    <div className="list-group">
                                        <div className="text-center list-group-item-dark" >Title :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">{game.title}</div>
                                    </div>
                                    <div className="list-group">
                                        <div className="text-center list-group-item-dark">Price :</div>
                                        <div className=" list-group-item-action list-group-item-secondary text-center">${Math.ceil((game.price-game.price*game.discount.discount)*100)/100}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    );
                })}
            </button> 
        </> 
    );
}