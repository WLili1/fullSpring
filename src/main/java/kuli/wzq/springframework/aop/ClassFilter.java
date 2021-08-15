package kuli.wzq.springframework.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
