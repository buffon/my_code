package my_shoot.eye.interceptor.mybatis;

import my_shoot.eye.core.Span;
import my_shoot.eye.core.SpanContainer;
import my_shoot.eye.util.Tools;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
@Component
public class MyBatisInterceptor implements Interceptor, ApplicationContextAware {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Span.enter(invocation.getMethod());
        Object object = invocation.proceed();
        Span.over();
        return object;
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SqlSessionFactoryBean bean = applicationContext.getBean(SqlSessionFactoryBean.class);
        bean.setPlugins(new Interceptor[]{new MyBatisInterceptor()});
    }
}
