package DataStructure;
import java.util.HashMap;

public class Map_Sample {

	public static void main(String[] args) {
		// HashMap �ν��Ͻ� ����
		HashMap<String, String> m = new HashMap<String, String>();
		// ������ �Է�
		m.put("kit@gmail.com", "Michael Knight");
		m.put("knife@gmail.com", "Mac Guyver");
		m.put("superman@gmail.com", "Clark Kent");
		m.put("batman@gmail.com", "Bruce Wayne");
		m.put("ironman@gmail.com", "Tony Stark");
		// ���
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
		System.out.println();
		// ������ ����
		m.remove("superman@gmail.com");
		
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
		System.out.println();
		// ������(Value) ����
		m.replace("batman@gmail.com", "Robin");
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
	}
}