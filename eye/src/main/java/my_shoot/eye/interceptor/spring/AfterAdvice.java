package my_shoot.eye.interceptor.spring;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import my_shoot.eye_base.core.Span;

public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Span.over();
    }

}
