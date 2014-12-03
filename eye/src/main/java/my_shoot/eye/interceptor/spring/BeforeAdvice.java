package my_shoot.eye.interceptor.spring;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

import my_shoot.eye_base.core.Span;

public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Span.enter(method);
    }

}
