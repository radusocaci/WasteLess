package com.wasteless.sd.mediator.query;

import com.wasteless.sd.mediator.Request;

public class ReadGroceryItemsQuery implements Request {

    private int listId;

    public ReadGroceryItemsQuery(Integer listId) {
        this.listId = listId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
