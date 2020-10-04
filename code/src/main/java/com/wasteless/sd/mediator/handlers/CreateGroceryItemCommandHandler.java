package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.command.GroceryItemCommandService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.CreateGroceryItemCommand;
import com.wasteless.sd.mediator.response.CreateGroceryItemCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateGroceryItemCommandHandler implements Handler<CreateGroceryItemCommand, CreateGroceryItemCommandResponse> {

    private final GroceryItemCommandService groceryItemService;

    public CreateGroceryItemCommandHandler(GroceryItemCommandService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @Override
    public CreateGroceryItemCommandResponse handle(CreateGroceryItemCommand request) {
        return new CreateGroceryItemCommandResponse(groceryItemService.save(
                request.getGroceryListItem(),
                request.getListId(), request.getPrincipal()
        ));
    }
}
