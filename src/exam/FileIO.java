package exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO {

	public static void main(String[] args) throws IOException {
		// 1.  Input message
		String input = null;
		System.out.println("Input Your message : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		System.out.println("Your message is - " + input);
		br.close();
		
		// 2. Read File
		input = null;
		String path = ".\\INPUT\\List_Sample.txt";
		BufferedReader in = new BufferedReader(new FileReader(path));
		
		while ((input = in.readLine()) != null) {
			String[] words = input.split("\t");
			System.out.println(words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3]);
		}
		
		in.close();
		

//		System.exit(0);
	}

}
