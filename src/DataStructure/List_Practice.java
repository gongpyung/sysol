package DataStructure;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class List_Practice {

	public static void main(String[] args) throws IOException {

		String line;
		FileReader fr = new FileReader("./INPUT/List_Sample.txt");
		BufferedReader br = new BufferedReader(fr);

		ArrayList<Grade> al = new ArrayList<Grade>();
		Grade g;

		while ((line = br.readLine()) != null) {
			String[] arr = line.split("\t");
			g = new Grade(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
			al.add(g);
		}
		
		br.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = in.readLine();
			
			switch(input) {
			
			case "PRINT" :
				Collections.sort(al, (g1, g2) -> g1.getName().compareTo(g2.getName()));
				break;
				
			case "KOREAN" :
				Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getKorean() - g1.getKorean());
				break;
				
			case "ENGLISH" :
				Collections.sort(al, (g1, g2) -> (g2.getEnglish() - g1.getEnglish()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getEnglish() - g1.getEnglish());
				break;
				
			case "MATH" :
				Collections.sort(al, (g1, g2) -> (g2.getMath() - g1.getMath()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getMath() - g1.getMath());
				break;
				
			case "QUIT" :
				return;
				
			default :
				continue;
				
			}
			
			for (Grade out : al) System.out.println(String.format("%s\t%d\t%d\t%d", out.getName(), out.getKorean(), out.getEnglish(), out.getMath())); 
		}
	}
}

class Grade {

	private String name;
	private int korean;
	private int english;
	private int math;

	public Grade(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
