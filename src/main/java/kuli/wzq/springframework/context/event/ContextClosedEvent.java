package kuli.wzq.springframework.context.event;

import kuli.wzq.springframework.context.ApplicationEvent;

public class ContextClosedEvent extends ApplicationEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
