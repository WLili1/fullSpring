package kuli.wzq.springframework.context.event;

import kuli.wzq.springframework.beans.factory.BeanFactory;
import kuli.wzq.springframework.context.ApplicationEvent;
import kuli.wzq.springframework.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
