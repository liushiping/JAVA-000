package lsp.netty.gateway.route;

import java.util.Map;
import java.util.Properties;

/**
 *
 * @author William
 */
public class RouteTable {
    static final private RouteTableSingleton route = RouteTableSingleton.getInstance();

    static public void initTable() {
        route.readJsonConfig();
    }

    static public Map<String, String> getTarget(String url) {
        return route.getTarget(url);
    }

    static public String getTargetUrl(String url) {
        return route.getTargetUrl(url);
    }
}
