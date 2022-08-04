import {admin} from "../components"
export const Merchant = () => {
    return(
        <>
        <div >
            <h1 class="text-center title">Add new game</h1>
            <admin.MNew />
            <h1 class="text-center title">Update/Delete</h1>
            <admin.MDelete />
            <h1 class="text-center title">Update discounts</h1>
            <admin.MDiscount />
        </div>  
        
        </>
    );
}