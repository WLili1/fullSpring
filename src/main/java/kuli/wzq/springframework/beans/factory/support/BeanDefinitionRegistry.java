package kuli.wzq.springframework.beans.factory.support;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.config.BeanDefinition;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:55
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
