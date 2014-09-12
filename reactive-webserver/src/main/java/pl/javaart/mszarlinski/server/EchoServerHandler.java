package pl.javaart.mszarlinski.server;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * @author mszarlinski
 *
 */
@Sharable
public class EchoServerHandler extends SimpleChannelInboundHandler<String> {
	/*
	private static final String NEWLINE = System.lineSeparator();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName()
				+ NEWLINE);
		ctx.write("Thread: " + Thread.currentThread().getName() + NEWLINE);
		ctx.flush();
	}
*/
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
