package my_shoot.service.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午2:17
 */
@Repository
public interface UserDao {

    List<User> list();

    List<User> findByName(User user);

    int updateById(User user);

    int updateByIdForUpdate(User user);

    List<User> findByNameForUpdate(User user);
}
