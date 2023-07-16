package edu.FileIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO_Practice {

	static String rootPath = ".\\INPUT";
	static void printFile(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				printFile(file.getPath());
			} else {
				System.out.print(file.getPath());
				System.out.print(": ");
				System.out.println(file.length() + "bytes");
			}
		}
	}
	
	static void fileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				fileSearchAll(file.getPath());
			} else {
				String partPath = path.substring(rootPath.length());
				System.out.println("." + partPath + "\\" + file.getName());
				if (file.length() > 3*1024) {
					copyFile(partPath, file.getName());
				}
			}
		}
	}
	
	static void copyFile(String partPath, String fileName) {
		final int BUFFER_SIZE = 512;
		int readLen;
		
		try {
			File destFolder = new File(".\\OUTPUT" + partPath);
			if (!destFolder.exists()) {
				destFolder.mkdirs();
			}
			
			InputStream is = new FileInputStream(".\\INPUT" + partPath + "\\" + fileName);
			OutputStream os = new FileOutputStream(".\\OUTPUT" + partPath + "\\" + fileName);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while ((readLen = is.read(buffer)) != -1) {
				os.write(buffer, 0, readLen);
			}
			
			is.close();
			os.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		
	}
	
	public static void main(String[] args) {
	//		printFile(rootPath);
		fileSearchAll(rootPath);
	}
	
}
