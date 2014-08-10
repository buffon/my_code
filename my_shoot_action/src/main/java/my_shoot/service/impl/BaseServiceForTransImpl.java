package my_shoot.service.impl;

import my_shoot.service.BaseServiceForTrans;
import my_shoot.service.dao.User;
import my_shoot.service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: chenyehui
 * @since: 14-8-10 下午11:19
 */
@Service
public class BaseServiceForTransImpl implements BaseServiceForTrans {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User findByNameForUpdate(User user) {
        userDao.findByNameForUpdate(user);
        System.out.println("start:" + System.currentTimeMillis());


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }

        System.out.println("end:" + System.currentTimeMillis());

        return null;
    }
}
