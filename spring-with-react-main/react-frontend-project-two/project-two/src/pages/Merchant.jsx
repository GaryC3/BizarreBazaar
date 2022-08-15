import {admin} from "../components"
import {back} from "../components"
export const Merchant = () => {
    return(
        <>
        <back.Back/>
        <div className="manageBackground">
        <div className="title addGameImg"></div>
            <admin.MNew />
            <div className="title deleteGameImg"></div>
            <admin.MDelete />
            <div className="title discountImg"></div>
            <admin.MDiscount />
        </div>  
        
        </>
    );
}