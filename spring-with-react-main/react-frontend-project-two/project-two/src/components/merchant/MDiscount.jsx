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
        }catch(err){ consolelog(err)}
        };
    
    return(
        <>
        <div className="tableContainer table-wrapper-scroll-y my-custom-scrollbar">
        <table className="table table-striped table-light table-sm" >
            <thead className>
            <tr>
                <th scope="col">Genre</th>
                <th scope="col">Discount</th>
            </tr>
            </thead>
            <tbody>
            {discountdata.map((discount, i, e) =>{
                    return(
                        <tr key={discount.genre}>
                            <td scope="row">{discount.genre}</td>
                            <td scope="row">{discount.discount}</td>
                        </tr>
                    )
                }
                )}
            </tbody>
        </table>
        </div>
        <form className="form-inline input-group mb-3 centeredDiscount ">
            <input type="text" required="required" className="form-control bg-light long2" placeholder="Genre" aria-label="genre" ref={genreRef}/>
            
            <input type="number" step="0.01" min="0" max="1"  required="required" className="form-control bg-ligh long2" placeholder="0.00" ara-label="discount"ref={discountRef}/>
            <button className="btn btn-default merchantdiscount  long2 signTwo" type="button" style={{fontSize:"40", fontFamily:"serif"}} onClick={handleSubmit}>Update</button>
        </form>
        
        </>   
    );
}