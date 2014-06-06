package my_shoot.service.database;

/**
 * @author: harry.chen
 * @since: 14-6-6 下午5:13
 */
public class DataSourceSwitcher {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    private DataSourceSwitcher() {}

    public static void setDataSource(DatasourceEnum dataSource) {
        contextHolder.set(dataSource.getDatasource());
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
