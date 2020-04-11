
import authService from './api-authorization/AuthorizeService'


function GetBaseUrl(){
  // if(isEnviroment("testing")){
  //   return "https://ix01dazwewebstoreadmin-testing.azurewebsites.net";
  // }
  // if(isEnviroment("staging")){
  //   return "https://ix01dazwewebstoreadmin-staging.azurewebsites.net";
  // }
  // if(isEnviroment("production")){
  //   return "https://ix01dazwewebstoreadmin.azurewebsites.net";
  // }

  return "";

}
const baseUrl = GetBaseUrl();

async function getAccessToken(){
  const token = await authService.getAccessToken();
  if(token){
    return token;
  }
  console.log("no token")
  return ""
}


async function buidHeader(contentType){
  const accessToken = await getAccessToken();
  if(!contentType || contentType === ''){
    return {
      'Authorization': 'Bearer '+accessToken 
    }
  }
  return {
    'Content-Type': contentType,
    'Authorization': 'Bearer '+accessToken, 
  }
}

export async function getData(url = '') {
  // Default options are marked with *
    const header = await buidHeader('application/json');
    const response = await fetch(baseUrl+url, {
    method: 'GET',
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    headers: header,
  });
  const result = await response;
  if(result.status === 401){
    authService.redirectToLoginPage()

    return;
  }
  if(result.status !== 200){
    console.error(result);
  }


  return result.json(); // parses JSON response into native JavaScript objects
};

export async function postData(url = '', data = {}, isJson = false) {
  // Default options are marked with *
  const header = await buidHeader('application/json');
  const response = await fetch(baseUrl+url, {
    method: 'POST',
    
    // mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    // credentials: 'same-origin', // include, *same-origin, omit
    headers: header,
    // redirect: 'follow', // manual, *follow, error
    // referrer: 'no-referrer', // no-referrer, *client
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  const result = await response;
  if(result.status !== 200){
    console.error(result);
  }
  if(isJson){
    return result.json(); // parses JSON response into native JavaScript objects
  }
  return result; // parses JSON response into native JavaScript objects
};

export async function postMultiPartData(url = '', data) {
  // Default options are marked with *
  const header = await buidHeader();
  const response = await fetch(baseUrl+url, {
    method: 'POST',
    
    // mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    // credentials: 'same-origin', // include, *same-origin, omit
    headers: header,
    // redirect: 'follow', // manual, *follow, error
    // referrer: 'no-referrer', // no-referrer, *client
    body: data // body data type must match "Content-Type" header
  });
  const result = await response;
  if(result.status !== 200){
    console.error(result);
    return result;
  }
  return result.json(); // parses JSON response into native JavaScript objects
};

