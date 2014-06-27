package my_shoot.eye.core;

/**
 * Created with IntelliJ IDEA.
 * User: chenyehui
 * Date: 14-6-27
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class SpanContainer {

    private static ThreadLocal<Span> threadLocal = new ThreadLocal<Span>();

    public static Span getSpan(){
        return threadLocal.get();
    }

    public static void setSpan(Span span){
        threadLocal.set(span);
    }

}
