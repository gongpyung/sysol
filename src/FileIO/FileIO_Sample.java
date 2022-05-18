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
			// �Է� ��Ʈ��
			FileReader fileReader = new FileReader(fileName);
			// �Է� ��Ʈ�����κ��� ���ڸ� ���� �� ���۸�
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// ���۷κ��� �� �پ� �б�
			while((line = bufferedReader.readLine()) != null) {
				// ȭ�鿡 �� �پ� ���
				System.out.println(line);
			}
			// ���� ���� �ݱ�
			bufferedReader.close();
			
		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
	
	void CopyFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE = 4096;
		int readLen;
		
		try {
			// ����Ʈ ���� ����� ��Ʈ��
			InputStream inputStream = new FileInputStream(inputFile);
			OutputStream outputStream = new FileOutputStream(outputFile);
			
			//����Ʈ �迭 ���� ����
			byte[] buffer = new byte[BUFFER_SIZE];
			
			// ������ �о� ���ۿ� ���
			while ((readLen = inputStream.read(buffer)) != -1) {
				// ������ ������ ���Ͽ� ����
				outputStream.write(buffer, 0, readLen);
			}
			// ����� ��Ʈ�� �ݱ�
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
	
	void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				// ������ ��� ���ȣ���� ���� ���� ���� ���� Ž��
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
