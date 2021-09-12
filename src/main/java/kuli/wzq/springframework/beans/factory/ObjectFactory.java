package kuli.wzq.springframework.beans.factory;

import kuli.wzq.springframework.beans.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
