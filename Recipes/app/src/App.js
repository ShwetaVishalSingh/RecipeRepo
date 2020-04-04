import React from 'react';
import './App.css';
import Register from "./components/user/Register";

const App = () => {
    return (
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <Register/>

                </div>
            </header>
        </div>
    );
}

export default App;
