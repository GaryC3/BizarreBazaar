import {back} from "../components"
import {cart} from "../components"
export const Confirmation = () => {
    return(
        <>
        <div className = "conBackground">
        <back.Back/>
        <div className="title cartImg"></div>
        <cart.CGames/>
        </div>
        </>
    );
}