package kuli.wzq.springframework.beans.factory;

import kuli.wzq.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
