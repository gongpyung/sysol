package DataStructure;
import java.util.HashMap;

public class Map_Sample {

	public static void main(String[] args) {
		// HashMap 인스턴스 생성
		HashMap<String, String> m = new HashMap<String, String>();
		// 데이터 입력
		m.put("kit@gmail.com", "Michael Knight");
		m.put("knife@gmail.com", "Mac Guyver");
		m.put("superman@gmail.com", "Clark Kent");
		m.put("batman@gmail.com", "Bruce Wayne");
		m.put("ironman@gmail.com", "Tony Stark");
		// 출력
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
		System.out.println();
		// 데이터 삭제
		m.remove("superman@gmail.com");
		
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
		System.out.println();
		// 데이터(Value) 변경
		m.replace("batman@gmail.com", "Robin");
		for (String key : m.keySet()) System.out.println(key + " : " + m.get(key));
	}
}