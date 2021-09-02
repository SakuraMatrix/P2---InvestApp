
	function loanServices(evt, Request) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(Request).style.display = "block";
	  evt.currentTarget.className += " active";
	}

	function getTime(){
		var dt = new Date();
		document.getElementById('timestamp').innerHTML=dt;
	}

	getTiem()

let AllOfOne = {}
let  viewAll= {}
let application = {}



const getAll = async ()  => {
    const responseJSON  =await fetch("./Loans/vall/0")
    viewAll =  await responseJSON.json();
    document.getElementById("viewAll").innerHTML(View);
}
	function  printViewAll(){
		document.getElementById('viewAll').innerHTML = viewAll;
	}
getAllOfOne().then(request => printViewAllOfOne())	
	
	
function  printViewAllOfOne(){
    document.getElementById('AllOfOne').innerHTML = AllOfOne;
}
const getAllOfOne = async () => {
	let account_id = document.getElementById("account_id").innerText.toString;
    const responseJson = await fetch("api/v0.1/loans/vall/"+ account_id);
    AllOfOne =  await responseJson.text();
}
getAll().then(request => printViewAll())


	
function  printApplication(){
	document.getElementById('application').innerHTML = application;
}

const getApplication = async() => {
  const responseJson = await fetch("api/v0.1/Loans/vall/")
	let applicant = document.getElementsByClassName("applicant")
  application =  await responseJSON.json();
  document.getElementById("application").innerHTML(View)
}

getApplication().then(request => printViewAll())
