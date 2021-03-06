//package my_shoot.service.http;
//
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.StatusLine;
//import org.apache.http.client.HttpResponseException;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//
///**
// */
//public abstract class AbstractResponseHandler<T> implements ResponseHandler<T> {
//
//    public static final int HTTP_UNSUCCESS_CODE = 300;
//
//    @Override
//    public T handleResponse(HttpResponse response) throws IOException {
//        StatusLine statusLine = response.getStatusLine();
//        HttpEntity entity = response.getEntity();
//        if (statusLine.getStatusCode() >= HTTP_UNSUCCESS_CODE) {
//            String errMsg = EntityUtils.toString(entity);
//            throw new HttpResponseException(statusLine.getStatusCode(), errMsg);
//        }
//        return handle(entity);
//    }
//
//    public  T handle(HttpEntity entity) {
//    	return handle(entity, null);
//    }
//
//    public abstract T handle(HttpEntity entity,Class<T> clazz) ;
//}
