package lsp.netty.gateway.filter;

import io.netty.handler.codec.http.HttpRequest;

/**
 *
 * @author William
 */
public interface RequestFilter {

    /**
     * 对请求进行处理
     * @param request
     */
    public void filter(HttpRequest request);
}
