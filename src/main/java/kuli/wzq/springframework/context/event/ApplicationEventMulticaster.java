package kuli.wzq.springframework.context.event;


import kuli.wzq.springframework.context.ApplicationEvent;
import kuli.wzq.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
