package my_shoot.client;

import my_shoot.client.handler.SpanSendHandler;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.factory.InitializingBean;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @auther: chenyehui
 * @since: 14-8-28 上午12:36
 */
public class RpcClient implements InitializingBean {

    private static ChannelFuture future;

    private String ip;

    private Integer port;

    public void init() {
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            /*
             * (non-Javadoc)
             * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
             */
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                /*
                 * 在DefaultChannelPipeline的过滤器 链中实现了
                 * encode 、decode、handler
                 * 其中encode实现自ChannelDownstreamHandler接口
                 * decode、Handler实现自ChannelUpstreamHandler接口
                 * 也就说明了在client发送消息的时候，默认按照顺序会先调用decode
                 * 在client接收到响应的时候，会按照顺序调用encode和Handler。
                 * 后面会有文章专门将ChannelDownstreamHandler和ChannelUpstreamHandler的调用顺序。
                 */
                ChannelPipeline pipleline = Channels.pipeline(new ObjectEncoder(), new SpanSendHandler());
                return pipleline;
            }
        });

        future = bootstrap.connect(new InetSocketAddress(ip, port));
    }

    public void sendMsg(String s) {
        if (future == null) init();
        future.getChannel().write(s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
