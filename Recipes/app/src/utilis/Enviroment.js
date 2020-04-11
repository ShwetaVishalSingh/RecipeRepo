export function isEnviroment(env) {
    console.log(process.env.NODE_ENV);
    return process && process.env && process.env.NODE_ENV && process.env.NODE_ENV.trim() === env;
}
export function GetBaseRoute() {
    //alert(process && process.env && process.env.BASE_ROUTE && process.env.BASE_ROUTE.trim())
    return '/';
}

export function GetGoogleAPiKey() {
    const apikey = process && process.env && process.env.GOOGLEMAPSAPIKEY && process.env.GOOGLEMAPSAPIKEY.trim();
    return apikey;
}