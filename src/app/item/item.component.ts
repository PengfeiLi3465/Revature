import { Component, OnInit } from '@angular/core';
import {Item} from '../item';
import { ItemService } from '../item.service';
import * as $ from 'jquery';
@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  items : Item [] = [];

  constructor(public itemService:ItemService) { }

  ngOnInit(): void {
    this.getItems();
    console.log("I'm insede onInit of item component");
  }

  getItems():void{
    this.itemService.getItems()
    .subscribe(items => this.items = items);
  }
  submit(){
    // const q :any = (<HTMLInputElement> document.getElementById('3')).value; 
    // console.log(this.items[2].itemPrice*q);
    //submit all func
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
