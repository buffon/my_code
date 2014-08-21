package my_shoot.eye.interceptor.spring;

import my_shoot.eye.core.Span;
import my_shoot.eye.core.SpanContainer;
import my_shoot.eye.util.Tools;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Span.enter(method);
    }

}
