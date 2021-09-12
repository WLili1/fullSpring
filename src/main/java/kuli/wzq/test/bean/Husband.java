package kuli.wzq.test.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class Husband {

    private Wife wife;

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public String queryWife(){
        return "Husband.wife";
    }
}
