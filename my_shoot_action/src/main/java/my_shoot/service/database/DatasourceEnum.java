package my_shoot.service.database;

/**
 * @author harry.chen
 * @since 2013-12-18 10:39 AM
 */
public enum DatasourceEnum {

    MASTER("master"),
    SLAVE("slave")
    ;

    private final String datasource;

    private DatasourceEnum(String datasource) {
        this.datasource = datasource;
    }

    public String getDatasource() {
        return datasource;
    }
}
