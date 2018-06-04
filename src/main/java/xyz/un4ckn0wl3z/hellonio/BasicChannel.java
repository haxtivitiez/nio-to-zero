package xyz.un4ckn0wl3z.hellonio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;


public class BasicChannel {
	
	public static void main(String[] args) throws IOException{
		
		@SuppressWarnings("resource")
		FileInputStream input = new FileInputStream("D:\\ExperDev\\hello-nio\\testin.txt");
		ReadableByteChannel source = input.getChannel();
		
		@SuppressWarnings("resource")
		FileOutputStream output = new FileOutputStream("D:\\ExperDev\\hello-nio\\testout.txt");
		WritableByteChannel destination = output.getChannel();
		
		copyData(source,destination);
		
	}
	
	private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(20*1024);
		while(src.read(buffer) != -1){
			buffer.flip();
			while(buffer.hasRemaining()){
				dest.write(buffer);
			}
			buffer.clear();
		}
	}

}
