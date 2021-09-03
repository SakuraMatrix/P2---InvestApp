function printCreditCard(credit_card){
  let text = ""
  for (let key in account){
    text += key + " " + account[key] + "<br>";
  }
  document.getElementById('account_display').innerHTML = text
}

let my_credit_card = {};

const getAccount = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const account_id = urlParams.get('ccid');
  const responseJSON = await fetch("localhost:8080/creditcards/" + ccid);
  account = await reponseJSON.json();
}

getAccount.then(request => printAccount(request));