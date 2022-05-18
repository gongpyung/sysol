package FileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO_Sample {
	
	void PrintFile(String fileName) {
		String line = null;
		
		try {
			// 입력 스트림
			FileReader fileReader = new FileReader(fileName);
			// 입력 스트림으로부터 문자를 읽을 때 버퍼링
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// 버퍼로부터 한 줄씩 읽기
			while((line = bufferedReader.readLine()) != null) {
				// 화면에 한 줄씩 출력
				System.out.println(line);
			}
			// 버퍼 리더 닫기
			bufferedReader.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
	
	void CopyFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE = 4096;
		int readLen;
		
		try {
			// 바이트 단위 입출력 스트림
			InputStream inputStream = new FileInputStream(inputFile);
			OutputStream outputStream = new FileOutputStream(outputFile);
			
			//바이트 배열 버퍼 생성
			byte[] buffer = new byte[BUFFER_SIZE];
			
			// 파일을 읽어 버퍼에 담기
			while ((readLen = inputStream.read(buffer)) != -1) {
				// 버퍼의 내용을 파일에 쓰기
				outputStream.write(buffer, 0, readLen);
			}
			// 입출력 스트림 닫기
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
	
	void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				// 폴더인 경우 재귀호출을 통한 하위 폴더 파일 탐색
				FileSearchAll(file.getPath());
			} else {
				System.out.println(file.getName());
			}
		}
	}
	
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
	
	public static void main(String[] args) {
		printFile("./INPUT");
	}
	
	
	
	public static void fileSearchALL(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				fileSearchALL(file.getPath());
			} else {
				long bytes = file.length();
				long kilobyte = bytes / 1024;
//				if (Files.size(file.getPath()))
				System.out.println(file.getPath() + file.getName() + ": " + bytes + "bytes");
				
			}
		}
	}

}
