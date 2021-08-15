package kuli.wzq.springframework.context;

public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
