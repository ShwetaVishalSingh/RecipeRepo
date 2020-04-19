import React, {useEffect, useState} from 'react'
import Header from "./Header";
import {getData} from "../services/Ajax";


const Recipes = (props) => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await getData(
                '/api/recipe/'
            );
            const result = await response;
            setData(result.recipeList);
            console.log(result)
        };
        fetchData();
    }, []);
    const createRecipe = () => {
        props.history.push("/createRecipe")
    };
    const addSeller = () => {
        props.history.push("/addSeller")
    };
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
                                <div className="reserve-book-btn text-right">

                                    <button className="reserve-book-btn text-right hvr-underline-from-center" type="submit"
                                            onClick={createRecipe} id="submit">Add Recipe
                                    </button>
                                </div>
                            </div>
                            <div className="reserve-book-btn text-right">

                            </div>
                            <div className="team-box">

                                <div className="row">
                                    {data && data.map(item => (
                                        <div className="col-md-4 col-sm-6">
                                            <div className="sf-team">
                                                <div className="thumb">
                                                    <a href="#"><img src={item.image} alt=""/></a>
                                                </div>
                                                <div className="text-col">
                                                    <h3>{item.recipeName}</h3>
                                                    <p>{item.description}</p>

                                                </div>
                                            </div>
                                        </div>
                                    ))}
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
