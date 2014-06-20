package base;

import my_shoot.service.BaseService;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author: harry.chen
 * @since: 14-6-20 下午1:37
 */
@ContextConfiguration(loader = SpringockitoContextLoader.class, locations = {"classpath:spring/applicationContext.xml"})
public class SpringContextTestParent extends AbstractTestNGSpringContextTests {

    @Autowired
    public BaseService baseService;
}
