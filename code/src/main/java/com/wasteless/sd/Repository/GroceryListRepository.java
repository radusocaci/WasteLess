package com.wasteless.sd.Repository;

import com.wasteless.sd.Model.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryListRepository extends CrudRepository<GroceryList, Integer> {
    public List<GroceryList> findAllByUsername(String userId);
}
