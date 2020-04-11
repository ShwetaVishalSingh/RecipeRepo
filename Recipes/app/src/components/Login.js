import React, {useState} from 'react';
import {white} from "color-name";
import showNotification from "../utilis/Notifications";
import {postData} from "../services/Ajax";

const goToRegisterPage = (props) => {
    return (
        props.history.push("/register")
    );
};

function notImplementedYet() {
    showNotification("Oopps!!", "Thanks for choosing the option.. we will enable this feature soon", "warning")
}

const Login = (props) => {
    const [data, setData] = useState({userName: "", password: ""});

    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value
        setData(data);
        return true;
    };
    const handlePostData = async (event) => {
        event.preventDefault();
        const response = await postData("/api/user/login", data);
        const result = await response.json();
        if (response.status === 200) {
            props.history.push("/home")
            showNotification("Login Successful", result.message, "success")
        } else {
            showNotification("Error", result.message, "danger")
        }
    };

    return (
        <div>
            <div id="site-header">
                <header id="header" className="header-block-top">
                    <div className="container">
                        <div className="row">
                            <div className="main-menu">
                                <nav className="navbar navbar-default" id="mainNav">
                                    <div className="navbar-header">
                                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse"
                                                data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                            <span className="sr-only">Toggle navigation</span>
                                            <span className="icon-bar"></span>
                                            <span className="icon-bar"></span>
                                            <span className="icon-bar"></span>
                                        </button>
                                        <div className="logo">
                                            <a className="navbar-brand js-scroll-trigger logo-header" href="#">
                                                <img src="images/logo.png" alt=""></img>
                                            </a>
                                        </div>
                                    </div>
                                    <div id="navbar" className="navbar-collapse collapse">
                                        <ul className="nav navbar-nav navbar-right">
                                            <div className="reserve-book-btn text-center">
                                                <button className="hvr-underline-from-center" type="button"
                                                        onClick={() => {
                                                            goToRegisterPage(props)
                                                        }}>Sign Up
                                                </button>
                                            </div>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </header>
            </div>
            <div id="logIn" className="banner full-screen-mode parallax">
                <div className="gallery-main pad-top-100 pad-bottom-100">

                    <div className="container">
                        <div className="row">
                            <div className="form-reservations-box">
                                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                        <h2 className="block-title text-center">
                                            Sign in to Account
                                        </h2>
                                    </div>

                                    <form onSubmit={handlePostData} className="reservations-box"
                                          name="loginForm">
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
                                                <input type="password" onChange={handleInputChange} name="password"
                                                       id="phoneNumber" placeholder="Password"
                                                       required="required" data-error="Password is required."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div className="reserve-book-btn text-center">
                                                <button className="hvr-underline-from-center" type="submit">SUBMIT
                                                </button>
                                                <div className="sf-team text-col">
                                                    <ul className="team-social">
                                                        <li><a href="#" onClick={notImplementedYet}><i className="fa fa-facebook"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#" onClick={notImplementedYet}><i className="fa fa-google-plus"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#" onClick={notImplementedYet}><i className="fa fa-twitter"
                                                                           aria-hidden="true"></i></a>
                                                        </li>
                                                        <li><a href="#" onClick={notImplementedYet}><i className="fa fa-linkedin"
                                                                           aria-hidden="true"></i></a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};
export default Login
