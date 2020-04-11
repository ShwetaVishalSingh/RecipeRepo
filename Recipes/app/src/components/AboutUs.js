import React from 'react'
import Header from "./Header";


const About = (props) => {
    return (
        <div>
            <Header history={props.history}/>
            <div id="about" className="banner full-screen-mode parallax">
                <div className="gallery-main pad-top-100 pad-bottom-100">
                    <div className="about-main pad-top-100 pad-bottom-100">

                        <div className="container">
                            <div className="row">
                                <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                    <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                        <h2 className="block-title"> About Us </h2>
                                        <h3>IT STARTED, QUITE SIMPLY, LIKE THIS...</h3>
                                        <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusm
                                            incididunt
                                            ut
                                            labore et dolore magna aliqua. Ut enim ad minim venia, nostrud exercitation
                                            ullamco. </p>

                                        <p> Aenean commodo ligula eget dolor aenean massa. Cum sociis nat penatibu set
                                            magnis
                                            dis
                                            parturient montes, nascetur ridiculus mus. quam felisorat, ultricies nec,
                                            Aenean
                                            commodo
                                            ligula eget dolor penatibu set magnis is parturient montes, nascetur
                                            ridiculus
                                            mus.
                                            quam
                                            felisorat, ultricies nec, pellentesque eu, pretium quis, sem. quat massa
                                            quis
                                            enim.
                                            Donec vitae sapien ut libero venenatis fauci Nullam quis ante. Etiam sit
                                            amet
                                            rci
                                            eget
                                            eros. </p>

                                        <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusm
                                            incididunt
                                            ut
                                            labore et dolore magna aliqua. Ut enim ad minim venia, nostrud exercitation
                                            ullamco. </p>
                                    </div>
                                </div>
                                <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                    <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                        <div className="about-images">
                                            <img src="images/about-main.jpg" alt=""/>
                                            <img src="images/about-inset.jpg" alt=""/>
                                            {/*<img className="about-main" src={logo} alt="About Main Image"/>
                                    <img className="about-inset" src={logo1} alt="About Inset Image"/>*/}
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
export default About
