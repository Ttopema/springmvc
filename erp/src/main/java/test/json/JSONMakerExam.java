package test.json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONMakerExam {
    public static void main(String[] args) throws IOException {
        JSONObject myjson = new JSONObject();
        myjson.put("name","김서연");
        myjson.put("age","25");

        JSONArray subjectlist = new JSONArray();
        subjectlist.add("자바");
        subjectlist.add("하둡");
        subjectlist.add("시큐어코딩");
        myjson.put("subject", subjectlist);

        JSONObject addr = new JSONObject();
        addr.put("zip","111-222");
        addr.put("addr1","인천시");
        myjson.put("addr", addr);

        JSONArray historyList = new JSONArray();

        JSONObject history1 = new JSONObject();
        history1.put("subject","java");
        history1.put("month","11");
        historyList.add(history1);

        JSONObject history2 = new JSONObject();
        history2.put("subject","servlet");
        history2.put("month","12");
        historyList.add(history2);

        myjson.put("history", historyList);
        System.out.println(myjson.toJSONString());

        // Json파일을 생성 - 파일io
        FileWriter fw = new FileWriter("src/main/java/test/json/myjson2.json");
        fw.write(myjson.toJSONString());
        fw.flush();
        fw.close();
    }
}