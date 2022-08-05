import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class JsonDemo {
	
	@SuppressWarnings("unchecked")
	public void writeJson() throws IOException {
		
		File jsonFile = new File("test.json"); //file instance with a name
		boolean flag = jsonFile.createNewFile(); //create file(method); one file, one name
		
		if(flag) {
			System.out.println("test.json is created.");
		}else {
			System.out.println("test.json already presents.");
		}
		
		FileWriter writer = new FileWriter(jsonFile);
		
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name1", "foo");
			jsonObject.put("name2", "voo");
			jsonObject.put("name3", "koo");
			//System.out.println(jsonObject);
			
			writer.write(jsonObject.toJSONString());
			writer.close();
			System.out.println("Success");
		
		}catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}		
		
	}
	
	public void readJson() throws ParseException {
		
		File jsonFile = new File("test.json");
		try {
			
			Scanner fileReader = new Scanner(jsonFile);
			String data = "";
			
			while(fileReader.hasNext()) {
				data += fileReader.nextLine();
				
			}
			
			Object obj = new JSONParser().parse(data); 
			JSONObject openedJson = (JSONObject) obj;
			
			String value = (String) openedJson.get("name1");
			String value2 = (String) openedJson.get("name2");
			String value3 = (String) openedJson.get("name3");
			System.out.println(value);
			System.out.println(value2);
			System.out.println(value3);
			
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File load error.");
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		JsonDemo jd = new JsonDemo();
		
		try {
			jd.writeJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jd.readJson();
		
	}
}
