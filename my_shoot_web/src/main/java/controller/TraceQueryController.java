package controller;

import my_shoot.eye.core.Span;
import my_shoot.eye.util.SpanShow;
import my_shoot.server.mongo.SpanDao;
import my_shoot.server.mongo.impl.SpanDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther: chenyehui
 * @since: 14-9-26 下午8:57
 */
@Controller
@RequestMapping("trace")
public class TraceQueryController {

    SpanDao spanDao = new SpanDaoImpl();


    @RequestMapping("query")
    @ResponseBody
    public String query(String url) {
        List<Span> spanList = spanDao.get(url);
        if (spanList != null && spanList.size() > 0)
            return SpanShow.webShow(spanList);
        return "No data";
    }

    @RequestMapping("query_page")
    public String query_page(){
        return "query_trace";
    }
}
