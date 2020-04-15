import React, {useState} from 'react'
import Header from "./Header";
import {postData} from "../services/Ajax";
import showNotification from "../utilis/Notifications";

const AddSeller = (props) => {
    const [data, setData] = useState({recipeName: "", recipeImage: "", portion: 0, type: "", ingredients: "", description:"", cookingStep:""});

    const handlePostData = async (event) => {
        event.preventDefault();
        const response = await postData("/api/recipe/addRecipe", data);
        if (response.status === 200) {
            const result = await response.json();
            props.history.push("/recipe");
            showNotification("Recipe Created!", result.message, "success");
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

    return (
        <div>
            <Header history={props.history}/>
            <div id="reservation" className="banner full-screen-mode parallax">
                <div id="reservation" className="team-main pad-top-100 pad-bottom-100 parallax">
                    <div className="container">
                        <div className="row">
                            <div className="form-reservations-box">
                                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                        <h2 className="block-title text-center">
                                            Recipes
                                        </h2>
                                    </div>
                                    <form onSubmit={handlePostData} className="reservations-box"
                                          name="recipeForm">
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="recipeName" placeholder="Name"
                                                       required="required" onChange={handleInputChange} data-error="Recipe name is required."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="recipeImage" placeholder="Image"
                                                       required="required" onChange={handleInputChange} data-error="Image is required."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="number" name="portion" placeholder="Portion"
                                                       required="required" onChange={handleInputChange} data-error="Portion is required"/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="type" placeholder="Type of recipe ex. Sushi"
                                                       required="required" onChange={handleInputChange} data-error="Type of recipe."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="description"
                                                          placeholder="Please enter the description."
                                                          required="required"
                                                          onChange={handleInputChange}
                                                          data-error="Please enter comma separate list of ingredients."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="cookingStep" placeholder="Cooking step"
                                                          required="required" onChange={handleInputChange} data-error="Please tell us how to cook."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="ingredients"
                                                          placeholder="Please enter comma separate list of ingredients."
                                                          required="required"
                                                          onChange={handleInputChange}
                                                          data-error="Please enter comma separate list of ingredients."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div className="reserve-book-btn text-center">
                                                <button className="hvr-underline-from-center" type="submit"
                                                        id="submit">Create
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
        </div>
    )
};
export default AddSeller
