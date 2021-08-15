package kuli.wzq.springframework.beans.factory;

import kuli.wzq.springframework.beans.BeansException;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:10
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
