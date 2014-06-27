package my_shoot.eye.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: chenyehui
 * Date: 14-6-27
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class TraceContainer {

    private static final int QUEUE_SIZE = 10000;
    private static final BlockingQueue<Span> queue = new LinkedBlockingQueue<Span>(QUEUE_SIZE);
}
