import base.SpringContextTestParent;
import my_shoot.service.dao.User;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午2:39
 */
public class RealTest extends SpringContextTestParent {

    @Test
    public void testListUser() {
        User user = new User();
        user.setName("yehui3");

        User res = baseService.findByName(user);

        assertNotNull(res);
    }


    @Test
    public void testListUserForUpdate() {
        User user = new User();
        user.setName("yehui3");
        User res = baseService.findByNameForUpdate(user);
        assertNotNull(res);
    }


    @Test
    public void testUpdate() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + " start");
            User user = new User();
            user.setName("yehui" + i);
            user.setId(2);
            new My(user).start();
        }

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {

        }
    }

    class My extends Thread {

        public My(User user){
            this.user = user;
        }

        private User user;

        User getUser() {
            return user;
        }

        void setUser(User user) {
            this.user = user;
        }

        @Override
        public void run() {

            baseService.testMethod(user);
        }
    }
}
