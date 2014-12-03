package my_shoot.eye.interceptor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import my_shoot.eye.sender.SpanSender;
import my_shoot.eye.util.SpanShow;
import my_shoot.eye_base.core.Span;
import my_shoot.eye_base.core.SpanContainer;

/**
 * Created with IntelliJ IDEA.
 * User: chenyehui
 * Date: 14-6-27
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
public class ControllerHandler extends HandlerInterceptorAdapter {

//    @Autowired
//    RpcClient rpcClient;

    /**
     * version 2 .
     */
    @Autowired
    private SpanSender spanSender;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Span.newSpan("[" + request.getRequestURI() + "]");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        Span.over();

        Span span = SpanContainer.getSpan();


        /*handle how to show*/
        SpanShow.show(SpanContainer.getSpan(), 0);
        /*
         * to nio server
         */
        //rpcClient.sendMsg(JSON.toJSONString(SpanShow.rmParam(SpanContainer.getSpan())));

        spanSender.send(span);
    }
}
