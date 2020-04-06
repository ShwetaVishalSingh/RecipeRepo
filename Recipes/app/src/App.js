import React from 'react';
import './App.css';
import Header from "./components/Header";
import About from "./components/AboutUs";
import Home from "./components/Home";
import Menu from "./components/Menu";
import Team from "./components/Team";
import Gallery from "./components/Gallery";
import Blog from "./components/Blog";
import SignIn from "./components/SignIn";
import Reservation from "./components/Reservation";
import ContactUs from "./components/ContactUs";
import Loader from "./components/Loader";
import ColorPannel from "./components/ColorPannel";


const App = () => {
    return (
        <div className="App">
           <Loader/>
           <Header/>
           <Home/>
           <About/>
           <Menu/>
           <Team/>
           <Gallery/>
           <Blog/>
           <Reservation/>
           <SignIn/>
           <ContactUs/>
           <ColorPannel/>
        </div>
    );
}

export default App;
