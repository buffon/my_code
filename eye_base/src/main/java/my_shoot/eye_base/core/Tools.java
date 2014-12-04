package my_shoot.eye_base.core;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @auther: chenyehui
 * @since: 14-8-21 下午10:35
 */
public class Tools {

    public static String methodParse(Method method) {
        StringBuffer sb = new StringBuffer();
        sb.append(method.getDeclaringClass()).append(" ").append(method.getName());
        return sb.toString();
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }
}
