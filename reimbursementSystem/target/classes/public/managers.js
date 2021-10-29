function checkOrCancelAll() {
    var chElt = document.getElementById("checkbox");
    var checkedElt = chElt.checked;
    console.log(checkedElt)
    var allCheck = document.getElementsByName("defaultCheck");
    if (checkedElt) {
        for (var i = 0; i < allCheck.length; i++) {
            allCheck[i].checked = true;
        }
    } else {
        for (var i = 0; i < allCheck.length; i++) {
            allCheck[i].checked = false;
        }
    }
}
async function updateAll() {
    var alert = 0;
    window.alert("trying to update");
    var check = $("input[name='defaultCheck']:checked");
    check.each(function () {
        var row = $(this).parent("td").parent("tr");
        var request_id = row.find("[name='request_id']").html();
        var note = row.find("[name='note']").val();
        var conditiontype = row.find("[name='conditiontype']").html();
        if (conditiontype == "approved") {
            if (note == null || note == "") {
                update(request_id, "", 2);
            } else {
                update(request_id, note, 2);
            }

        }
        else if (conditiontype == "declined") {
            if (note == "" || note == null) {
                if (alert == 0) {
                    alert++;
                    window.alert("please fill in the note if you decline the request");
                }
                return;
            }
            update(request_id, note, 3);
        }
        showAllPendingRequest();

    });
}
async function update(requestId, note, statusId) {
    if ((note == null || note == "") && statusId == 3) return;
    let myHeaders = new Headers();
    myHeaders.append("Content-type", "application/json");

    var raw = JSON.stringify({
        "request_id": requestId,
        "note": `${note}`,
        "conditiontype_id": statusId
    });

    let requestOptions =
    {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    let response = await fetch("http://localhost:7050/request", requestOptions)

}
async function changeValuep(id) {

    let status = document.getElementById("status" + id);
    status.innerHTML = `pending`;

}
async function changeValuea(id) {

    let status = document.getElementById("status" + id);
    status.innerHTML = `approved`;
}
async function changeValued(id) {

    let status = document.getElementById("status" + id);
    status.innerHTML = `declined`;

}
async function showAllPendingRequest() {

    let tableBody = document.getElementById("tableBody");
    let response = await fetch(`http://localhost:7050/requests`);
    let info = await response.json();
    tableBody.innerHTML = ``;
    for (let index = 0; index < info.length; index++) {
        let condition = "";
        const element = info[index];

        if (element.conditiontype_id == 1) {
            condition = "pending";
            tableBody.innerHTML += `
            <tr>
            <td class="text-center "><input class="form-check-input" type="checkbox" value="" id="defaultCheck" name="defaultCheck"></td>
            <td class="text-center col-1" style="word-wrap: break-word;">${element.account_id}</td>
            <td class="text-center col-1" name="request_id">${element.request_id}</td>
            <td class="text-center col-3">${element.description}</td>
            <td class="text-center col-2">${element.amount}</td>
            <td class="text-center col-3"><input type="text" placeholder="note" name="note"></td>
            <td class="text-center col-2">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="status${index}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="conditiontype">
                      pending
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                      <button class="dropdown-item" type="button" onclick="changeValuep(${index})">pending</button>
                      <button class="dropdown-item" type="button" onclick="changeValuea(${index})">approved</button>
                      <button class="dropdown-item" type="button" onclick="changeValued(${index})">declined</button>
                    </div>
                </div>
            </td>
        </tr>
             `;
        }
    }
    tableBody.innerHTML += `<button class="text-center btn btn-primary" type="submit" onclick="updateAll();">update all selected request </button>`;

}

async function showAllRequest() {

    let tableBody = document.getElementById("tableBody");
    let response = await fetch(`http://localhost:7050/requests`);
    let info = await response.json();
    tableBody.innerHTML = ``;
    for (let index = 0; index < info.length; index++) {
        let condition = "";
        const element = info[index];
        if (element.conditiontype_id == 1) {
            condition = "pending";
        } else if (element.conditiontype_id == 2) {
            condition = "approved";
        } else if (element.conditiontype_id == 3) {
            condition = "declined";
        }
        tableBody.innerHTML += `
            <tr>
                <td><p> </p></td>
                <td class="text-center col-1" style="word-wrap: break-word;">${element.account_id}</td>
                <td class="text-center col-1">${element.request_id}</td>
                <td class="text-center col-3">${element.description}</td>
                <td class="text-center col-2">${element.amount}</td>
                <td class="text-center col-3">${element.note} </td>
                <td class="text-center col-2">${condition} </td>
            </tr>
        `;
    }
}