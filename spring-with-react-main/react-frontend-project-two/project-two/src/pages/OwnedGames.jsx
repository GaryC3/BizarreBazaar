import {own} from "../components"
import {back} from "../components"
export const OwnedGames = () => {
    return(
        <>
        <div className="ownedBackground">
        <back.Back/>
        <div className="title myGames"></div>
        <own.OGames />
        </div>
        </> 
    );
}