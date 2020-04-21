export async function getData(url = '') {
  const response = await fetch("" + url, {
    method: 'GET',
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
  });
  const result = await response;
  if (result.status !== 200) {
    console.error(result);
  }
  return result.json(); // parses JSON response into native JavaScript objects
};
export async function postData(url = '', data = {}, isJson = false) {
  const response = await fetch("" + url, {
    method: 'POST',
    // mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    // credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    // redirect: 'follow', // manual, *follow, error
    // referrer: 'no-referrer', // no-referrer, *client
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  const result = await response;
  if (result.status !== 200) {
    console.error(result);
  }
  if (isJson) {
    return result.json(); // parses JSON response into native JavaScript objects
  }
  return result; // parses JSON response into native JavaScript objects
}