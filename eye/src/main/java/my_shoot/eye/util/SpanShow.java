package my_shoot.eye.util;

import java.text.SimpleDateFormat;
import java.util.List;

import my_shoot.eye_base.core.Span;

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

    public static String webShow(Span span, int i, StringBuilder sb) {
        if (sb == null)
            sb = new StringBuilder();
        if (span != null) {
            for (int t = 0; t < i; t++)
                sb.append("|---");
            if (i == 0) {
                sb.append(format.format(span.getStartTime()) + " ");
            }
            sb.append(span.getMethod() + " => " + (span.getEndTime() - span.getStartTime()) + "ms").append("<br>");
            List<Span> spans = span.getSubs();
            if (spans != null) {
                for (Span subspan : spans) {
                    webShow(subspan, i + 1, sb);
                }
            }
        }
        return sb.toString();
    }

    public static String webShow(Span span) {
        return webShow(span, 0, null);
    }

    public static String webShow(List<Span> spans) {
        StringBuilder sb = new StringBuilder();
        for (Span span : spans) {
            sb.append(webShow(span, 0, null));
        }
        return sb.toString();
    }

    public static Span rmParam(Span span) {
        if (span != null) {
            span.setCurrent(null);
            span.setParent(null);
            List<Span> spans = span.getSubs();
            if (spans != null) {
                for (Span subspan : spans) {
                    rmParam(subspan);
                }
            }
        }
        return span;
    }
}
