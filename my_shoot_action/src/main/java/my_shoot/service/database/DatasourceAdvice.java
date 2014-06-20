package my_shoot.service.database;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: harry.chen
 * @since: 14-6-6 下午5:20
 */
public class DatasourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        DatasourceEnum datasourceEnum = DatasourceEnum.SLAVE;
        Datasource datasource = method.getDeclaringClass().getAnnotation(Datasource.class);

        if(datasource != null){
            datasourceEnum = datasource.dataSource();
        }

        Datasource methodAnnotation = method.getAnnotation(Datasource.class);
        if (methodAnnotation != null) {
            datasourceEnum = methodAnnotation.dataSource();
        }
        DataSourceSwitcher.setDataSource(datasourceEnum);
    }
}
