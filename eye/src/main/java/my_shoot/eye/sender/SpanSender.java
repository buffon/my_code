package my_shoot.eye.sender;

import my_shoot.eye.handler.SpanHandler;
import my_shoot.eye_base.core.Span;

/**
 * @author chenyehui
 */
public class SpanSender {

    private SpanHandler spanHandler;

    public void send(Span span) {
        spanHandler.handler(span);
    }

    public SpanHandler getSpanHandler() {
        return spanHandler;
    }

    public void setSpanHandler(SpanHandler spanHandler) {
        this.spanHandler = spanHandler;
    }
}
