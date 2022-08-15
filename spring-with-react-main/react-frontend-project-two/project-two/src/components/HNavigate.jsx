export const HNavigate = () => {

    console.log(localStorage.getItem("id"))
    console.log(localStorage.getItem("token"))

    var userPermission = "disabled btn btn-default m-5 py-3 px-5 signOne";
    var adminPermission = "disabled btn btn-default m-5 py-3 px-5 signOne";
    console.log(localStorage.getItem("id"))
    if (localStorage.getItem("id")){
        userPermission = "btn btn-default m-5 py-3 px-5 signOne"
    }
    if (localStorage.getItem("admin") != "null"){
        console.log("aadadadad")
        adminPermission = "btn btn-default m-5 py-3 px-5 signOne"
    }
    console.log(localStorage.getItem("admin"))
    console.log(adminPermission)
    
    const handleLogout = ()=>{localStorage.clear()};
    return(
        <>
        <div class="text-center pt-2 pb-5">
            <a href="/sign" class="btn btn-default m-5 py-3 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"} }>Create</a>
            <a href="/sign2" class="btn btn-default m-5 py-3 px-5 signOne" role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Sign-In</a>
        </div>
        <div class="text-center pb-5">
            <a href="/purchase" class={userPermission} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Browse</a>
            <a href="/owned" class={userPermission} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Owned</a>
        </div>
        <div class="text-center">
        <a href="/merchant" class={adminPermission} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}}>Manage</a>
        <a href="/" class={userPermission} role="button" aria-pressed="true" style={{fontSize: "40px", fontFamily:"serif"}} onClick={handleLogout}>Logout</a>
        </div>
        </>
    );
}
