package com.wasteless.sd.Service.command;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.Repository.GoalRepository;
import org.springframework.stereotype.Service;

@Service
public class GoalCommandService {
    private final GoalRepository goalRepository;

    public GoalCommandService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal getGoalByUsername(String username) {
        return goalRepository.findFirstByUsername(username).orElseGet(Goal::new);
    }

    public Goal save(Goal goal, String name) {
        goalRepository.findFirstByUsername(name).ifPresent(g -> goal.setId(g.getId()));
        goal.setUsername(name);
        return goalRepository.save(goal);
    }
}
