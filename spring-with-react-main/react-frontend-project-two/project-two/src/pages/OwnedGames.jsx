import {own} from "../components"
import {back} from "../components"
export const OwnedGames = () => {
    return(
        <>
        <div className="ownedBackground">
        <back.Back/>
        <h1 className="text-center title">Game Library</h1>
        <own.OGames />
        </div>
        </> 
    );
}