import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Item} from '../item';
import {Order} from '../order';
import { ItemService } from '../item.service';
import * as $ from 'jquery';
@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  items : Item [] = [];

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  private baseUrl = "http://localhost:8090";

  constructor(public itemService:ItemService,private httpClient:HttpClient) { }

  ngOnInit(): void {
    this.getItems();
    console.log("I'm insede onInit of item component");
  }

  getItems():void{
    this.itemService.getItems()
    .subscribe(items => this.items = items);
  }
  submit(){    
    console.log();
    var id = sessionStorage.getItem('userId');
    let total :any = 0;
    var i:any;
    var n:any;
    const note = (document.getElementsByName("note")[0] as HTMLInputElement).value;
    console.log("note is "+note);
    for(i=0;i<this.items.length;i++){
      n=(<HTMLInputElement> document.getElementById(i+1)).value;
      total =total + this.items[i].itemPrice*n;
    }
    console.log(total);
    
    this.httpClient.post<Order>(this.baseUrl + "/orders",{
      "conditiontypeId": 1,
      "orderNote": note,
      "totalPrice": total,
      "userId": id,
    }).subscribe(
      data => {
      console.log("POST Request is successful ", data);
      },
      error => {
      console.log("Error", error);
      }
      );
  }
  update(n:any):void{ 
    let subtotal:any =0;
    const v : any =(<HTMLInputElement> document.getElementById(n+1)).value;
    subtotal = this.items[n].itemPrice*v;
    $(".subtotal")[n].innerHTML=subtotal;
    this.updateAll();
  }
  updateAll(): void{
    let total :any = 0;
    var i:any;
    var n:any;
    for(i=0;i<this.items.length;i++){
      n=(<HTMLInputElement> document.getElementById(i+1)).value;
      total =total + this.items[i].itemPrice*n;
    }
    $("#totalPrice").html(total);
  }
}
