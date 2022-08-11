import axios from "axios";
import React, { useRef , useState, useEffect } from 'react';
import * as ReactBootStrap from "react-bootstrap";

export const MDiscount = () => {

    const genreRef = useRef();
    const discountRef = useRef();

    const[discountdata, setDiscount] = useState([]);

        useEffect(() => {  
        axios.get('http://localhost:8080/discount')
            .then(res => {setDiscount(res.data)}) // sets discout state to be that array of discounts
        }, [setDiscount]); 
    
        // const [inEditMode, setInEditMode] = useState({
        //     status: false,
        //     rowKey: null
        // });
        // const [currentDiscount, setCurrentDiscount] = useState(null);

        // const onEdit = ({genre, discountValue}) => {
        //     setInEditMode({
        //         status: true,
        //         rowKey: genre
        //     })
        //     setCurrentDiscount(discountValue);
        // }
        
        // const onSave = ({genre, newDiscount}) => {
        //     handleSubmit({genre, newDiscount});
        // }
    
        // const onCancel = () => {
        //     // reset the inEditMode state value
        //     setInEditMode({
        //         status: false,
        //         rowKey: null
        //     })
        //     // reset the unit price state value
        //     setCurrentDiscount(null);
        // }

    const handleSubmit = async (e) =>{
        try{
            const {data} = await axios.post(`http://localhost:8080/discount`, {
                genre: genreRef.current.value,
                discount: discountRef.current.value
                
            });
            window.location.reload(false);
            //setDiscount([discountdata, data]);
            // setDiscount([...discountdata, data]);
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
        <ReactBootStrap.Table>
            <tr>
                <th>Genre</th>
                <th>Discount</th>
            </tr>
            {discountdata.map((discount, i, e) =>{
                    return(
                        <tr key={discount.genre}>
                            <td>{discount.genre}</td>
                            <td>{discount.discount}</td>
                                {/* {
                                    inEditMode.status && inEditMode.rowKey === discount.genre ? (
                                        <input value={currentDiscount}
                                               onChange={(event) => setCurrentDiscount(event.target.value)}
                                        />
                                    ) : (
                                        discount.discount
                                    )
                                }
                            <td>
                            {
                                    inEditMode.status ===discount.genre ? (
                                        <React.Fragment>
                                            <button
                                                className={"btn-success"}
                                                onClick={() => onSave({genre: discount.genre, setCurrentDiscount: currentDiscount})}
                                            >
                                                Save
                                            </button>
                                            
                                            <button
                                                className={"btn-secondary"}
                                                style={{marginLeft: 8}}
                                                onClick={() => onCancel()}
                                            >
                                                Cancel
                                            </button>
                                        </React.Fragment>
                                    ) : (
                                        <button
                                            className={"btn-primary"}
                                            onClick={() => onEdit({id: discount.genre, currentDiscount: discount.discount})}
                                        >
                                            Edit
                                        </button>
                                    )
                                } */}
                            


                        </tr>

                    )
                }
                )}

            
        </ReactBootStrap.Table>
        <div class="input-group mb-3">
            <input type="text" class="bg-light long2" placeholder="Genre" aria-label="genre" ref={genreRef} required="required"  />
            
            <input type="number" class="bg-ligh long2" placeholder="Discount" ara-label="discount" required="required" ref={discountRef}/>
            <button class="btn btn-primary active merchantdiscount long2" type="button" onClick={handleSubmit}>Submit</button>
        </div>
        
        </>   
        
        
    );
}