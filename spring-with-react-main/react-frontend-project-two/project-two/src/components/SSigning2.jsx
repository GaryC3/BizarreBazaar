import axios from "axios";
import { useRef } from 'react';

export const SSigning2 = () => {
    
    const firstRef = useRef();
    const passwordRef = useRef();
    var token
    var id

    const handleSubmit = async (e) =>{
        try{
            await axios.post(`http://localhost:8080/auth/login`, {
                email: firstRef.current.value,
                password: passwordRef.current.value
            }).then(response => {
                console.log("User ID: " + response.data.id);
                id = response.data.id;
                console.log("Access Token: " + response.data.accessToken);
                token = response.data.accessToken;
            });

            firstRef.current.value = null;
            passwordRef.current.value = null;
            localStorage.setItem("token", token);
            localStorage.setItem("id", id);

        }catch(err){
            console.log(err); 
        }
    }
    return(
        <>
        <div className="centered signinDiv">
        <div className="input-group mb-3 long2 py-4" >
            <input type="text" className="form-control bg-light " placeholder="Email" aria-label="firstName" id="firstName" ref={firstRef} />
        </div>
        <div className="input-group mb-3 long2 py-4" > 
            <input type="password" className="form-control bg-light" placeholder="Password" aria-label="Password" id="password" ref={passwordRef} />
        </div>
        </div>
        <div className="signinButtonCenter">
            <div className = "">
                {/* <a href="/" className="btn btn-primary active button1" role="button" area-pressed="true" onClick={handleSubmit}>Submit</a> */}
                <a href="/" className="btn m-4 px-6 py-4 signTwo" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}} onClick = {handleSubmit}>Sign In</a>
            </div>
        </div>
        
        </> 
    );
}