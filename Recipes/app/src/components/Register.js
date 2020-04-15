import React, {useState} from 'react'
import {postData} from "../services/Ajax";
import showNotification from "../utilis/Notifications";
import './Register.css'


const Register = (props) => {
    const [data, setData] = useState({userName: "", password: "", firstName: {}, lastName: {}, phoneNumber: {}});

    const handlePostData = async (event) => {
        event.preventDefault();
        const response = await postData("/api/user/register", data);
        if (response.status === 200) {
            const result = await response.json();
            props.history.push("/");
            showNotification("User Registered!", "Welcome!" + result.firstName + " " + result.lastName, "success");
        } else {
            showNotification("Error!", "Seems like you are missing some required details or you are not providing valid details.", "danger");
        }
    };

    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value
        setData(data)
        return true;
    }

    const registerAsSeller = () => {
      props.history.push("/registerBusinessUser")
    };

    return (
        <div id="signIn" className="banner full-screen-mode parallax">
            <div className="gallery-main pad-top-100 pad-bottom-100">
                <div className="container">
                    <div className="row">
                        <div className="form-reservations-box">
                            <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                    <h2 className="block-title text-center">
                                        SIGN UP
                                    </h2>
                                </div>

                                <p>PLEASE FILL OUT ALL REQUIRED* FIELDS. THANKS!</p>

                                <form onSubmit={handlePostData} className="reservations-box"
                                      name="registrationForm">
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="email" onChange={handleInputChange} name="userName"
                                                   id="userName"
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
                                            <input type="text" onChange={handleInputChange} name="firstName"
                                                   id="firstName"
                                                   placeholder="First Name" data-error="First name is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="lastName"
                                                   id="lastName"
                                                   placeholder="Last Name"
                                                   required="required" data-error="Last name is required."/>
                                        </div>
                                    </div>

                                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div className="reserve-book-btn text-center">
                                            <button className="hvr-underline-from-center" type="submit" id="register">SUBMIT
                                            </button>
                                            &nbsp;&nbsp;&nbsp;
                                            <span><a className="register-seller" href="#" onClick={registerAsSeller}>If you wanted to register as seller. Click here!</a></span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};
export default Register
