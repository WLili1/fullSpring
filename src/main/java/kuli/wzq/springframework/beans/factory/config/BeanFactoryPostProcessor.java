package kuli.wzq.springframework.beans.factory.config;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefinition加载完成后，实例化Bean之前，提供修改BeanDefinition属性的机制
     * @param beanFactory bean工厂
     * @throws BeansException bean异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
