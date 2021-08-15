package kuli.wzq.springframework.context.event;

import kuli.wzq.springframework.context.ApplicationEvent;

public class ContextRefreshedEvent extends ApplicationEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
