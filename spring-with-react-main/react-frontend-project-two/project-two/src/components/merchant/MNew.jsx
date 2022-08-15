import axios from "axios";
import { useState, useEffect, useRef } from 'react';

export const MNew = () => {

    const titleRef = useRef();
    const genreRef = useRef();
    const priceRef = useRef();
    const quantityRef = useRef();
    const descriptionRef = useRef();
    
    const[discount, setDiscount] = useState([]);
    useEffect(() => {  
        axios.get('http://localhost:8080/discount')
            .then(res => {setDiscount(res.data)}) // sets gamelist state to be that array of games
        }, []); 

    const handleSubmit = async (e) =>{
        try{
            await axios.post(`http://localhost:8080/gameList`, {

                title: titleRef.current.value,
                description: descriptionRef.current.value,
                price: priceRef.current.value,
                inventory: quantityRef.current.value,
                discount :{
                    genre: document.getElementById('genre').options[document.getElementById('genre').selectedIndex].value
                }

            });
            window.location.reload(false);
            titleRef.current.value = null;
            descriptionRef.current.value = null;
            priceRef.current.value = null;
            quantityRef.current.value = null;
            genreRef.current.value = null;
            

        }catch(err){
            console.log(err);
        }
    }


    return(
        <>
        
        <div className="input-group mb-3 long centeredSelGame">
            <input type="text" className="form-control bg-light" placeholder="Title" aria-label="title" id="title" ref={titleRef} required  />
            {/* <input type="text" className="form-control bg-light" placeholder="Genre" aria-label="genre" id="genre" ref={genreRef} required /> */}
            <select className="form-control bg-light" searchable="Search here.." name="genre" id="genre">
                <option id="genre" required value="" disabled selected>Select Genre</option>
                {discount.map((discount, i, e) =>{
                    return(
                         <option value={discount.genre}>{discount.genre}</option> 
                    )
                }
                )}
            </select>
            <input type="number" className="form-control bg-light" placeholder="Price" ara-label="price" id="price" ref={priceRef} required  />
            <input type="number" className="form-control bg-light" placeholder="Quantity" ara-label="quantity" id="quantity" ref={quantityRef} required />
        </div>
        <div className="input-group mb-3 longnopadding centeredNewGame">

                <div>
                    <textarea className="bg-light bigtextbox" placeholder="description" aria-label="description" id="description" ref={descriptionRef} required></textarea>
                    {/* <input type= "textarea" className="bg-light bigtextbox" placeholder="Description" aria-label="description" /> */}
                    <button className="btn btn-default merchantaddsubmit signTwo" style={{fontSize:"40", fontFamily:"serif"}} onClick={handleSubmit}>Add Game</button>

                </div>

        </div>

        </>



    );




}
