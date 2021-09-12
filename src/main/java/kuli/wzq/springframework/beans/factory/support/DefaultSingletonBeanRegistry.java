package kuli.wzq.springframework.beans.factory.support;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.ObjectFactory;
import kuli.wzq.springframework.beans.factory.DisposableBean;
import kuli.wzq.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:31
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    //一级缓存，普通对象
    private Map<String, Object> singletonObjects = new HashMap<>();

    //二级缓存，提前暴露对象，未完全实例化
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

    //三级缓存，存放代理对象
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);

            //判断二级缓存是否有这个对象，如果没有就是代理对象，代理对象放三级缓存
            if (null == singletonObject) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);

                if (null != singletonFactory) {
                    singletonObject = singletonFactory.getObject();
                    //获取到到真实代理对象放入二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }
}
