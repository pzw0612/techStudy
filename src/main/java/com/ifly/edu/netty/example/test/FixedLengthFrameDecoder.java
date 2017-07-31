package com.ifly.edu.netty.example.test;

/**
 *
 * @author pangzhw
 * @date 2015年7月11日
 */
import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
	private final int frameLength;

	public FixedLengthFrameDecoder(int frameLength) {
		if (frameLength <= 0) {
			throw new IllegalArgumentException(
					"frameLengthmust bea positive integer:" + frameLength);
		}
		this.frameLength = frameLength;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		while (in.readableBytes() >= frameLength) {
			ByteBuf buf = in.readBytes(frameLength);
			out.add(buf);
		}
		
	}
}
