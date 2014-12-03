package my_shoot.eye_base.core;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import my_shoot.eye.util.Tools;

public class Span implements Serializable{

    /*唯一 iD*/
    private String traceId;

    /*当前方法名*/
    private String method;

    /*当前span*/
    private Span current;

    /*父span*/
    private Span parent;

    /*子span*/
    private List<Span> subs = new ArrayList<Span>();

    /*开始时间*/
    private Long startTime;

    /*结束时间*/
    private Long endTime;

    public Span() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * 在每一次调用开始的时候，新建一个span
     * @param method
     */
    public static void newSpan(String method){
        Span span = new Span();
        span.setTraceId(Tools.getUUID());
        span.setCurrent(span);
        span.setMethod(method);
        SpanContainer.setSpan(span);
    }

    public static void enter(Method method) {
        Span span = SpanContainer.getSpan();
        if (span != null) {
            Span sub = new Span();
            String methodName = Tools.methodParse(method);
            sub.setMethod(methodName);
            sub.setParent(span.getCurrent());
            span.getCurrent().getSubs().add(sub);
            span.setCurrent(sub);
            SpanContainer.setSpan(span);
        }
    }


    public static void over() {
        Span span = SpanContainer.getSpan();
        if (span != null) {
            span.getCurrent().setEndTime(System.currentTimeMillis());
            if (span.getCurrent().getParent() != null) {
                span.setCurrent(span.getCurrent().getParent());
            }
            SpanContainer.setSpan(span);
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Span getCurrent() {
        return current;
    }

    public void setCurrent(Span current) {
        this.current = current;
    }

    public Span getParent() {
        return parent;
    }

    public void setParent(Span parent) {
        this.parent = parent;
    }

    public List<Span> getSubs() {
        return subs;
    }

    public void setSubs(List<Span> subs) {
        this.subs = subs;
    }


    public String getTraceId() {

        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "Span{" +
                "traceId='" + traceId + '\'' +
                ", method='" + method + '\'' +
                ", current=" + current +
                ", parent=" + parent +
                ", subs=" + subs +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
