package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.Service.command.GoalCommandService;
import com.wasteless.sd.Service.command.GroceryItemCommandService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.CreateGoalCommand;
import com.wasteless.sd.mediator.response.CreateGoalCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateGoalCommandHandler implements Handler<CreateGoalCommand, CreateGoalCommandResponse> {

    private final GoalCommandService goalService;
    private final GroceryItemCommandService groceryItemService;

    public CreateGoalCommandHandler(GoalCommandService goalService, GroceryItemCommandService groceryItemService) {
        this.goalService = goalService;
        this.groceryItemService = groceryItemService;
    }

    @Override
    public CreateGoalCommandResponse handle(CreateGoalCommand request) {
        Goal goal = goalService.save(request.getGoal(), request.getPrincipal());
        groceryItemService.checkWaste(request.getPrincipal());
        return new CreateGoalCommandResponse(goal);
    }
}
