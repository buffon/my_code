package my_shoot.server.mongo;

import java.util.List;

import my_shoot.eye_base.core.Span;

/**
 * @auther: chenyehui
 * @since: 14-9-26 上午11:02
 */
public interface SpanDao {

    public void insert(Span span);

    public List<Span> get(Integer traceId);

    public List<Span> get(String url);
}
