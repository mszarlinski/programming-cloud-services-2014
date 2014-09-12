package pl.javaart.mszarlinski.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 
 * @author mszarlinski
 *
 */
public class EchoServerInitializer extends ChannelInitializer<SocketChannel> {

	private static final StringDecoder DECODER = new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();

	private static final EchoServerHandler SERVER_HANDLER = new EchoServerHandler();

	private static final int MAX_FRAME_LENGTH = 8192;

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		// Add the text line codec combination first,
		pipeline.addLast(new DelimiterBasedFrameDecoder(MAX_FRAME_LENGTH,
				Delimiters.lineDelimiter()));
		// the encoder and decoder are static as these are sharable
		pipeline.addLast(DECODER);
		pipeline.addLast(ENCODER);

		// and then business logic.
		pipeline.addLast(SERVER_HANDLER);
	}
}