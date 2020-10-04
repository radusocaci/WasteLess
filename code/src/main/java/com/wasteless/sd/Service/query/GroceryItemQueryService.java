package com.wasteless.sd.Service.query;

import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.Repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemQueryService {

    private final GroceryItemRepository groceryItemRepository;

    public GroceryItemQueryService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public List<GroceryListItem> findByListId(Integer listId) {
        return groceryItemRepository.findByGroceryListId(listId);
    }

    public GroceryListItem findById(Integer id) {
        return groceryItemRepository.findById(id).get();
    }
}
