package kuli.wzq.springframework.beans.factory;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.config.AutowireCapableBeanFactory;
import kuli.wzq.springframework.beans.factory.config.BeanDefinition;
import kuli.wzq.springframework.beans.factory.config.BeanPostProcessor;
import kuli.wzq.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
