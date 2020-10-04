package com.wasteless.sd.Repository;

import com.wasteless.sd.Model.Goal;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GoalRepository extends CrudRepository<Goal, Integer> {
    Optional<Goal> findFirstByUsername(String username);
}
