package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.command.GroceryListCommandService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.CreateGroceryListCommand;
import com.wasteless.sd.mediator.response.CreateGroceryListCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateGroceryListCommandHandler implements Handler<CreateGroceryListCommand, CreateGroceryListCommandResponse> {

    private final GroceryListCommandService groceryListService;

    public CreateGroceryListCommandHandler(GroceryListCommandService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public CreateGroceryListCommandResponse handle(CreateGroceryListCommand request) {
        return new CreateGroceryListCommandResponse(groceryListService.save(request.getGroceryList()));
    }
}
