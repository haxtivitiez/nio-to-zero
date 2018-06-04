package xyz.un4ckn0wl3z.hellonio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeEx {
	
	public static void main(String[]args ) throws IOException {
		
		//The Pipe is created 
		
		Pipe pipe = Pipe.open();
		
		//For accessing the pipe sink channel  
		Pipe.SinkChannel skChannel = pipe.sink();
		
		String td = "Data is successfully sent for checking the java NIO Channel Pipe.";
		
		ByteBuffer bb = ByteBuffer.allocate(512); 
		
		bb.clear();  
	    bb.put(td.getBytes());  
	    bb.flip();  
	    
	    while(bb.hasRemaining()) {  
	          skChannel.write(bb);  
	    }
	    
	    
	    //For accessing the pipe source channel  
	    
	    Pipe.SourceChannel sourceChannel = pipe.source();
	    
	    bb = ByteBuffer.allocate(512);  
	    
	    while (sourceChannel.read(bb)>0) {
	    	
	    	bb.flip();  
	    	
	    	 while(bb.hasRemaining()){  
	              char TestData = (char) bb.get();  
	              System.out.print(TestData);  
	          }  
	    	
	    	bb.clear();  
	    }
	    
	    
	    
		
	}

}
