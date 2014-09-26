package my_shoot.server.mongo.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import my_shoot.eye.core.Span;
import my_shoot.server.mongo.BaseDaoImpl;
import my_shoot.server.mongo.SpanDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther: chenyehui
 * @since: 14-9-26 上午10:47
 */
@Component
public class SpanDaoImpl extends BaseDaoImpl implements SpanDao {

    public SpanDaoImpl() {
        super();
    }

    @Override
    public void insert(Span span) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("url", span.getMethod());
        dbObject.put("span", JSON.toJSONString(span));

        spanTable.insert(dbObject);
    }

    @Override
    public List<Span> get(Integer traceId) {
        return null;
    }

    @Override
    public List<Span> get(String url) {
        List<DBObject> objects = spanTable.find(new BasicDBObject("url", url)).toArray();
        List<Span> spans = new ArrayList<Span>();
        for (DBObject object : objects) {
            spans.add(JSON.parseObject(((BasicDBObject) object).getString("span"), Span.class));
        }
        Collections.reverse(spans);
        return spans;
    }

}
