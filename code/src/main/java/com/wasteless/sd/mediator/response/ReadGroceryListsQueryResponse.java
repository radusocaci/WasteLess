package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.mediator.Response;

import java.util.List;

public class ReadGroceryListsQueryResponse implements Response {

    private List<GroceryList> groceryLists;

    public ReadGroceryListsQueryResponse(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }

    public List<GroceryList> getGroceryLists() {
        return groceryLists;
    }

    public void setGroceryLists(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }
}
