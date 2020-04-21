import {getData} from "../Ajax";

class AuthorizeService {
    async executeBasicAuthenticationService(username, password) {
        console.log(this.createBasicAuthToken(username, password))
        return await getData(
            '/basicauth',
            {headers: {authorization: this.createBasicAuthToken(username, password)}}
        )
    }

    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }

}

export default new AuthorizeService()