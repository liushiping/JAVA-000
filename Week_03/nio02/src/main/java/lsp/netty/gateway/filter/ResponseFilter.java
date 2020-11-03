package lsp.netty.gateway.filter;

import io.netty.handler.codec.http.HttpResponse;

/**
 *
 * @author William
 */
public interface ResponseFilter {

    /**
     * 对返回进行处理
     * @param response
     */
    public void filter(HttpResponse response);
}
