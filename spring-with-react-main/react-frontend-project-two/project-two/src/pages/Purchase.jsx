import {back} from "../components"
import {buy} from "../components"
export const Purchase = () => {
    return(
        <>
        <div className="browseBackground">
        <back.Back/>
        <h1 className="text-center title">GAMES</h1>
        <buy.PGames/>
        <buy.PPurchase/>
        </div>
        </>
    );
}