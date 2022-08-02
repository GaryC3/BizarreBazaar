export const HNavigate = () => {
    return(
        <>
        <div class="text-center pt-2 pb-5">
            <a href="/sign" class="btn btn-primary btn-lg active m-5 py-2 px-5" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Create</a>
            <a href="/owned" class="btn btn-primary btn-lg active m-5 py-2 px-5" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Owned</a>
        </div>
        <div class="text-center pb-5">
            <a href="/purchase" class="btn btn-primary btn-lg active m-5 p-5" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Browse</a>
        </div>
        <div class="text-center">
        <a href="/merchant" class="btn btn-primary btn-lg active m-5 p-5" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Manage</a>
        </div>
        </> 
    );
}