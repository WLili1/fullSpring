package kuli.wzq.test.bean;

import kuli.wzq.springframework.beans.BeansException;
import kuli.wzq.springframework.beans.factory.*;
import kuli.wzq.springframework.beans.factory.annotation.Autowired;
import kuli.wzq.springframework.beans.factory.annotation.Value;
import kuli.wzq.springframework.context.ApplicationContext;
import kuli.wzq.springframework.context.ApplicationContextAware;
import kuli.wzq.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:14
 */
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "苦李，100001，杭州，" + token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
