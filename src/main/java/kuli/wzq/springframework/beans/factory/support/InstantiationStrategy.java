package kuli.wzq.springframework.beans.factory.support;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
