package my_shoot.eye.interceptor.spring;

import my_shoot.eye.core.Span;
import my_shoot.eye.core.SpanContainer;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Span.over();
    }

}
