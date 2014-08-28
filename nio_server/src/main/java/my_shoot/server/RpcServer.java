package my_shoot.server;

import my_shoot.server.handler.SpanReceiveHandler;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @auther: chenyehui
 * @since: 14-8-28 上午12:26
 */
public class RpcServer {


    public static void start(){

        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory()
        {

            @Override
            public ChannelPipeline getPipeline() throws Exception
            {
                ChannelPipeline pipleline = Channels.pipeline(new ObjectDecoder(), new SpanReceiveHandler());
                return pipleline;
            }

        });

        bootstrap.bind(new InetSocketAddress(8080));
    }

    public static void main(String[] args) {
        start();
    }
}
