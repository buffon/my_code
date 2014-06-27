package my_shoot.eye.interceptor.mybatis;

import my_shoot.eye.core.Span;
import my_shoot.eye.core.SpanContainer;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class MyBatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Span span = SpanContainer.getSpan();
        if (span != null) {
            span.getUrls().add("Dao come: " + System.currentTimeMillis());
            SpanContainer.setSpan(span);
        }
        Object object = invocation.proceed();

        span.getUrls().add("Dao go: " + System.currentTimeMillis());
        SpanContainer.setSpan(span);

        return object;
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
