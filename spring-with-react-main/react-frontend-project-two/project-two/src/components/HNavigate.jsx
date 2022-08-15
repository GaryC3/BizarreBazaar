export const HNavigate = () => {
    var temp;
    console.log(localStorage.getItem("id"))
    if (localStorage.getItem("id")){
        temp = "btn btn-primary btn-lg active m-5 py-3 px-5"
    }
    else{
        temp = "disabled btn btn-primary btn-lg active m-5 py-3 px-5"
    }
    return(
        <>
        <div class="text-center pt-2 pb-5">
            <a href="/sign" class="btn btn-primary btn-lg active m-5 py-3 px-5" role="button" aria-pressed="true" style={{fontSize: "40px"} }>Create</a>
            <a href="/sign2" class="btn btn-primary btn-lg active m-5 py-3 px-5" role="button" aria-pressed="true" style={{fontSize: "40px"}}>Sign-In</a>
        </div>
        <div class="text-center pb-5">
            <a href="/purchase" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px"}}>Browse</a>
            <a href="/owned" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px"}}>Owned</a>
        </div>
        <div class="text-center">
        <a href="/merchant" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px"}}>Manage</a>
        </div>
        </> 
    ); 
}