package kuli.wzq.springframework.context.event;

import kuli.wzq.springframework.context.ApplicationContext;
import kuli.wzq.springframework.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
