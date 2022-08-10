import {back} from "../components"
import {cart} from "../components"
export const Confirmation = () => {
    return(
        <>
        <back.Back/>
        <h1 className="text-center title">CART</h1>
        <cart.CGames/>
        </>
    );
}