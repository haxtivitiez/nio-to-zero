package xyz.un4ckn0wl3z.hellonio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicBuffer {
	
	public static void main(String[] args){
		
		Path file = null;
		BufferedReader bufferedReader = null;
		
		try {
			file = Paths.get("D:\\ExperDev\\hello-nio\\testbuff.txt");
			InputStream inputStream = Files.newInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println("Reading the Line of testbuff.txt file:" + bufferedReader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
