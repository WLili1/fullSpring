package kuli.wzq.test;

import kuli.wzq.springframework.aop.AdvisedSupport;
import kuli.wzq.springframework.aop.MethodMatcher;
import kuli.wzq.springframework.aop.TargetSource;
import kuli.wzq.springframework.aop.aspectj.AspectJExpressionPointcut;
import kuli.wzq.springframework.aop.framework.Cglib2AopProxy;
import kuli.wzq.springframework.aop.framework.JdkDynamicAopProxy;
import kuli.wzq.springframework.beans.PropertyValue;
import kuli.wzq.springframework.beans.PropertyValues;
import kuli.wzq.springframework.beans.factory.config.BeanDefinition;
import kuli.wzq.springframework.beans.factory.BeanFactory;
import kuli.wzq.springframework.beans.factory.config.BeanReference;
import kuli.wzq.springframework.beans.factory.support.DefaultListableBeanFactory;
import kuli.wzq.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import kuli.wzq.springframework.context.support.ClassPathXmlApplicationContext;
import kuli.wzq.springframework.core.io.DefaultResourceLoader;
import kuli.wzq.test.bean.IUserService;
import kuli.wzq.test.bean.UserDao;
import kuli.wzq.test.bean.UserService;
import kuli.wzq.test.bean.UserServiceInterceptor;
import kuli.wzq.test.event.CustomEvent;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:14
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2 注册bean
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);


        //3 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService01);
        System.out.println(userService02);
        System.out.println(userService01.queryUserInfo());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了!"));
        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* kuli.wzq.test.bean.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果:" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果:" + proxy_cglib.register("苦"));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果:" + userService.queryUserInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
