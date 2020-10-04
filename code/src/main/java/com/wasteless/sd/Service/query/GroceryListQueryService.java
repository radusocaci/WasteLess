package com.wasteless.sd.Service.query;

import com.wasteless.sd.Model.GroceryList;
import com.wasteless.sd.Repository.GroceryListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryListQueryService {

    private final GroceryListRepository groceryListRepository;

    public GroceryListQueryService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public List<GroceryList> findAllByUsername(String userId) {
        return groceryListRepository.findAllByUsername(userId);
    }

    public Optional<GroceryList> findById(Integer listId) {
        return groceryListRepository.findById(listId);
    }

    public List<GroceryList> findAll() {
        return (List<GroceryList>) groceryListRepository.findAll();
    }
}
