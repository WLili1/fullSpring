package kuli.wzq.springframework.beans.factory.config;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:30
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
