import axios from "axios";
import { useRef } from 'react';

export const MNew = () => {

    const titleRef = useRef();
    const genreRef = useRef();
    const priceRef = useRef();
    const quantityRef = useRef();
    const descriptionRef = useRef();

    const handleSubmit = async (e) =>{
        try{
            e.preventDefault();
            await axios.post(`http://localhost:8080/gameList`, {
                
                title: titleRef.current.value,
                description: descriptionRef.current.value,
                price: priceRef.current.value,
                inventory: quantityRef.current.value,
                discount:{
                    genre: genreRef.current.value
                }
                    
            });

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
        <div class="input-group mb-3 long">
            <input type="text" class="form-control bg-light" placeholder="Title" aria-label="title" id="title" ref={titleRef} required  />
            <input type="text" class="form-control bg-light" placeholder="Genre" aria-label="genre" id="genre" ref={genreRef} required />
            {/* <select class="form-control bg-light" searchable="Search here.." ref={genreRef}>
                <option id="genre" ref={genreRef} required value="" disabled selected>Select Game</option>
                <option value={genreRef}>action</option>
                <option value="2">b</option>
                <option value="3">c</option>
                <option value="4">d</option>
                <option value={genreRef} >e</option>
            </select> */}
            <input type="number" class="form-control bg-light" placeholder="Price" ara-label="price" id="price" ref={priceRef} required  />
            <input type="number" class="form-control bg-light" placeholder="Quantity" ara-label="quantity" id="quantity" ref={quantityRef} required />
        </div>
        <div class="input-group mb-3 longnopadding">
            
                <div>
                    <textarea class="bg-light bigtextbox" placeholder="description" aria-label="description" id="description" ref={descriptionRef} required></textarea>
                    {/* <input type= "textarea" class="bg-light bigtextbox" placeholder="Description" aria-label="description" /> */}
                    <button class="btn btn-primary active merchantaddsubmit" type="button" onClick={handleSubmit}>Submit</button>
                    
                </div>
        
        </div>
        </>   
        
        
    );
    
}