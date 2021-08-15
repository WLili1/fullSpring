package kuli.wzq.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行:init-method");
        hashMap.put("10001", "苦李");
        hashMap.put("10002", "苦李1");
        hashMap.put("10003", "苦李2");
    }

    public void destroyDataMethod() {
        System.out.println("执行:destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
