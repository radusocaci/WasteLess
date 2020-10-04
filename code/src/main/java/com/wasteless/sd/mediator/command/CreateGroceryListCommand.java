package com.wasteless.sd.mediator.command;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.mediator.Request;

public class CreateGroceryListCommand implements Request {

    private GroceryList groceryList;

    public CreateGroceryListCommand(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
