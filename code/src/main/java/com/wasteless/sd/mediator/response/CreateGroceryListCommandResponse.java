package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.mediator.Response;

public class CreateGroceryListCommandResponse implements Response {

    private GroceryList groceryList;

    public CreateGroceryListCommandResponse(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
