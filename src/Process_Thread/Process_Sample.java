package Process_Thread;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Process_Sample {
	// cmdList - ���μ��� ���� Ŀ�ǵ�
	public static String getProcessOutput(List<String> cmdList) throws IOException {
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		// ���μ��� ����
		Process process = builder.start();
		// ��� ��������
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return (new String(buffer));
	}
	public static void main(String[] args) {
		// add_2sec.exe - ���μ��� �̸�, 2,3 - �ƱԸ�Ʈ
//		String output = getProcessOutput(ArrayList.asList("add_2sec.exe", "2", "3"));
//		System.out.println(output);
	}

}
