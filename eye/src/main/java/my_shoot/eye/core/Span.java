package my_shoot.eye.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chenyehui
 * Date: 14-6-27
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class Span {

    private String traceId;

    private List<String> urls = new ArrayList<String>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getTraceId() {

        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(traceId);
        sb.append("\n");
        for(String s :urls){
              sb.append(s).append(";");

        }
        return sb.toString();
    }
}
