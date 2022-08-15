export const HNavigate = () => {
    return(
        <>
        <div class="text-center pt-2 pb-5 spacingMain">
            <a href="/sign" class="btn btn-default py-4 px-5 signOne"  aria-pressed="true" style={{fontSize: "40px"}}>Create</a>
            <a href="/sign2" class="btn btn-basic py-4 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Sign-In</a>
        </div>
        <div class="text-center pt-5 pb-5 spacingMain">
            <a href="/purchase" class="btn btn-basic  py-4 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Browse</a>
            <a href="/owned" class="btn btn-basic  py-4 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Owned</a>
        </div>
        <div class="text-center">
        <a href="/merchant" class="btn btn-default m-4 py-4 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Manage</a>
        </div>
        </> 
    ); 
}