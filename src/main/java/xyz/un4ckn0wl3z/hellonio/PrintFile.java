package xyz.un4ckn0wl3z.hellonio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {

	public static void print(String path) throws IOException {
		FileReader filereader = new FileReader(path);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		String tr = bufferedreader.readLine();
		System.out.println("The Content of testout.txt file is: ");
		while (tr != null) {
			System.out.println("    " + tr);
			tr = bufferedreader.readLine();
		}
		filereader.close();
		bufferedreader.close();
	}

}
