package edu.Process_Thread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Thread_Practice2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Start - " + new Date().toString());
		
		FileReader fr = new FileReader("./INPUT/NUM.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		List<PlusThread> tl = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(" ");
			int num1 = Integer.parseInt(arr[0]);
			int num2 = Integer.parseInt(arr[1]);
			
			PlusThread pt = new PlusThread(num1, num2);
			pt.start();
			
			tl.add(pt);
			
		}
		br.close();
		
		for (PlusThread li : tl) {
			li.join();
		}
		System.out.println("End - " + new Date().toString());
	}

}

class PlusThread extends Thread {
	int num1;
	int num2;
	
	public PlusThread(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public void run() {
		String output;
		try {
			output = getProcessOuput(Arrays.asList("./INPUT/add_2sec.exe", Integer.toString(num1), Integer.toString(num2)));
			System.out.println(num1 + " + " + num2 + " = " + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getProcessOuput(List<String> cmdList) throws IOException {
		ProcessBuilder pb= new ProcessBuilder(cmdList);
		Process pc = pb.start();
		InputStream is = pc.getInputStream();
		byte[] buffer = new byte[1024];
		int len = is.read(buffer);
		
		return (new String(buffer, 0, len));
	}
}
