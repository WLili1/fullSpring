package kuli.wzq.springframework.context;

import kuli.wzq.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException 异常
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
