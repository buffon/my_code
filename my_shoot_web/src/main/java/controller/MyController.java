package controller;

import my_shoot.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: harry.chen
 * @since: 14-6-4 下午4:35
 */
@Controller
public class MyController {
    @Autowired
    BaseService baseService;

    @Value("${key}")
    String key;

    @RequestMapping(value = "/base", method = RequestMethod.GET)
    @ResponseBody
    public String my(){
        return baseService.base() + ":" + key;
    }
}
