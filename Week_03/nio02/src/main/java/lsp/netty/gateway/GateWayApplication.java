package lsp.netty.gateway;


import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lsp.netty.gateway.filter.Filter;
import lsp.netty.gateway.route.RouteTable;
import lsp.netty.gateway.server.Server;

import java.io.IOException;

/**
 *
 * @author William
 */
public class GateWayApplication {

    public static void main(String[] args) throws InterruptedException, IOException {
        // 初始化监听端口
        int port = 8080;

        // 初始化路由配置
        RouteTable.initTable();

        // 初始化请求和返回的过滤器
        Filter.initRequestFilter();
        Filter.initResponseFilter();

        // 初始化Server
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup serverGroup = new NioEventLoopGroup();

        try {
            Server.run(bossGroup, serverGroup, port);
        } finally {
            bossGroup.shutdownGracefully();
            serverGroup.shutdownGracefully();
        }
    }
}
