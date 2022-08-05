import axios from "axios";
import { useRef } from 'react';

export const MNew = () => {

    const title = useRef();
    const genre = useRef();
    const price = useRef();
    const quantity = useRef();
    const description = useRef();
    return(
        <>
        <div class="input-group mb-3 long">
            <input type="text" class="form-control bg-light" placeholder="Title" aria-label="title" required  />
            <input type="text" class="form-control bg-light" placeholder="Genre" aria-label="genre" required  />
            <input type="number" class="form-control bg-light" placeholder="Price" ara-label="price" required  />
            <input type="number" class="form-control bg-light" placeholder="Quantity" ara-label="quantity" required />
        </div>
        <div class="input-group mb-3 longnopadding">
            
                <div>
                    <textarea class="bg-light bigtextbox" placeholder="description" aria-label="description"></textarea>
                    {/* <input type= "textarea" class="bg-light bigtextbox" placeholder="Description" aria-label="description" /> */}
                    <button class="btn btn-primary active merchantaddsubmit" type="button" /*onClick={handleSubmit}*/>Submit</button>
                    
                </div>
        
        </div>
        </>   
        
        
    );
    
}