package test.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserExam {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();

		JSONObject root = (JSONObject) parser.parse(new FileReader("src/main/java/test/json/myjson2.json"));

		String name = (String) root.get("name");
		String age = (String) root.get("age");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("=========================================");
		JSONArray subjectlist = (JSONArray) root.get("subject");
		for (int i = 0; i < subjectlist.size(); i++) {
			String subject = (String) subjectlist.get(i);
			System.out.println("subject: " + subject);
		}
		System.out.println("=========================================");
		JSONArray historyist = (JSONArray) root.get("history");
		for (int i = 0; i < historyist.size(); i++) {
			JSONObject history = (JSONObject) historyist.get(i);
			System.out.println("month: " + history.get("month"));
			System.out.println("subject: " + history.get("subject"));
		}
		System.out.println("=========================================");
		JSONObject addrlist = (JSONObject) root.get("addr");
        String zip = (String) addrlist.get("zip");
        String addr1 = (String) addrlist.get("addr1");
        System.out.println("zip: " + zip);
        System.out.println("addr1: " + addr1);
	}

}
