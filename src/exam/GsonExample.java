package exam;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonExample {

	public static void main(String[] args) {
		// 1. Gson generate
		Gson gson = new Gson();
		
		// 2. add Json key, value
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "jun");
		jsonObject.addProperty("id", 1);
		
		// 3. convert JsonObject to Json String array
		String jsonStr = gson.toJson(jsonObject);
		
		// 4. print Json String Array
		System.out.println(jsonStr);
		
		// 5. Student -> Json
		Student student = new Student(1, "junho");
		String studentJson = gson.toJson(student);
		System.out.println(studentJson);
		
		// 6. Json -> Student
		String jsonStr2 = "{\"id\":2,\"name\":\"kim\"}";
		Student student2 = gson.fromJson(jsonStr2, Student.class);
		System.out.println(student2);
	}

}

class Student {
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
