import React, {useState} from 'react';

const Login = () => {
    const [data, setData] = useState({userName: "", password: ""});

    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value
        setData(data);
        return true;
    }
    const handlePostData = () => {
        fetch('/api/user/login', {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },

            body: JSON.stringify(data) // body data type must match "Content-Type" header
        }).then(function (response) {
            if (response.status === 200) {
                alert("Login successful..")
                window.location.reload()
            }else{
                alert("Something went wrong!")
            }
        })
        console.log(data)

    }
    const goToForgotPassword = () => {
        alert("forgot password")
    }

    return (
        <div id="logIn" className="reservations-main pad-top-100 pad-bottom-100">
            <div className="container">
                <div className="row">
                    <div className="form-reservations-box">
                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <h2 className="block-title text-center">
                                    LOGIN
                                </h2>
                            </div>

                            <p>Login to your account </p>

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
                                    <input type="password" onChange={handleInputChange} name="password"
                                           id="phoneNumber" placeholder="Password"
                                           required="required" data-error="Password is required."/>
                                </div>
                            </div>

                            <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div className="reserve-book-btn text-center">
                                    <button className="hvr-underline-from-center" type="submit" id="register"
                                           onClick={handlePostData} >SUBMIT
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
export  default Login
