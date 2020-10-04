package com.wasteless.sd.mediator;

import com.wasteless.sd.mediator.command.*;
import com.wasteless.sd.mediator.handlers.*;
import com.wasteless.sd.mediator.query.ReadGroceryItemsQuery;
import com.wasteless.sd.mediator.query.ReadGroceryListsQuery;
import com.wasteless.sd.mediator.query.ReadReportQuery;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final Map<Class<? extends Request>, Class<? extends Handler<? extends Request, ? extends Response>>> handlerMapper;

    public Mediator() {
        this.handlerMapper = new HashMap<>();
        handlerMapper.put(ReadGroceryListsQuery.class, ReadGroceryListsQueryHandler.class);
        handlerMapper.put(CreateGroceryListCommand.class, CreateGroceryListCommandHandler.class);
        handlerMapper.put(DeleteGroceryListCommand.class, DeleteGroceryListCommandHandler.class);
        handlerMapper.put(ReadGroceryItemsQuery.class, ReadGroceryItemsQueryHandler.class);
        handlerMapper.put(CreateGroceryItemCommand.class, CreateGroceryItemCommandHandler.class);
        handlerMapper.put(DeleteGroceryItemCommand.class, DeleteGroceryItemCommandHandler.class);
        handlerMapper.put(CreateGoalCommand.class, CreateGoalCommandHandler.class);
        handlerMapper.put(ReadReportQuery.class, ReadReportQueryHandler.class);
    }

    public <T extends Request, R extends Response> Handler<T, R> handle(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMapper.get(request.getClass());
        return (Handler<T, R>) applicationContext.getBean(handlerType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
