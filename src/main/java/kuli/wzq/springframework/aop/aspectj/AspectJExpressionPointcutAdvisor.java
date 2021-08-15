package kuli.wzq.springframework.aop.aspectj;

import kuli.wzq.springframework.aop.Pointcut;
import kuli.wzq.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    //切面
    private AspectJExpressionPointcut pointcut;

    //具体拦截方法
    private Advice advice;

    //表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
