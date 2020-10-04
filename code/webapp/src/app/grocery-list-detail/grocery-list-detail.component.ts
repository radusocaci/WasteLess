import {Component, OnInit} from '@angular/core';
import {GroceryItem} from "../grocery-item";
import {GroceryItemService} from "../grocery-item.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-grocery-list-detail',
  templateUrl: './grocery-list-detail.component.html',
  styleUrls: ['./grocery-list-detail.component.css']
})
export class GroceryListDetailComponent implements OnInit {
  groceryItems: GroceryItem[] = [];
  model: GroceryItem;
  id: number;

  constructor(private groceryItemService: GroceryItemService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.groceryItemService.getGroceryListItems(this.id).subscribe(list => this.groceryItems = list);
    this.model = {
      name: '',
      quantity: '',
      calorieValue: '',
      consumptionDate: '',
      purchaseDate: '',
      expirationDate: ''
    } as unknown as GroceryItem;
  }

  deleteGroceryItem(id: number): void {
    this.groceryItems = this.groceryItems.filter(item => item.id !== id);
    this.groceryItemService.deleteGroceryItem(id).subscribe();
  }

  saveGroceryItem() {
    this.groceryItemService.createGroceryItem(this.model, this.id).subscribe(item => {
      if (this.groceryItems.find(itemTemp => itemTemp.name === item.name)) {
        this.groceryItems = this.groceryItems.filter(i => i.name !== item.name);
      }
      this.groceryItems.push(item);
    })
  }
}
