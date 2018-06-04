package xyz.un4ckn0wl3z.hellonio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class BasicScatterAndGather {

	public static void main(String[] args) {
		
		String data = "Scattering and Gathering example shown in www.un4ckn0wl3z.xyz";
		
		 gatherBytes(data);  
	     scatterBytes(); 

	}
	
	
	 /* gatherBytes() is used for reading the bytes from the buffers and write it to a file channel. */  
	public static void gatherBytes(String data) {
		ByteBuffer buffer1 = ByteBuffer.allocate(8);
		ByteBuffer buffer2 = ByteBuffer.allocate(400);
		
		buffer1.asIntBuffer().put(420);
		buffer2.asCharBuffer().put(data);
		
		GatheringByteChannel gatherer = createChannelInstance("D:\\ExperDev\\hello-nio\\testgathsatt.txt", true);
		
		try {
			gatherer.write(new ByteBuffer[] {buffer1,buffer2});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/* scatterBytes() is used for reading the bytes from a file channel into a set of buffers. */
	public static void scatterBytes() {
		
		ByteBuffer buffer1 = ByteBuffer.allocate(8);
		ByteBuffer buffer2 = ByteBuffer.allocate(400);
		
		ScatteringByteChannel scatter = createChannelInstance("D:\\ExperDev\\hello-nio\\testgathsatt.txt", false);
		
		try {
			 scatter.read(new ByteBuffer[] { buffer1, buffer2 });  
		} catch (Exception e) {
			e.printStackTrace();
		}
		 //Read the two buffers seperately  
        buffer1.rewind();  
        buffer2.rewind();  
   
        int bufferOne = buffer1.asIntBuffer().get();  
        String bufferTwo = buffer2.asCharBuffer().toString();  
        //Verification of content  
        System.out.println(bufferOne);  
        System.out.println(bufferTwo);  
	}
	
	
	
	
	public static FileChannel createChannelInstance(String file,boolean isOutput) {
		FileChannel fileChannel = null;
		try {
			if(isOutput){
				fileChannel = new FileOutputStream(file).getChannel();
			}else{
				fileChannel = new FileInputStream(file).getChannel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileChannel;
		
	}

}
