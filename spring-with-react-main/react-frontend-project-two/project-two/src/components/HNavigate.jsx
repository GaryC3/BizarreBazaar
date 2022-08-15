export const HNavigate = () => {
    var temp;
    console.log(localStorage.getItem("id"))
    if (localStorage.getItem("id")){
        temp = "btn btn-default m-5 py-3 px-5 signOne"
    }
    else{
        temp = "disabled btn btn-default m-5 py-3 px-5 signOne"
    }
    const handleLogout = ()=>{localStorage.removeItem("id")};
    return(
        <>
        <div class="text-center pt-2 pb-5">
            <a href="/sign" class="btn btn-default m-5 py-3 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"} }>Create</a>
            <a href="/sign2" class="btn btn-default m-5 py-3 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Sign-In</a>
        </div>
        <div class="text-center pb-5">
            <a href="/purchase" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Browse</a>
            <a href="/owned" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Owned</a>
        </div>
        <div class="text-center">
        <a href="/merchant" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Manage</a>
        <a href="/" class={temp} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}} onClick={handleLogout}>Logout</a>
        </div>
        </>
    );
}
