import axios from "axios";
import { useRef } from 'react';

export const SSigning = () => {
    
    const firstRef = useRef();
    const lastRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();

    const handleAdd = async (e) =>{
        try{
            await axios.post(`http://localhost:8080/auth/create`, {
                "first_name": firstRef.current.value,
                "last_name": lastRef.current.value,
                "email": emailRef.current.value,
                "password": passwordRef.current.value
            });

            firstRef.current.value = null;
            lastRef.current.value = null;
            emailRef.current.value = null;
            passwordRef.current.value = null;
        }catch(err){
            console.log(err); 
        }
    }
    return(
        <>
        <div className="sUpCenter">
        <div className="input-group mb-3 long">
            <input type="text" className="form-control bg-light" placeholder="First Name" aria-label="firstName" id="firstName" ref={firstRef} />
            <input type="text" className="form-control bg-light" placeholder="Last Name" aria-label="LastName" id="lastName" ref={lastRef} />
        </div>
        <div className="input-group mb-3">
            <div>
                <div>
                    <input type="text" className="form-control bg-light long2" placeholder="Email" aria-label="Email" id="email" ref={emailRef} />
                </div>
                <div>
                    <input type="password" className="form-control bg-light long2" placeholder="Password" aria-label="Password" id="password" ref={passwordRef} />
                </div>
            </div>
            <div>
                {/* <button className="btn btn-primary active button1" type="button" onClick={handleSubmit}>Submit</button>
                <a href="/" className="btn btn-primary btn-lg active m-5 p-5" role="button" aria-pressed="true" style={{fontSize: "40px"}} onClick = {handleSubmit}>Confirm</a> */}
                
                <a href="/" className="btn btn-basic m-5 px-5 py-5 signTwo" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}} onClick = {handleAdd}>Sign Up</a>
            </div>
        </div>
        </div>
        </> 
    );
}