package kuli.wzq.springframework.aop;

public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
