import React, {Suspense} from 'react';
import {Route, Router, Switch} from 'react-router';
import Home from './components/Home';
import {GetBaseRoute} from './utilis/Enviroment';
import {createBrowserHistory} from 'history';
import About from "./components/AboutUs";
import Team from "./components/Team";
import Gallery from "./components/Gallery";
import CreateRecipe from "./components/CreateRecipe";
import Register from "./components/Register";
import Login from "./components/Login";
import ContactUs from "./components/ContactUs";
import Blog from "./components/Blog";
import Menu from "./components/Menu";
import ReactNotification from 'react-notifications-component'
import 'react-notifications-component/dist/theme.css'
import Recipes from "./components/Recipes";
import AddSeller from "./components/AddSeller";
import RegisterBusinessUser from "./components/RegisterBusinessUser";


const history = createBrowserHistory({basename: GetBaseRoute()});
const AppRoute = ({component: Component, layout: Layout, ...rest}) => (
    <Route {...rest} render={props => (
        <Layout history={history}>
            <Component history={history} {...props} />
        </Layout>
    )}/>
);
const App = () => {
    return (

        <Router history={history}>
            <Suspense fallback={Home}>
                <ReactNotification />
                <Switch>
                        <AppRoute exact path="/" layout={Login} component={Login}/>
                        <AppRoute exact path="/home" layout={Home} component={Home}/>
                        <AppRoute exact path="/about" layout={About} component={About}/>
                        <AppRoute exact path="/menu" layout={Menu} component={Menu}/>
                        <AppRoute exact path="/team" layout={Team} component={Team}/>
                        <AppRoute exact path="/gallery" layout={Gallery} component={Gallery}/>
                        <AppRoute exact path="/blog" layout={Blog} component={Blog}/>
                        <AppRoute exact path="/recipe" layout={Recipes} component={Recipes}/>
                        <AppRoute exact path="/createRecipe" layout={CreateRecipe} component={CreateRecipe}/>
                        <AppRoute exact path="/register" layout={Register} component={Register}/>
                        <AppRoute exact path="/registerBusinessUser" layout={RegisterBusinessUser} component={RegisterBusinessUser}/>
                        <AppRoute exact path="/contactus" layout={ContactUs} component={ContactUs}/>
                    </Switch>
            </Suspense>
        </Router>

    );
}
export default App;
