
export const Home = () => {
    return(
        <>
        <div >
            <h1 class="text-center" style={{fontSize: "40px"}}>The Bizarre Bazaar</h1>
        </div>
        <div>
        <a href="/merchant" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Create</a>
        <a href="/merchant" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Owned</a>
        </div>
        <a href="/merchant" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Browse</a>
        <a href="/merchant" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Manage</a>
        </>
    );
}
