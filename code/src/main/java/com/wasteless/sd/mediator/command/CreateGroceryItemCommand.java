package com.wasteless.sd.mediator.command;

import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.mediator.Request;

public class CreateGroceryItemCommand implements Request {

    private GroceryListItem groceryListItem;
    private int listId;
    private String principal;

    public CreateGroceryItemCommand(GroceryListItem groceryListItem, int listId, String principal) {
        this.groceryListItem = groceryListItem;
        this.listId = listId;
        this.principal = principal;
    }

    public GroceryListItem getGroceryListItem() {
        return groceryListItem;
    }

    public void setGroceryListItem(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
