package my_shoot.service.database;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author harry.chen
 */
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
public @interface Datasource {
    DatasourceEnum dataSource() default DatasourceEnum.MASTER;
}
