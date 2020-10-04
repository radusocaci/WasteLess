package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.mediator.Response;

public class CreateGroceryItemCommandResponse implements Response {

    private GroceryListItem groceryListItem;

    public CreateGroceryItemCommandResponse(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }

    public GroceryListItem getGroceryListItem() {
        return groceryListItem;
    }

    public void setGroceryListItem(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }
}
