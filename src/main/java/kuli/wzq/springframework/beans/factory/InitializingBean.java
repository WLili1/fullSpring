package kuli.wzq.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
