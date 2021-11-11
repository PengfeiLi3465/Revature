import { Component, OnInit } from '@angular/core';
import { Order } from'../order';
import { OrderService } from '../order.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Item} from '../item';
import { ItemService } from '../item.service';
import * as $ from 'jquery';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  private baseUrl = "http://localhost:8090";

  orders : Order [] = []
  constructor(public orderService:OrderService,public itemService:ItemService,private httpClient:HttpClient) { }

  ngOnInit(): void {
    this.getOrders();
    console.log("I'm insede onInit of order component");
  
  }

  getOrders():void{
    this.orderService.getOrders()
    .subscribe(orders => this.orders = orders);
  }
  check(i:number){
    console.log('check');
    console.log();

    var orderId = document.getElementsByName("orderId")[i].innerHTML;
    var userId = document.getElementsByName("userId")[i].innerHTML;
    var totalPrice = document.getElementsByName("totalPrice")[i].innerHTML;
    var orderNote = document.getElementsByName("orderNote")[i].innerHTML;

    console.log("here");    
    this.httpClient.put<Order>(this.baseUrl + "/orders/"+orderId,{
      "conditiontypeId": 2,
      "orderId": orderId,
      "orderNote": orderNote,
      "totalPrice": totalPrice,
      "userId": userId
    }).subscribe(
      data => {
      console.log("Put Request is successful ", data);
      },
      error => {
      console.log("Error", error);
      }
      );
  }
}
