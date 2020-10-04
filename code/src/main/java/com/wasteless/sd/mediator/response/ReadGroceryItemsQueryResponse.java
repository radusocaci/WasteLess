package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.mediator.Response;

import java.util.List;

public class ReadGroceryItemsQueryResponse implements Response {

    private List<GroceryListItem> groceryListItems;

    public ReadGroceryItemsQueryResponse(List<GroceryListItem> groceryListItems) {
        this.groceryListItems = groceryListItems;
    }

    public List<GroceryListItem> getGroceryListItems() {
        return groceryListItems;
    }

    public void setGroceryListItems(List<GroceryListItem> groceryListItems) {
        this.groceryListItems = groceryListItems;
    }
}
