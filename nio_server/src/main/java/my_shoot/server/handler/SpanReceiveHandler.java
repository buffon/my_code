package my_shoot.server.handler;

import my_shoot.eye.core.Span;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @auther: chenyehui
 * @since: 14-8-29 上午12:13
 */
public class SpanReceiveHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Span span = (Span) e.getMessage();

        /*
         * handle span
         */
        System.out.println(span);
    }
}
