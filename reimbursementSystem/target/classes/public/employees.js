// Table row template
{/* <tr>
          <td class="text-center">CATEGORY</td>
          <td class="text-center">Employee Notes</td>
          <td class="text-center">Amount</td>
          <td class="text-center">  
            <!-- Button to Open the Modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
              Open modal
            </button>
        </td>
        </tr> */}

async function insertNewRequest(){
  let description = document.getElementById("Description").value;
  let amount = document.getElementById("Amount").value;
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
  // let tableBody = document.getElementById("tableBody");
  //http://localhost:7050/requestA/:account_id

  var raw=JSON.stringify({
    "account_id":JSON.parse(localStorage.getItem('account_id')),
    "conditiontype_id":1,
    "description":`${description}`,
    "amount":amount
  });
	var requestOptions = {
		method: 'POST',
		headers: myHeaders,
		body: raw,
		redirect: 'follow'
	};

  let response = await fetch("http://localhost:7050/request", requestOptions)
  window.alert("insert success!");
  showAllRequest();

}

async function showAllRequest() {
  
	let tableBody = document.getElementById("tableBody");
	let response = await fetch(`http://localhost:7050/requestA/${JSON.parse(localStorage.getItem('account_id'))}`);
	let info = await response.json();
  tableBody.innerHTML=``;
	for (let index = 0; index < info.length; index++) {
    let condition="";
		const element = info[index];
		if(element.conditiontype_id==1){
      condition="pending";
    }else if(element.conditiontype_id==2){
      condition="approved";
    }else if(element.conditiontype_id==3){
      condition="declined";
    }
    tableBody.innerHTML += `
            <tr>
                <td class="text-center col-8" style="word-wrap: break-word;">${element.description}</td>
                <td class="text-center col-2">${element.amount}</td>
                <td class="text-center col-2">${condition} </td>
            </tr>
        `;
	}
}



