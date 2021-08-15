package kuli.wzq.springframework.context;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
