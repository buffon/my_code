package my_shoot.server.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * @auther: chenyehui
 * @since: 14-9-26 上午10:50
 */
public class BaseDaoImpl implements InitializingBean, DisposableBean {


    public Mongo mongo = null;
    public DB db;
    public DBCollection spanTable;

    public BaseDaoImpl(){
        afterPropertiesSet();
    }

    @Override
    public void destroy() throws Exception {
        if (mongo != null)
            mongo.close();
        mongo = null;
        db = null;
        spanTable = null;
        System.gc();
    }

    @Override
    public void afterPropertiesSet(){
        try {
            mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        //获取temp DB；如果默认没有创建，mongodb会自动创建
        db = mongo.getDB("trace");
        //获取users DBCollection；如果默认没
        spanTable = db.getCollection("spans");
    }
}
