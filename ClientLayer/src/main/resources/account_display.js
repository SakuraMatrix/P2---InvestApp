function printAccount(account){
  let text = ""
  for (let key in account){
    text += key + " " + account[key] + "<br>";
  }
  document.getElementById('account_display').innerHTML = text
}

let account = {};

const getAccount = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const account_id = urlParams.get('account_id');
  const responseJSON = await fetch("localhost:8080/accounts/" + account_id);
  account = await reponseJSON.json();
}

getAccount.then(request => printAccount(request));