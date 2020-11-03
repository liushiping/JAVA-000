package lsp.netty.gateway.filter;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;

/**
 * 将请求的method置为POST
 * @author William
 */
public class MethodToPost implements RequestFilter {

    /**
     * 设置Request的Method为POST
     * @param request
     */
    @Override
    public void filter(HttpRequest request) {
        request.setMethod(HttpMethod.POST);
    }
}
