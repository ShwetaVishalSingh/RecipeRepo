import React from 'react'
import Header from "./Header";

const CreateRecipe = (props) => {
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
                                    <form id="contact-form" method="post" className="reservations-box"
                                          name="contactform"
                                          action="mail.php">
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="recipeName" placeholder="Name"
                                                       required="required" data-error="Recipe name is required."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="recipeImage" placeholder="Image"
                                                       required="required" data-error="Image is required."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="number" name="portion" placeholder="Portion"
                                                       required="required" data-error="Portion is required"/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <input type="text" name="type" placeholder="Type of recipe ex. Sushi"
                                                       required="required" data-error="Type of recipe."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="portion"
                                                          placeholder="Please enter the description."
                                                          required="required"
                                                          data-error="Please enter comma separate list of ingredients."/>
                                            </div>
                                        </div>

                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="cookingStep" placeholder="Cooking step"
                                                          required="required" data-error="Please tell us how to cook."/>
                                            </div>
                                        </div>
                                        <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div className="form-box">
                                                <textarea type="text" name="ingredients"
                                                          placeholder="Please enter comma separate list of ingredients."
                                                          required="required"
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
export default CreateRecipe
