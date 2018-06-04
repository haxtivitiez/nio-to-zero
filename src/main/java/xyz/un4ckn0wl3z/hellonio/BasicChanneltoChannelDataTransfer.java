package xyz.un4ckn0wl3z.hellonio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class BasicChanneltoChannelDataTransfer {
	
	public static void main(String[] args) throws IOException {
		
		 //Path of Input files  
		String[] iF = new String[] {
				"D:\\ExperDev\\hello-nio\\input1.txt",
				"D:\\ExperDev\\hello-nio\\input2.txt",
				"D:\\ExperDev\\hello-nio\\input3.txt",
				"D:\\ExperDev\\hello-nio\\input4.txt",
				"D:\\ExperDev\\hello-nio\\input5.txt",
		};
		
		
		//Path of Output file and contents will be written in this file  
		 String oF = "D:\\ExperDev\\hello-nio\\combine_output.txt";
		 
		 FileOutputStream output = new FileOutputStream(new File(oF));
		 
		 WritableByteChannel targetChannel = output.getChannel();
		 
		 for (int i = 0; i < iF.length; i++) {
			 
			//Get the channel for input files  
			FileInputStream input = new FileInputStream(iF[i]);
			FileChannel inputChannel = input.getChannel();
			
			  //The data is tranfer from input channel to output channel 
			
			inputChannel.transferTo(0, inputChannel.size(), targetChannel);
			
			 //close an input channel  
			
			inputChannel.close();
			input.close();
			
			
		}
		 
		 targetChannel.close();
		 output.close();
		 
		
		
	}

}
