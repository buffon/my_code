package my_shoot.service.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: harry.chen
 * @since: 14-6-6 下午5:09
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitcher.getDataSource();
    }
}
