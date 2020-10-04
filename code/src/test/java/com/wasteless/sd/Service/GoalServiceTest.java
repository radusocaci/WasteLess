package com.wasteless.sd.Service;

import com.wasteless.sd.Model.Goal;
import com.wasteless.sd.Repository.GoalRepository;
import com.wasteless.sd.Service.command.GoalCommandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GoalServiceTest {
    @Mock
    GoalRepository goalRepository;

    @InjectMocks
    GoalCommandService goalService;

    @Test
    public void when_get_user_by_username_should_return_user() {
        Goal goal = new Goal();
        goal.setUsername("test");
        when(goalRepository.findFirstByUsername("test")).thenReturn(of(goal));
        assertThat(goalService.getGoalByUsername("test").getUsername()).isSameAs(goal.getUsername());
    }

    @Test
    public void save() {
        Goal goal = new Goal();
        goal.setUsername("test");
        when(goalRepository.save(any(Goal.class))).thenReturn(goal);
        assertThat(goalService.save(goal, "test").getUsername()).isSameAs("test");
    }
}