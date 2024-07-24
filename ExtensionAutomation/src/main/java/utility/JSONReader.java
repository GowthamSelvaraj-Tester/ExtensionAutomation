package utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import constants.FrameWorkConstants;

public class JSONReader {
	
	private static JSONObject jsonobject;
	
	static {
		try {
			String filePath = FrameWorkConstants.JSON_PATH;
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			jsonobject = new JSONObject(content);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return jsonobject.optString(key,null);	
	}
	
	public static Map<String,String> getAllData(){
		Map<String, String> dataMap = new HashMap<>();
        for (String key : jsonobject.keySet()) {
            dataMap.put(key, jsonobject.optString(key, null));
        }
        return dataMap;
	}
}
