import { Component, OnInit } from '@angular/core';
import { Order } from'../order';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders : Order [] = []
  constructor(public orderService:OrderService) { }

  ngOnInit(): void {
    this.getOrders();
    console.log("I'm insede onInit of order component");
  
  }

  getOrders():void{
    this.orderService.getOrders()
    .subscribe(orders => this.orders = orders);
  }
}
