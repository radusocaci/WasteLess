package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.command.GroceryItemCommandService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.DeleteGroceryItemCommand;
import com.wasteless.sd.mediator.response.GenericResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteGroceryItemCommandHandler implements Handler<DeleteGroceryItemCommand, GenericResponse> {

    private final GroceryItemCommandService groceryItemService;

    public DeleteGroceryItemCommandHandler(GroceryItemCommandService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @Override
    public GenericResponse handle(DeleteGroceryItemCommand request) {
        groceryItemService.deleteGroceryItem(request.getId(), request.getPrincipal());
        return new GenericResponse();
    }
}
