import axios from "axios";
import { useRef } from 'react';

export const MDiscount = () => {

    const genreRef = useRef();
    const discountRef = useRef();
    
    const handleSubmit = async (e) =>{
        try{
            e.preventDefault();
            await axios.post(`http://localhost:8080/userlist`, {
                genre: genreRef.current.value,
                discount: discountRef.current.value
            });

            // firstRef.current.value = null;
            // lastRef.current.value = null;
            // emailRef.current.value = null;
            // passwordRef.current.value = null;
        }catch(err){
            console.log(err); 
        }
    }
    return(
        <>
        
        <div class="input-group mb-3 mdiscountbox">
            <input type="text" class="bg-light long2" placeholder="Genre" aria-label="genre" required  />
            <input type="number" class="bg-ligh long2" placeholder="Discount" ara-label="discount" required />
            <button class="btn btn-primary active merchantdiscount long2" type="button" /*onClick={handleSubmit}*/>Submit</button>
        </div>
        
        </>   
        
        
    );
}