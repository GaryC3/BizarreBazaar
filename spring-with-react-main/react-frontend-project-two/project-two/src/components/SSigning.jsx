import axios from "axios";
import { useRef } from 'react';

export const SSigning = () => {

    
    // const firstRef = useRef();
    // const lastRef = useRef();
    // const emailRef = useRef();
    // const passwordRef = useRef();
    

    // const handleSubmit = async (e) =>{
    //     try{
    //         e.preventDefault();
    //         await axios.post(`http://localhost:8080/userList/******** `, {
    //             firstName: firstRef.current.value,
    //             lastName: lastRef.current.value,
    //             email: emailRef.current.value,
    //             password: passwordRef.current.value
    //         });
    //         //setDevs(developers.filter(developer => dev.id != developer.id))
            
    //         firstRef.current.value = null;
    //         lastRef.current.value = null;
    //         emailRef.current.value = null;
    //         passwordRef.current.value = null;
    //     }catch(err){
    //         console.log(err); 
    //     }
    // }





    return(
        <>
        <div className="input-group mb-3 long">
            <input type="text" className="form-control bg-light" placeholder="First Name" aria-label="firstName" /*id="firstName" ref={firstRef}*/ />
            <input type="text" className="form-control bg-light" placeholder="Last Name" aria-label="LastName" /*id="lastName" ref={lastRef}*/ />
        </div>
        <div className="input-group mb-3">
            <div>
                <div>
                    <input type="text" className="form-control bg-light long2" placeholder="Email" aria-label="Email" /*id="email" ref={emailRef}*/ />
                </div>
                <div>
                    <input type="password" className="form-control bg-light long2" placeholder="Password" aria-label="Password" /*id="password" ref={passwordRef}*/ />
                </div>
            </div>
            <div>
                <button className="btn btn-primary active button1" type="button" /*onClick={handleSubmit}*/>Submit</button>
            </div>
        </div>
        </> 
    );
}