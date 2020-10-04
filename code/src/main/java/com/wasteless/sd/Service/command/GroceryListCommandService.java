package com.wasteless.sd.Service.command;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.Repository.GroceryListRepository;
import org.springframework.stereotype.Service;

@Service
public class GroceryListCommandService {

    private final GroceryListRepository groceryListRepository;

    public GroceryListCommandService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public GroceryList save(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public void deleteGroceryList(Integer id) {
        groceryListRepository.deleteById(id);
    }
}
