import {admin} from "../components"
import {back} from "../components"
export const Merchant = () => {
    return(
        <>
        <back.Back/>
        <div >
            <h1 class="text-center title">Add New Game</h1>
            <admin.MNew />
            <h1 class="text-center title">Remove Game</h1>
            <admin.MDelete />
            <h1 class="text-center title">Update Discounts</h1>
            <admin.MDiscount />
        </div>  
        
        </>
    );
}