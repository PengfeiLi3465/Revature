import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  user: User | undefined ;
  private baseUrl = "http://localhost:8090";
  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    console.log("I'm insede onInit of login component");
  
  }
  private log(message: string) {
    console.log(`UserService: ${message}`);
  }

  login(event:any):Observable<User>{
    event.preventDefault();
    console.log("login test");
    let userEmail =(<HTMLInputElement>  document.getElementById("Username")).value;
    let userPassword = (<HTMLInputElement> document.getElementById("Password")).value;
    // const params = {
    //   "userEmail":userEmail,
    //   "userPassword":userPassword
    // }
    // console.log(params);
    return this.httpClient.get<User>(this.baseUrl + "/usersbyemail/"+userEmail+"/"+userPassword);
    // console.log(this.baseUrl + "/usersbyemail/"+userEmail+"/"+userPassword);
    // console.log(this.httpClient.get(this.baseUrl + "/usersbyemail/"+userEmail+"/"+userPassword));

  }

}
