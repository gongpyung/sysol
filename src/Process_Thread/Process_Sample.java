package Process_Thread;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Process_Sample {
	// cmdList - 프로세스 실행 커맨드
	public static String getProcessOutput(List<String> cmdList) throws IOException {
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		// 프로세스 실행
		Process process = builder.start();
		// 출력 가져오기
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return (new String(buffer));
	}
	public static void main(String[] args) {
		// add_2sec.exe - 프로세스 이름, 2,3 - 아규먼트
//		String output = getProcessOutput(ArrayList.asList("add_2sec.exe", "2", "3"));
//		System.out.println(output);
	}

}
