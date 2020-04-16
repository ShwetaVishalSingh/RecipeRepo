import React, {useState} from 'react'
import './Register.css'
import showNotification from "../utilis/Notifications";
import {postData} from "../services/Ajax";


const AddSeller = (props) => {
    const seller = props.seller;
    const [data, setData] = useState({
        id: "",
        name: "",
        phone: "",
        email: "",
        image: "",
        address: "",
        city: "",
        state: "",
        postalCode: ""
    });

    const handleInputChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        data[name] = value;
        setData(data);
        return true;
    };
    const handlePostData = async (event) => {
        event.preventDefault();
        data['id'] = seller.id;
        data["name"] = seller.firstName;
        data["email"] = seller.email;
        data["phone"] = seller.phone;
        setData(data);

        const response = await postData("/api/seller/addSeller", data);

        if (response.status === 200) {
             props.history.push("/");
            showNotification("Seller Added", "You have been added as a seller", "success");
        } else {
            showNotification("Error!", "Seems like you are missing some required details or you are not providing valid details.", "danger");
        }
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
                                        CONTINUE....
                                    </h2>
                                </div>

                                <p>PLEASE FILL OUT ALL REQUIRED* FIELDS. THANKS!</p>

                                <form onSubmit={handlePostData} className="reservations-box"
                                      name="registrationForm">
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="name"
                                                   id="name"
                                                   placeholder="Name"
                                                   value={seller.firstName}
                                                   required="required" data-error="Name is required."/>
                                        </div>
                                    </div>

                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="email" onChange={handleInputChange} name="userName"
                                                   id="email"
                                                   placeholder="E-Mail ID"
                                                   value={seller.email}
                                                   required="required" data-error="E-mail id is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="phone"
                                                   id="phone"
                                                   value={seller.phone}
                                                   placeholder="Phone"
                                                   required="required" data-error="Phone number is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="image"
                                                   id="image" placeholder="Seller Image"
                                                   required="required" data-error="Seller image is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="address"
                                                   id="address" placeholder="Address"
                                                   required="required" data-error="Address is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" name="city" id="form_name"
                                                   placeholder="City"
                                                   onChange={handleInputChange}
                                                   required="required" data-error="City is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="state"
                                                   id="state"
                                                   placeholder="State" data-error="State is required."/>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div className="form-box">
                                            <input type="text" onChange={handleInputChange} name="postalCode"
                                                   id="postalCode"
                                                   placeholder="Postal Code"
                                                   required="required" data-error="Postal is required."/>
                                        </div>
                                    </div>

                                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div className="reserve-book-btn text-center">
                                            <button className="hvr-underline-from-center" type="submit"
                                                    id="register">CREATE
                                            </button>
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
export default AddSeller
