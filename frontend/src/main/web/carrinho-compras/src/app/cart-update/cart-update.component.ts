import {
    Component,
    OnInit
}
from '@angular/core';
import {
    ActivatedRoute,
    Router
}
from '@angular/router';
import {
    Observable
}
from "rxjs";

import {
    Item
}
from '../model/item';
import {
    ItemService
}
from '../service/item.service';

import {
    Cart
}
from '../model/cart';
import {
    CartService
}
from '../service/cart.service';

 @ Component({
    selector: 'app-cart-update',
    templateUrl: './cart-update.component.html',
    styleUrls: ['./cart-update.component.css']
})
export class CartUpdateComponent implements OnInit {

    id: string;
    cart: Cart;

    items: Item[];
    selectedItems: Array < string > ;

    constructor(private route: ActivatedRoute, private router: Router,
        private cartService: CartService, private itemService: ItemService) {
        this.selectedItems = new Array < string > ();
        this.itemService.findAll()
        .subscribe(
            data => {
            console.log(data);
            this.items = data;
        }, error => console.log(error));
    }

    ngOnInit() {
        this.id = this.route.snapshot.params['id'];
        this.cart = new Cart();        
        
        this.cartService.getCart(this.id)
        .subscribe(data => {
            for (let item of data['items']) {
                this.selectedItems.push(item.id);
            }
            console.log(this.selectedItems);
            this.cart = data;
        }, error => console.log(error));
    }

    itemsChanged() {
        this.cart._items = [];
        for (let selectedItem of this.selectedItems) {
            this.itemService.getItem(selectedItem)
            .subscribe(data => {
                this.cart.addItem(data);
            }, error => console.log(error));
        }
    }

    updateCart() {
        this.cartService.updateCart(this.id, this.cart)
        .subscribe(data => console.log(data), error => console.log(error));
        this.cart = new Cart();
        this.gotoList();
    }

    onSubmit() {
        this.updateCart();
    }

    gotoList() {
        this.router.navigate(['/carts']);
    }
}
