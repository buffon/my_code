package my_shoot.server.mongo;

import my_shoot.eye.core.Span;

import java.util.List;

/**
 * @auther: chenyehui
 * @since: 14-9-26 上午11:02
 */
public interface SpanDao {

    public void insert(Span span);

    public List<Span> get(Integer traceId);

    public List<Span> get(String url);
}
