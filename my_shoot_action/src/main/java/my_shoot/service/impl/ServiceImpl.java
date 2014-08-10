package my_shoot.service.impl;

import my_shoot.service.BaseService;
import my_shoot.service.BaseServiceForTrans;
import my_shoot.service.dao.UserDao;
import my_shoot.service.dao.User;
import my_shoot.service.database.Datasource;
import my_shoot.service.database.DatasourceEnum;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:00
 */
@Service
public class ServiceImpl implements BaseService {

    @Autowired
    UserDao userDao;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactory;

    @Autowired
    BaseServiceForTrans baseServiceForTrans;

    @Override
    public String base() {
        return "base";
    }

    @Override
    public List<User> listUser() {

        try {
            SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
            SqlSession session = sessionFactory.openSession(false);
            User user = new User();
            user.setName("wang");
            user = session.selectOne("my_shoot.service.dao.UserDao", new User());
            session.commit();
        } catch (Exception e) {

        }
        return userDao.list();
    }

    @Override
    @Transactional
    public User findByName(User user) {
        User result = null;
        try {
            SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
            SqlSession session = sessionFactory.openSession(false);
            result = session.selectOne("my_shoot.service.dao.UserDao.findByName", user);
            session.commit();
        } catch (Exception e) {

        }
        return result;
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User findByNameForUpdate(User user) {
//        User result = null;
//        try {
//            SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
//            SqlSession session = sessionFactory.openSession(false);
//
//            result = session.selectOne("my_shoot.service.dao.UserDao.findByNameForUpdate", user);
//            System.out.println("start:" + System.currentTimeMillis());
//
//
//            Thread.sleep(100);
//            System.out.println("end:"+System.currentTimeMillis());
//            session.commit();
//        } catch (Exception e) {
//
//        }
//        return result;
        userDao.findByNameForUpdate(user);
        System.out.println("start:" + System.currentTimeMillis());


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }

        System.out.println("end:" + System.currentTimeMillis());

        return null;

    }

    @Override
    @Transactional(value = "transactionManager", isolation = Isolation.SERIALIZABLE)
    public int updateById(User user) {
        System.out.println("start:" + System.currentTimeMillis());
        int res = userDao.updateById(user);
//        if(user != null){
//            throw new RuntimeException("xxxx");
//        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        System.out.println("end:" + System.currentTimeMillis());
        return res;
//        int res = 0;
//        SqlSessionFactory sessionFactory = null;
//        SqlSession session = null;
//        try {
//            sessionFactory = sqlSessionFactory.getObject();
//            session = sessionFactory.openSession(false);
//            UserDao userDao = session.getMapper(UserDao.class);
//            userDao.updateById(user);
//
//            if (1 == 1) {
//                throw new RuntimeException("123");
//            }
//
//            session.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return res;
    }

    @Override
    @Transactional
    public void testMethod(User user) {
        System.out.println("testMethod start:"+ System.currentTimeMillis());

        baseServiceForTrans.findByNameForUpdate(user);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        System.out.println("testMethod end:"+ System.currentTimeMillis());

    }
}
