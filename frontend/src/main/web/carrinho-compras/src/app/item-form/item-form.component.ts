import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../service/item.service';
import { Item } from '../model/item';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent {

  item: Item;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private itemService: ItemService) {
    this.item = new Item();
  }

  onSubmit() {
       console.log(this.item);
    this.itemService.save(this.item).subscribe(result => this.gotoItemsList());
  }

  gotoItemsList() {
    this.router.navigate(['/items']);
  }

}
