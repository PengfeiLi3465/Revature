import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 email:string = '';
 password:string='';
 invalidLogin = false;
 user!:User;

 constructor(private router:Router, private loginService:LoginService){}



  ngOnInit(): void {
  }

  checkLogin(){
    this.getUserByEmail(this.email);
  }
  getUserByEmail(email:string):void{
    console.log(this.email);
    console.log(this.password);
    this.loginService.getUser(email)
    .subscribe(user=>{
      this.user = user;
      console.log("this.user in arrow function :" + this.user.userPassword);
      if (this.user.userEmail === this.email && this.user.userPassword === this.password) {
        if(this.user.usertypeId==1){
          this.router.navigate(['items'])
          this.invalidLogin = false;
          sessionStorage.setItem('userId',this.user.userId.toString());
        }else if(this.user.usertypeId==2){
          this.router.navigate(['order'])
          this.invalidLogin = false;
        }
      } else{
        window.alert("please check your password");
        this.invalidLogin = true;
      }
        

    });
    
  }

}
