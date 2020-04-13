import React from 'react'
import Header from "./Header";

const Recipes = (props) => {
    return (
        <div>
            <Header history={props.history}/>

            <div className="team-main pad-top-100 pad-bottom-100 parallax">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <h2 className="block-title text-center">
                                    Our Recipes
                                </h2>
                            </div>
                            <div className="team-box">

                                <div className="row">
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/chicken_curry.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>Chicken Curry</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/chicken_gavthi.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>Chicken Curry Gavthi</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/chicken-tandoori.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>Chicken Tandoori</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/staff-01.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>John Doggett</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/staff-02.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>Jeffrey Spender</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-4 col-sm-6">
                                        <div className="sf-team">
                                            <div className="thumb">
                                                <a href="#"><img src="images/staff-03.jpg" alt=""/></a>
                                            </div>
                                            <div className="text-col">
                                                <h3>Monica Reyes</h3>
                                                <p>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.
                                                    Duis
                                                    leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis
                                                    magna.
                                                    Aenean commodo ligula.</p>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Recipes
