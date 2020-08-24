
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		JSONObject j = new JSONObject();
		
		j.put("age", 10);
		j.put("name", "anuj");
		
		JSONArray preview = new JSONArray();
		preview.add("student");
		preview.add("ta");
		preview.add("cook");
		
		j.put("job", preview);
		
		String filename = "AnujJSON";
		
		try(FileWriter file = new FileWriter(filename))
		{
			file.write(j.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(j);
		
		
	
	}
}
