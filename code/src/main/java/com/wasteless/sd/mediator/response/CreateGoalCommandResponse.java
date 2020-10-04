package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.mediator.Response;

public class CreateGoalCommandResponse implements Response {

    private Goal goal;

    public CreateGoalCommandResponse(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
