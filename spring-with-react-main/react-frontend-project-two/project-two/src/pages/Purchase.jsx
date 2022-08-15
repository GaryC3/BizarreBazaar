import {back} from "../components"
import {buy} from "../components"
export const Purchase = () => {
    return(
        <>
        <div className="browseBackground">
        <back.Back/>
        <div className="title purchaseSign"></div>
        <buy.PGames/>
        <buy.PPurchase/>
        </div>
        </>
    );
}