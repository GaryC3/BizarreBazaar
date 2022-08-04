import axios from "axios";
import { useRef } from 'react';

export const MDiscount = () => {

    const genre = useRef();
    const discount = useRef();
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