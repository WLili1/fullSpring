package kuli.wzq.test;

import kuli.wzq.springframework.context.support.ClassPathXmlApplicationContext;
import kuli.wzq.test.bean.Husband;
import kuli.wzq.test.bean.Wife;
import org.junit.Test;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:14
 */
public class ApiTest {


    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公:" + wife.queryHusband());
    }
}
