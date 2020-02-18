import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";

import { CartService } from '../service/cart.service';
import { Cart } from '../model/cart';

import { Item } from '../model/item';
import { ItemService } from '../service/item.service';

import { User } from '../model/user';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-cart-form',
  templateUrl: './cart-form.component.html',
  styleUrls: ['./cart-form.component.css']
})
export class CartFormComponent implements OnInit {

  cart: Cart;
  selectedUser: any;
  selectedItems : any;
  items: Observable<Item[]>;
  users: Observable<User[]>;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private cartService: CartService,
        private itemService: ItemService,
        private userService: UserService) {
    this.cart = new Cart();
  }
  
  userChanged() {
    this.userService.getUser(this.selectedUser)
            .subscribe(data => {
                this.cart._user = data;
            }, error => console.log(error));
  }

  itemsChanged() {
      this.cart._items=[];
    for (let selectedItem of this.selectedItems) {
        this.itemService.getItem(selectedItem)
            .subscribe(data => {
                this.cart.addItem(data);
            }, error => console.log(error));
    }
  }
  
  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.findAll();
    this.items = this.itemService.findAll();
  }
  
  onSubmit() {
    this.cartService.save(this.cart).subscribe(result => this.gotoCartList());
  }

  gotoCartList() {
    this.router.navigate(['/carts']);
  }

}
