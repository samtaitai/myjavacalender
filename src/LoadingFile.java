
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LoadingFile {

	private JSONObject jsonObj;
	
	public JSONObject loadFile(File yourFile) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		try {
			jsonObj = (JSONObject) jsonParser.parse(new FileReader(yourFile));
		} catch (FileNotFoundException e) {
			System.out.println("Read file error!");
			e.printStackTrace();
		}
		
		return jsonObj;
		
	}
	
}
