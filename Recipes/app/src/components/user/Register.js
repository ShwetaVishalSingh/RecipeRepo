import React, {useState} from 'react'

const Register = () => {
    const [data, setData] = useState({userName: "", password: "", firstName: {}, lastName: {}, phoneNumber: {}});

    async function postData() {
        // Default options are marked with *
        const response = await fetch('/api/user/register', {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },

            body: JSON.stringify(data) // body data type must match "Content-Type" header
        }).then(function (response) {
            //Promise.resolved(response)
            console.log(response)
            alert(response.body)
        })

        // parses JSON response into native JavaScript objects
    }


    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value
        setData(data)
        return true;
    }

    return (
        <div>
            <h1>User Registration</h1>
            <p>
                Please fill in all the required fields to create a new user account.
            </p>


                <div className="form-group">

                    <label>Username</label> <input type="text" className="form-control" placeholder="Username"
                                                   name="userName" required onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Password" name="password"
                           required onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>First Name</label>
                    <input type="text" className="form-control" placeholder="First Name" name="firstName"
                           onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>Last Name</label>
                    <input type="text" className="form-control" placeholder="Last Name" name="lastName"
                           onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>Phone Number</label>
                    <input type="text" className="form-control" placeholder="Phone Number" name="phoneNumber"
                           onChange={handleInputChange}/>
                </div>

                <button type="submit" className="btn btn-primary" onClick={postData}>Submit</button>
        </div>

    )
}

export default Register
