//package my_shoot.service.http;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.util.EntityUtils;
//
///***
// */
//public class JsonResponseHandler<T> extends AbstractResponseHandler<T> {
//
//	@Override
//	public T handle(HttpEntity entity,Class<T> clazz) {
//		String json;
//		try {
//			json = EntityUtils.toString(entity);
//
//			return null;// JSON.parseObject(json, clazz);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        return null;
//	}
//
//}
