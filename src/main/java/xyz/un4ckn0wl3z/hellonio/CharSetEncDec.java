package xyz.un4ckn0wl3z.hellonio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharSetEncDec {

	public static void main(String[] args) throws IOException {

		Charset cs = Charset.forName("UTF-8");
		CharsetDecoder csdecoder = cs.newDecoder();
		CharsetEncoder csencoder = cs.newEncoder();
		String st = "Example of Encode and Decode in Java NIO.";
		ByteBuffer bb = ByteBuffer.wrap(st.getBytes());
		CharBuffer cb = csdecoder.decode(bb);
		ByteBuffer newbb = csencoder.encode(cb);
		while (newbb.hasRemaining()) {
			char ca = (char) newbb.get();
			System.out.print(ca);
		}
		newbb.clear();

	}

}
