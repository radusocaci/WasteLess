package com.wasteless.sd.mediator.command;

import com.wasteless.sd.mediator.Request;

public class DeleteGroceryItemCommand implements Request {

    private int id;
    private String principal;

    public DeleteGroceryItemCommand(int id, String principal) {
        this.id = id;
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
