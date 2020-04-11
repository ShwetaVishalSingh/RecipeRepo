import { createBrowserHistory } from 'history';
import { ApplicationPaths } from './ApiAuthorizationConstants';
import {getCookie, setCookie} from '../CookieService'
import {GetBaseRoute} from '../../utilis/Enviroment';
import {postData} from '../Ajax'

const history = createBrowserHistory({ basename: GetBaseRoute() });

const cuser = "currentUser";

export class AuthorizeService {

    _isAuthenticated = false;
    async redirectToLoginPage(){
        if(history.location.pathname !== ApplicationPaths.LoginPath){
            window.location = ApplicationPaths.LoginPath;
        }
    }

    async getUser() {
        const user = getCookie(cuser);
        if(user){
            return JSON.parse(user);
        }
      return null;
    }

    async getAccessToken() {
        const user = await this.getUser()
        if(user && user.token){
            return user.token;
        }
       await(this.redirectToLoginPage());
    }

    async register(user) {
        const response = await postData(
            ApplicationPaths.Register,user,true
            );
        var result = await response;

        return result;
    }

    async update(user) {
        const response = await postData(
            ApplicationPaths.UpdateUser, user,true
        );
        var result = await response;

        return result;
    }

    async signIn(user) {
        const response = await postData(
            ApplicationPaths.Login,user
            );
        var result = await response;
        if(result.status !== 200){
            return false;
        }
        try {
            const resp = await result.json();
            if(resp && resp.token){
                const jsonUser = JSON.stringify(resp);
                setCookie(cuser,jsonUser )
                return true;
            }

            return false;

        } catch (error) {
            console.error(error);
            return false;
        }

    }

    async signOut(state) {
        setCookie(cuser,null)
        return true;
    }


    createArguments(state) {
        return { useReplaceToNavigate: true, data: state };
    }

    error(message) {
        return { status: AuthenticationResultStatus.Fail, message };
    }

    success(state) {
        return { status: AuthenticationResultStatus.Success, state };
    }

    redirect() {
        return { status: AuthenticationResultStatus.Redirect };
    }


    static get instance() { return authService }
}

const authService = new AuthorizeService();

export default authService;

export const AuthenticationResultStatus = {
    Redirect: 'redirect',
    Success: 'success',
    Fail: 'fail'
};
