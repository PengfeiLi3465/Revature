async function login(){
  event.preventDefault();
    let username = document.getElementById("Username").value;
    let password = document.getElementById("Password").value;
    let loginstatus=0;
    sessionStorage.setItem('un',username);
    sessionStorage.setItem('pw',password);
    
    let response = await fetch(`http://localhost:7050/accounts?username=${sessionStorage.getItem("un")}`);
    
    let info = await response.json();
    localStorage.setItem("json", info);
    let data = JSON.stringify(info);
    localStorage.setItem('data', data);
    document.cookie = data;
    
    
    for(var i=0;i<info.length;i++){
      if (info[i].password == sessionStorage.getItem('pw')&&info[i].username==sessionStorage.getItem('un')) {

        localStorage.setItem('account_id',info[i].account_id);
        loginstatus=1;
        if(info[i].accounttype_id==2)window.location = `${document.URL}employees.html`;
		    else window.location = `${document.URL}managers.html`;
		  }
    }
    if(loginstatus==0)window.alert("please enter correct username and password");

}

