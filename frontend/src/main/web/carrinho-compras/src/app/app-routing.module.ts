import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemUpdateComponent } from './item-update/item-update.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { CartFormComponent } from './cart-form/cart-form.component';
import { CartUpdateComponent } from './cart-update/cart-update.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'edituser/:id', component: UserUpdateComponent },
  { path: 'items', component: ItemListComponent },
  { path: 'additem', component: ItemFormComponent },
  { path: 'edititem/:id', component: ItemUpdateComponent },
  { path: 'carts', component: CartListComponent },
  { path: 'addcart', component: CartFormComponent },
  { path: 'editcart/:id', component: CartUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }