package my_shoot.service.impl;

import my_shoot.service.BaseService;
import my_shoot.service.dao.UserDao;
import my_shoot.service.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:00
 */
@Service
public class ServiceImpl implements BaseService {

    @Autowired
    UserDao userDao;

    @Override
    public String base() {
        return "base";
    }

    @Override
    public List<User> listUser() {
        return userDao.list();
    }
}
