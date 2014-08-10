package my_shoot.service;

import my_shoot.service.dao.User;

/**
 * @auther: chenyehui
 * @since: 14-8-10 下午11:19
 */
public interface BaseServiceForTrans {
    public User findByNameForUpdate(User user);
}
