package my_shoot.eye.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import my_shoot.client.RpcClient;
import my_shoot.eye.util.SpanShow;
import my_shoot.eye_base.core.Span;
import my_shoot.eye_base.core.SpanContainer;

/**
 * @author chenyehui
 */
public class NettySpanHandler implements SpanHandler {

    @Autowired
    RpcClient rpcClient;

    @Override
    public void handler(Span span) {
        /*
         * to nio server
         */
        rpcClient.sendMsg(JSON.toJSONString(SpanShow.rmParam(SpanContainer.getSpan())));
    }
}
