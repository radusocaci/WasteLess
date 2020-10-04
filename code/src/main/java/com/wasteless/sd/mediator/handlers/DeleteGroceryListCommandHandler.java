package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.command.GroceryListCommandService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.DeleteGroceryListCommand;
import com.wasteless.sd.mediator.response.GenericResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteGroceryListCommandHandler implements Handler<DeleteGroceryListCommand, GenericResponse> {

    private final GroceryListCommandService groceryListService;

    public DeleteGroceryListCommandHandler(GroceryListCommandService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public GenericResponse handle(DeleteGroceryListCommand request) {
        groceryListService.deleteGroceryList(request.getId());
        return new GenericResponse();
    }
}
