import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user-service.service';
import { UserUpdateComponent } from './user-update/user-update.component';
import { ItemUpdateComponent } from './item-update/item-update.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { CartUpdateComponent } from './cart-update/cart-update.component';
import { CartFormComponent } from './cart-form/cart-form.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { HomeComponent } from './home/home.component';
 
@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    UserUpdateComponent,
    ItemUpdateComponent,
    ItemListComponent,
    ItemFormComponent,
    CartListComponent,
    CartUpdateComponent,
    CartFormComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgSelectModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }