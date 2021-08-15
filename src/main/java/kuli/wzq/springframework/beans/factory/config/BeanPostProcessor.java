package kuli.wzq.springframework.beans.factory.config;

import kuli.wzq.springframework.beans.BeansException;

public interface BeanPostProcessor {

    /**
     * bean初始化前执行
     * @param bean bean实例
     * @param beanName bean名称
     * @return 返回更新后的bean
     * @throws BeansException bean异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * bean初始化后执行
     * @param bean bean实例
     * @param beanName bean名称
     * @return 返回更新后的bean
     * @throws BeansException bean异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
