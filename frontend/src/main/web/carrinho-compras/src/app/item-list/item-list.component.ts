import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

import { Item } from '../model/item';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Observable<Item[]>;

  constructor(private itemService: ItemService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.items = this.itemService.findAll();
  }

  deleteItem(id: string) {
    this.itemService.deleteItem(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  editItem(id: string){
    this.router.navigate(['edititem', id]);
  }
}
