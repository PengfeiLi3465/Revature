import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemComponent } from './item/item.component';
import { LoginComponent } from './login/login.component';
import { OrderComponent } from './order/order.component';
const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"items",component:ItemComponent},
  {path:"login",component:LoginComponent},
  {path:"order",component:OrderComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
