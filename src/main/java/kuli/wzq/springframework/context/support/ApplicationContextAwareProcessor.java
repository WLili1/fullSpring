package kuli.wzq.springframework.context.support;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.config.BeanPostProcessor;
import kuli.wzq.springframework.context.ApplicationContext;
import kuli.wzq.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
