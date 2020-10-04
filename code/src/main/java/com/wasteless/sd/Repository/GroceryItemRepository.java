package com.wasteless.sd.Repository;

import com.wasteless.sd.Model.GroceryListItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends CrudRepository<GroceryListItem, Integer> {
    List<GroceryListItem> findByGroceryListId(Integer id);
}