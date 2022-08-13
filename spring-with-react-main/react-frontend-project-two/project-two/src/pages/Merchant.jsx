import {admin} from "../components"
import {back} from "../components"
export const Merchant = () => {
    return(
        <>
        <back.Back/>
        <div >
            <h1 className="text-center title">Add New Game</h1>
            <admin.MNew />
            <h1 className="text-center title">Remove Game</h1>
            <admin.MDelete />
            <h1 className="text-center title">Update Discounts</h1>
            <admin.MDiscount />
        </div>  
        
        </>
    );
}