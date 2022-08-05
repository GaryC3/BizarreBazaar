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
                    //i *=3 ;
                    //var temp = e[i+1];
                    return(
                        // <div>
                        //     <div> 
                        //         <img class="gameSize" src="placeholder.png" alt="game" />
                        //         <img class="gameSize" src="placeholder.png" alt="game" />
                        //         <img class="gameSize" src="placeholder.png" alt="game" />
                        //     </div>  
                        //     <div key={i}>
                        //         {}
                        //         <div class="caption">
                        //             {{i}.title}
                        //         </div>
                        //         <div class="caption">
                        //             {game.title}
                        //         </div>
                        //         <div class="caption">
                        //             {i}
                        //         </div>
                        //     </div>
                        // </div>
                        
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
                                {/* <div>
                                    <img class="gameSize" src="placeholder.png" alt="game" />
                                    <input type="checkbox" id="exampleCheck1"/>
                                    <div class="list-group">
                                        <a class="text-center">Title:</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">{game.title}</a>
                                    </div>
                                    <div class="list-group">
                                        <a class="text-center">Price:</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">{game.price}</a>
                                    </div>
                                </div>
                                <div>
                                    <img class="gameSize" src="placeholder.png" alt="game" />
                                    <input type="checkbox" id="exampleCheck1"/>
                                    <div class="list-group">
                                        <a class="text-center">Title:</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">{game.title}</a>
                                    </div>
                                    <div class="list-group">
                                        <a class="text-center">Price:</a>
                                        <a class=" list-group-item-action list-group-item-secondary text-center">{game.price}</a>
                                    </div>
                                </div> */}



                                    {/* <div class="container-fluid">

                                        <div class="container panel panel-default">

                                            <ul class="list-group">
                                                <li class="row list-group-item">
                                                <a class="col-sm-2" ng-href="#">Name</a> 
                                                <a class="col-sm-2" ng-href="#">Tweak Roster</a>
                                                <a class="col-sm-2" ng-href="#">This Week's Matchup</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div> */}
                            </div>
                        </div>

                        


                    );
                })}
            </tbody> 
        </> 
    );
}