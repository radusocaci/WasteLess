package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.query.GroceryItemQueryService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.query.ReadGroceryItemsQuery;
import com.wasteless.sd.mediator.response.ReadGroceryItemsQueryResponse;
import org.springframework.stereotype.Component;

@Component
public class ReadGroceryItemsQueryHandler implements Handler<ReadGroceryItemsQuery, ReadGroceryItemsQueryResponse> {

    private final GroceryItemQueryService groceryItemService;

    public ReadGroceryItemsQueryHandler(GroceryItemQueryService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @Override
    public ReadGroceryItemsQueryResponse handle(ReadGroceryItemsQuery request) {
        return new ReadGroceryItemsQueryResponse(groceryItemService.findByListId(request.getListId()));
    }
}
