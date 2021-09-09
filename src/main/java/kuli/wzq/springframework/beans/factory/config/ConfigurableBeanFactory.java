package kuli.wzq.springframework.beans.factory.config;

import kuli.wzq.springframework.beans.factory.HierarchicalBeanFactory;
import kuli.wzq.springframework.util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);
    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
