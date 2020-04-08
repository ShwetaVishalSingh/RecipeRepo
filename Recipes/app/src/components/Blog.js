import React from 'react'

const Blog = () => {
    return(
        <div id="blog" className="blog-main pad-top-100 pad-bottom-100 parallax">
            <div className="container">
                <div className="row">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h2 className="block-title text-center">
                            Our Blog
                        </h2>
                        <div className="blog-box clearfix">
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <div className="col-md-6 col-sm-6">
                                    <div className="blog-block">
                                        <div className="blog-img-box">
                                            <img src="images/featured-image-01.jpg" alt=""/>
                                            <div className="overlay">
                                                <a href=""><i className="fa fa-link" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div className="blog-dit">
                                            <p><span>25 NOVEMBER, 2014</span></p>
                                            <h2>LATEST RECIPES JUST IN!</h2>
                                            <h5>BY John Doggett</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <div className="col-md-6 col-sm-6">
                                    <div className="blog-block">
                                        <div className="blog-img-box">
                                            <img src="images/featured-image-02.jpg" alt=""/>
                                            <div className="overlay">
                                                <a href=""><i className="fa fa-link" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div className="blog-dit">
                                            <p><span>2 NOVEMBER, 2014</span></p>
                                            <h2>NEW RECRUITS HAVE ARRIVED!</h2>
                                            <h5>BY Jeffrey Spender</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <div className="col-md-6 col-sm-6">
                                    <div className="blog-block">
                                        <div className="blog-img-box">
                                            <img src="images/featured-image-03.jpg" alt=""/>
                                            <div className="overlay">
                                                <a href=""><i className="fa fa-link" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div className="blog-dit">
                                            <p><span>4 NOVEMBER, 2014</span></p>
                                            <h2>BAKING TIPS FROM THE PROS</h2>
                                            <h5>BY Monica Reyes</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="wow fadeIn" data-wow-duration="1s" data-wow-delay="0.1s">
                                <div className="col-md-6 col-sm-6">
                                    <div className="blog-block">
                                        <div className="blog-img-box">
                                            <img src="images/featured-image-04.jpg" alt=""/>
                                            <div className="overlay">
                                                <a href=""><i className="fa fa-link" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div className="blog-dit">
                                            <p><span>12 NOVEMBER, 2014</span></p>
                                            <h2>ALL YOUR EGGS BELONG TO US</h2>
                                            <h5>BY John Doggett</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="blog-btn-v">
                            <a className="hvr-underline-from-center" href="#">View the Blog</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
};

export default Blog
