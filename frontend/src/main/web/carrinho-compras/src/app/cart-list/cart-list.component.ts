import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

import { Cart } from '../model/cart';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {

  carts: Observable<Cart[]>;
    
  constructor(private cartService: CartService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
    console.log(this.carts);
  }

  reloadData() {
    this.carts = this.cartService.findAll();
  }

  deleteCart(id: number) {
    this.cartService.deleteCart(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  editCart(id: number){
    this.router.navigate(['editcart', id]);
  }

}
