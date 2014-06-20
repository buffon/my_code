package my_shoot.service;


import my_shoot.service.dao.User;
import my_shoot.service.database.Datasource;
import my_shoot.service.database.DatasourceEnum;

import java.util.List;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:00
 */
@Datasource(dataSource = DatasourceEnum.MASTER)
public interface BaseService {

    public String base();

    public List<User> listUser();
}
