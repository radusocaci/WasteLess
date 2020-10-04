import {Component, OnInit} from '@angular/core';
import {GroceryList} from "../grocery-list";
import {GroceryService} from "../grocery.service";
import {Goal} from "../goal";
import {GoalService} from "../goal.service";

@Component({
  selector: 'app-grocery-lists',
  templateUrl: './grocery-lists.component.html',
  styleUrls: ['./grocery-lists.component.css']
})
export class GroceryListsComponent implements OnInit {
  message: string;
  groceryLists: GroceryList[] = [];
  model: GroceryList;
  goal: Goal;

  constructor(private groceryService: GroceryService, private goalService: GoalService) {
    this.goal = {caloriesPerDay: '', username: ''} as unknown as Goal;
  }

  ngOnInit(): void {
    this.groceryService.getGroceryLists().subscribe(list => this.groceryLists = list);
    this.model = {name: '', username: sessionStorage.getItem('username')} as GroceryList
  }

  deleteGroceryList(id: number) {
    this.groceryLists = this.groceryLists.filter(l => l.id != id);
    this.groceryService.deleteGroceryList(id).subscribe();
  }

  saveGroceryList() {
    this.groceryService.createGroceryList(this.model).subscribe(list => this.groceryLists.push(list));
  }

  saveGoal() {
    this.goalService.saveGoal(this.goal).subscribe();
  }
}
