package my_shoot.eye.util;

import my_shoot.eye.core.Span;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @auther: chenyehui
 * @since: 14-8-21 上午12:20
 */
public class SpanShow {

    static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");

    public static void show(Span span, int i) {
        if (span != null) {
            for (int t = 0; t < i; t++)
                System.out.print("|---");
            if (i == 0) {
                System.out.print(format.format(span.getStartTime()) + " ");
            }
            System.out.println(span.getMethod() + " => " + (span.getEndTime() - span.getStartTime()) + "ms");
            List<Span> spans = span.getSubs();
            if (spans != null) {
                for (Span subspan : spans) {
                    show(subspan, i + 1);
                }
            }
        }
    }
}
