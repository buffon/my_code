import base.SpringContextTestParent;
import my_shoot.service.dao.User;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午2:39
 */
public class RealTest extends SpringContextTestParent {

    @Test
    public void testListUser(){
        List<User> users = baseService.listUser();
        assertEquals(users.size(), 3);
    }
}
