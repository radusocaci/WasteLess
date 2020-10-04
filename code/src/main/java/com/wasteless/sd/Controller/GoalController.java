package com.wasteless.sd.Controller;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.mediator.Mediator;
import com.wasteless.sd.mediator.command.CreateGoalCommand;
import com.wasteless.sd.mediator.handlers.CreateGoalCommandHandler;
import com.wasteless.sd.mediator.response.CreateGoalCommandResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin("*")
public class GoalController {

    private final Mediator mediator;

    public GoalController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/goal")
    public Goal createGoal(@Valid @RequestBody Goal goal, Principal principal) {
        CreateGoalCommand request = new CreateGoalCommand(goal, principal.getName());
        CreateGoalCommandHandler handler = (CreateGoalCommandHandler)
                mediator.<CreateGoalCommand, CreateGoalCommandResponse>handle(request);
        CreateGoalCommandResponse response = handler.handle(request);
        return response.getGoal();
    }
}
