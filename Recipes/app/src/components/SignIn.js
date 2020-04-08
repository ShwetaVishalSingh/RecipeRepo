import React, {useState} from 'react'

const SignIn = () => {
    const [data, setData] = useState({userName: "", password: "", firstName: {}, lastName: {}, phoneNumber: {}});

    const postData = () => {
        fetch('/api/user/register', {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },

            body: JSON.stringify(data) // body data type must match "Content-Type" header
        }).then(function (response) {
            if (response.status === 200) {
                alert("User has been created.. Please login..")
                window.location.reload()
            }else{
                alert("Something went wrong!")
            }
        })
    }


    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value
        setData(data)
        return true;
    }

    return (
        <div id="signIn" className="reservations-main pad-top-100 pad-bottom-100">
            <div className="container">
                <div className="row">
                    <div className="form-reservations-box">
                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <h2 className="block-title text-center">
                                    LOGIN / SIGN UP
                                </h2>
                            </div>

                            <p>PLEASE FILL OUT ALL REQUIRED* FIELDS. THANKS!</p>

                            {/*<form onSubmit={postData} className="reservations-box"
                                  name="registrationForm">*/}
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="email" onChange={handleInputChange} name="userName" id="userName"
                                           placeholder="E-Mail ID"
                                           required="required" data-error="E-mail id is required."/>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="text" onChange={handleInputChange} name="phoneNumber"
                                           id="phoneNumber" placeholder="Phone"
                                           required="required" data-error="Phone is required."/>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="password" onChange={handleInputChange} name="password"
                                           id="password" placeholder="Password"
                                           required="required" data-error="Password is required."/>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="password" name="confirmPassword" id="form_name"
                                           placeholder="Confirm Password"
                                           required="required" data-error="Confirm Password is required."/>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="text" onChange={handleInputChange} name="firstName" id="firstName"
                                           placeholder="First Name" data-error="First name is required."/>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div className="form-box">
                                    <input type="text" onChange={handleInputChange} name="lastName" id="lastName"
                                           placeholder="Last Name"
                                           required="required" data-error="Last name is required."/>
                                </div>
                            </div>
                            {/*
                                <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div className="form-box">
                                        <select name="no_of_persons" id="no_of_persons" className="selectpicker">
                                            <option selected disabled>No. Of persons</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                        </select>
                                    </div>
                                </div>

                                <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div className="form-box">
                                        <select name="preferred_food" id="preferred_food" className="selectpicker">
                                            <option selected disabled>preferred food</option>
                                            <option>Indian</option>
                                            <option>Continental</option>
                                            <option>Mexican</option>
                                        </select>
                                    </div>
                                </div>
                                <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div className="form-box">
                                        <select name="occasion" id="occasion" className="selectpicker">
                                            <option selected disabled>Occasion</option>
                                            <option>Wedding</option>
                                            <option>Birthday</option>
                                            <option>Anniversary</option>
                                        </select>
                                    </div>
                                </div>*/}
                            <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div className="reserve-book-btn text-center">
                                    <button className="hvr-underline-from-center" type="submit" id="register"
                                            onClick={postData}>SUBMIT
                                    </button>
                                </div>
                            </div>
                            {/*</form>*/}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};
export default SignIn
