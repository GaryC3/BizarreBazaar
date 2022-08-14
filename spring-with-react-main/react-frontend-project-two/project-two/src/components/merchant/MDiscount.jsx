import axios from "axios";
import React, { useRef , useState, useEffect } from 'react';
import ReactTable from 'react-table';
import * as ReactBootStrap from "react-bootstrap";

export const MDiscount = () => {

    const genreRef = useRef();
    const discountRef = useRef();

    const[discountdata, setDiscount] = useState([]);

    useEffect(() => {  
    axios.get('http://localhost:8080/discount')
        .then(res => {setDiscount(res.data)}) // sets discout state to be that array of discounts
    }, [setDiscount]); 

       

    const handleSubmit = async (e) =>{
        try{
            const {data} = await axios.post(`http://localhost:8080/discount`, {
                genre: genreRef.current.value,
                discount: discountRef.current.value
                
            });
            window.location.reload(false);
            //setDiscount([discountdata, data]);
            // setDiscount([...discountdata, data]);
        }catch(err){
            console.log(err); 
        }
    };
    
    return(
        <>
        <table >
            <tr>
                <th>Genre</th>
                <th>Discount</th>
            </tr>
            {discountdata.map((discount, i, e) =>{
                    return(
                        <tr key={discount.genre}>
                            <td>{discount.genre}</td>
                            <td>{discount.discount}</td>
                        </tr>
                    )
                }
                )}

        </table>
        {/* </ReactBootStrap.Table> */}
        <div className="input-group mb-3 centeredDiscount">
            <input type="text" className="bg-light long2" placeholder="Genre" aria-label="genre" ref={genreRef} required="required"  />
            
            <input type="number" className="bg-ligh long2" placeholder="Discount" ara-label="discount" required="required" ref={discountRef}/>
            <button className="btn btn-primary active merchantdiscount long2" type="button" onClick={handleSubmit}>Submit</button>
        </div>
        
        </>   
        
        
    );
}