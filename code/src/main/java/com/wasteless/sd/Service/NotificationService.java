package com.wasteless.sd.Service;

import com.wasteless.sd.Model.NotificationEvent;
import com.wasteless.sd.Model.STOMPMessage;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements ApplicationListener<NotificationEvent> {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public NotificationService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void onApplicationEvent(NotificationEvent event) {
        STOMPMessage message = new STOMPMessage(event.getMessage());
        simpMessagingTemplate.convertAndSend("/notification/message", message);
    }
}
