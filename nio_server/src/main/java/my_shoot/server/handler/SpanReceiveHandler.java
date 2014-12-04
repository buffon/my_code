package my_shoot.server.handler;

import com.alibaba.fastjson.JSON;

import my_shoot.eye_base.core.Span;
import my_shoot.server.mongo.SpanDao;
import my_shoot.server.mongo.impl.SpanDaoImpl;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther: chenyehui
 * @since: 14-8-29 上午12:13
 */

public class SpanReceiveHandler extends SimpleChannelHandler {

    SpanDao spanDao = new SpanDaoImpl();

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Span span = JSON.parseObject((String) e.getMessage(),Span.class);

        /*
         * handle span
         */
//        System.out.println(span);
        spanDao.insert(span);
    }
}
