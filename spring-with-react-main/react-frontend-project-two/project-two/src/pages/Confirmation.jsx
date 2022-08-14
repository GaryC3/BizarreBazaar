import {back} from "../components"
import {cart} from "../components"
export const Confirmation = () => {
    return(
        <>
        <div className = "conBackground">
        <back.Back/>
        <h1 className="text-center title">CART</h1>
        <cart.CGames/>
        </div>
        </>
    );
}