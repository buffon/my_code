package my_shoot.impl;

import my_shoot.base.SpringContextTestParent;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午1:36
 */
public class BaseServiceImplTest extends SpringContextTestParent {

    @Test
    public void testMy(){
        String res= baseService.base();
        assertEquals(res, "");
    }
}
