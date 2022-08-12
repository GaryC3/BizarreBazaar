import axios from "axios";
import { useRef } from 'react';

export const SSigning2 = () => {
    
    const firstRef = useRef();
    const passwordRef = useRef();

    const handleSubmit = async (e) =>{
        try{
            e.preventDefault();
            await axios.post(`http://localhost:8080/auth/login`, {
                email: firstRef.current.value,
                password: passwordRef.current.value
            });

        }catch(err){
            console.log(err); 
        }
    }
    return(
        <>
        <div className="input-group mb-3 long3 py-4">
            <input type="text" className="form-control bg-light" placeholder="Email" aria-label="firstName" id="firstName" ref={firstRef} />
            <input type="password" className="form-control bg-light" placeholder="Password" aria-label="Password" id="password" ref={passwordRef} />
        </div>
        <div className="input-group">
            <div>
                <button className="btn btn-primary active button1" type="button" onClick={handleSubmit}>Submit</button>
            </div>
        </div>
        </> 
    );
}