package lsp.netty.gateway.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * William
 */
public class Server {

    static public void run(EventLoopGroup bossGroup, EventLoopGroup serverGroup, int port) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, serverGroup)
                .option(ChannelOption.SO_REUSEADDR, true)
                .channel(NioServerSocketChannel.class)
//                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ServerInitializer());

        Channel channel = serverBootstrap.bind(port).sync().channel();
        System.out.println("Gateway lister on port: " + port);
        channel.closeFuture().sync();
    }
}
