package com.wasteless.sd.mediator.command;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.mediator.Request;

public class CreateGoalCommand implements Request {

    private Goal goal;
    private String principal;

    public CreateGoalCommand(Goal goal, String principal) {
        this.goal = goal;
        this.principal = principal;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
