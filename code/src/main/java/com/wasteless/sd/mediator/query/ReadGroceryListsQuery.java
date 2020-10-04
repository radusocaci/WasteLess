package com.wasteless.sd.mediator.query;

import com.wasteless.sd.mediator.Request;

public class ReadGroceryListsQuery implements Request {

    private String principal;

    public ReadGroceryListsQuery(String principal) {
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
