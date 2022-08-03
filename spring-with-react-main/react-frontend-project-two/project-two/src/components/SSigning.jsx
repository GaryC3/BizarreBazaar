export const SSigning = () => {
    return(
        <>
        <div class="input-group mb-3 long">
            <input type="text" class="form-control bg-light" placeholder="First Name" aria-label="FirstName" />
            <input type="text" class="form-control bg-light" placeholder="Last Name" aria-label="LastName" />
        </div>
        <div class="input-group mb-3">
            <div>
                <div>
                    <input type="text" class="form-control bg-light long2" placeholder="Email" aria-label="Email" />
                </div>
                <div>
                    <input type="password" class="form-control bg-light long2" placeholder="Password" aria-label="Password" />
                </div>
            </div>
            <div>
                <button class="btn btn-primary active button1" type="button">Submit</button>
            </div>
        </div>
        </> 
    );
}