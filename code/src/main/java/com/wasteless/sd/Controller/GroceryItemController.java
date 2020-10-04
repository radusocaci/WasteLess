package com.wasteless.sd.Controller;

import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.mediator.Mediator;
import com.wasteless.sd.mediator.command.CreateGroceryItemCommand;
import com.wasteless.sd.mediator.command.DeleteGroceryItemCommand;
import com.wasteless.sd.mediator.handlers.CreateGroceryItemCommandHandler;
import com.wasteless.sd.mediator.handlers.DeleteGroceryItemCommandHandler;
import com.wasteless.sd.mediator.handlers.ReadGroceryItemsQueryHandler;
import com.wasteless.sd.mediator.query.ReadGroceryItemsQuery;
import com.wasteless.sd.mediator.response.CreateGroceryItemCommandResponse;
import com.wasteless.sd.mediator.response.GenericResponse;
import com.wasteless.sd.mediator.response.ReadGroceryItemsQueryResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryItemController {

    private final Mediator mediator;

    public GroceryItemController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/grocery-items/{listId}")
    public List<GroceryListItem> getAllItemsByListId(@PathVariable Integer listId) {
        ReadGroceryItemsQuery request = new ReadGroceryItemsQuery(listId);
        ReadGroceryItemsQueryHandler handler = (ReadGroceryItemsQueryHandler)
                mediator.<ReadGroceryItemsQuery, ReadGroceryItemsQueryResponse>handle(request);
        ReadGroceryItemsQueryResponse response = handler.handle(request);
        return response.getGroceryListItems();
    }

    @PostMapping(path = "/grocery-items/{listId}")
    public GroceryListItem createGroceryList(@Valid @RequestBody GroceryListItem groceryItem,
                                             @PathVariable(value = "listId") Integer listId,
                                             Principal principal) {
        CreateGroceryItemCommand request = new CreateGroceryItemCommand(groceryItem, listId, principal.getName());
        CreateGroceryItemCommandHandler handler = (CreateGroceryItemCommandHandler)
                mediator.<CreateGroceryItemCommand, CreateGroceryItemCommandResponse>handle(request);
        CreateGroceryItemCommandResponse response = handler.handle(request);
        return response.getGroceryListItem();
    }

    @DeleteMapping("/grocery-items/{id}")
    public void deleteGroceryList(@PathVariable("id") Integer id, Principal principal) {
        DeleteGroceryItemCommand request = new DeleteGroceryItemCommand(id, principal.getName());
        DeleteGroceryItemCommandHandler handler = (DeleteGroceryItemCommandHandler)
                mediator.<DeleteGroceryItemCommand, GenericResponse>handle(request);
        handler.handle(request);
    }
}
