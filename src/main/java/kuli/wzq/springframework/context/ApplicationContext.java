package kuli.wzq.springframework.context;

import kuli.wzq.springframework.beans.factory.HierarchicalBeanFactory;
import kuli.wzq.springframework.beans.factory.ListableBeanFactory;
import kuli.wzq.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}
