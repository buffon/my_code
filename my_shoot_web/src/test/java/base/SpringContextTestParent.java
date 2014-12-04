package base;

import my_shoot.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午1:37
 */
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SpringContextTestParent extends AbstractTestNGSpringContextTests {

    @Autowired
    public BaseService baseService;
}
