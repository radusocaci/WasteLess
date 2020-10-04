package com.wasteless.sd.mediator.command;

import com.wasteless.sd.mediator.Request;

public class DeleteGroceryListCommand implements Request {

    private int id;

    public DeleteGroceryListCommand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
