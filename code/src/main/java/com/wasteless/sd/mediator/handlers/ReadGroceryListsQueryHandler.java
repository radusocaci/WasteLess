package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.query.GroceryListQueryService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.query.ReadGroceryListsQuery;
import com.wasteless.sd.mediator.response.ReadGroceryListsQueryResponse;
import org.springframework.stereotype.Component;

@Component
public class ReadGroceryListsQueryHandler implements Handler<ReadGroceryListsQuery, ReadGroceryListsQueryResponse> {

    private final GroceryListQueryService groceryListService;

    public ReadGroceryListsQueryHandler(GroceryListQueryService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public ReadGroceryListsQueryResponse handle(ReadGroceryListsQuery request) {
        return new ReadGroceryListsQueryResponse(groceryListService.findAllByUsername(request.getPrincipal()));
    }
}
