package my_shoot.service;


import my_shoot.service.dao.User;

import java.util.List;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:00
 */
public interface BaseService {

    public String base();


    public List<User> listUser();
}
