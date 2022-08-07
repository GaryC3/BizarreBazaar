import axios from "axios";
import { useRef } from 'react';

export const MNew = () => {

    const titleRef = useRef();
    const genreRef = useRef();
    const priceRef = useRef();
    const quantityRef = useRef();
    const descriptionRef = useRef();
    var select;

    const handleSubmit = async (e) =>{
        try{
            e.preventDefault();

            await axios.post(`http://localhost:8080/gameList`, {

                title: titleRef.current.value,
                description: descriptionRef.current.value,
                price: priceRef.current.value,
                inventory: quantityRef.current.value,
                discount :{
                    genre: document.getElementById('genre').options[document.getElementById('genre').selectedIndex].value
                }

            });

            titleRef.current.value = null;
            descriptionRef.current.value = null;
            priceRef.current.value = null;
            quantityRef.current.value = null;
            genreRef.current.value = null;

        }catch(err){
            console.log(err);
        }
    }


    return(
        <>
        <div class="input-group mb-3 long">
            <input type="text" class="form-control bg-light" placeholder="Title" aria-label="title" id="title" ref={titleRef} required  />
            {/* <input type="text" class="form-control bg-light" placeholder="Genre" aria-label="genre" id="genre" ref={genreRef} required /> */}
            <select class="form-control bg-light" searchable="Search here.." name="genre" id="genre">
                <option id="genre" required value="" disabled selected>Select Game</option>
                <option value="action">Action</option>
                <option value="adventure">Adventure</option>
                <option value="roleplaying">Roleplaying</option>
                <option value="strategy">Strategy</option>
            </select>
            <input type="number" class="form-control bg-light" placeholder="Price" ara-label="price" id="price" ref={priceRef} required  />
            <input type="number" class="form-control bg-light" placeholder="Quantity" ara-label="quantity" id="quantity" ref={quantityRef} required />
        </div>
        <div class="input-group mb-3 longnopadding">

                <div>
                    <textarea class="bg-light bigtextbox" placeholder="description" aria-label="description" id="description" ref={descriptionRef} required></textarea>
                    {/* <input type= "textarea" class="bg-light bigtextbox" placeholder="Description" aria-label="description" /> */}
                    <button class="btn btn-primary active merchantaddsubmit" type="button" onClick={handleSubmit}>Submit</button>

                </div>

        </div>


        </>



    );




}
