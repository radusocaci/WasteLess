package com.wasteless.sd.Controller;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.mediator.Mediator;
import com.wasteless.sd.mediator.command.CreateGroceryListCommand;
import com.wasteless.sd.mediator.command.DeleteGroceryListCommand;
import com.wasteless.sd.mediator.handlers.CreateGroceryListCommandHandler;
import com.wasteless.sd.mediator.handlers.DeleteGroceryListCommandHandler;
import com.wasteless.sd.mediator.handlers.ReadGroceryListsQueryHandler;
import com.wasteless.sd.mediator.query.ReadGroceryListsQuery;
import com.wasteless.sd.mediator.response.CreateGroceryListCommandResponse;
import com.wasteless.sd.mediator.response.GenericResponse;
import com.wasteless.sd.mediator.response.ReadGroceryListsQueryResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryListController {

    private final Mediator mediator;

    public GroceryListController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/grocery-lists")
    public List<GroceryList> getAllGroceryLists(Principal principal) {
        ReadGroceryListsQuery request = new ReadGroceryListsQuery(principal.getName());
        ReadGroceryListsQueryHandler handler = (ReadGroceryListsQueryHandler)
                mediator.<ReadGroceryListsQuery, ReadGroceryListsQueryResponse>handle(request);
        ReadGroceryListsQueryResponse response = handler.handle(request);
        return response.getGroceryLists();
    }

    @DeleteMapping("/grocery-lists/{id}")
    public void deleteGroceryList(@PathVariable("id") Integer id) {
        DeleteGroceryListCommand request = new DeleteGroceryListCommand(id);
        DeleteGroceryListCommandHandler handler = (DeleteGroceryListCommandHandler)
                mediator.<DeleteGroceryListCommand, GenericResponse>handle(request);
        handler.handle(request);
    }

    @PostMapping("/grocery-lists")
    public GroceryList createGroceryList(@Valid @RequestBody GroceryList groceryList) {
        CreateGroceryListCommand request = new CreateGroceryListCommand(groceryList);
        CreateGroceryListCommandHandler handler = (CreateGroceryListCommandHandler)
                mediator.<CreateGroceryListCommand, CreateGroceryListCommandResponse>handle(request);
        CreateGroceryListCommandResponse response = handler.handle(request);
        return response.getGroceryList();
    }
}
