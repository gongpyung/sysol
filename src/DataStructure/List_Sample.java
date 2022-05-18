package DataStructure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class List_Sample {

	public static void main(String[] args) throws Exception {
		ArrayList<String> al = new ArrayList<String>();
		
		// 데이터 입력
		al.add("Michael Knight");
		al.add("Mac Guyver");
		al.add("Clark Kent");
		al.add("Bruce Wayne");
		al.add("Tony Stark");
		
		// 출력(방식 1)
		for (String name : al) System.out.println(name);
		System.out.println();
		// 데이터 삭제
		al.remove("Clark Kent");
		// 출력(방식 2)
		for (int i=0; i<al.size(); i++) System.out.println(al.get(i));
		System.out.println();
		
		al.remove(0);
		// 출력(방식 3)
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) System.out.println(itr.next());
		System.out.println();
		
		// 정렬 (오름차순)
		Collections.sort(al);
		
		for (String name : al) System.out.println(name);
		System.out.println();
		
		// 정렬 Comparator
		Comparator<String> co = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2.compareTo(o1)); // 내림차순
			}
		};
		// 정렬 Comparator 사용
		Collections.sort(al, co);
		
		for (String name : al) System.out.println(name);
		System.out.println();
		
		// 정렬 (람다식 사용)
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2));
		for (String name : al) System.out.println(name);
		System.out.println();
				
	}
}