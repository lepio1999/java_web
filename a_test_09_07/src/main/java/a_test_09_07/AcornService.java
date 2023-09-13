package a_test_09_07;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class AcornService {

	AcornDAO dao = new AcornDAO();

	public JSONArray getAcornList() {

		ArrayList<Acorn> list = new ArrayList<>();
		list.add(new Acorn("test", "0000", "name"));
		

		JSONArray arr = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Acorn a = list.get(i);
			JSONObject o = new JSONObject();
			o.put("id", a.getId());
			o.put("pw", a.getPw());
			o.put("name", a.getName());
			arr.put(o);
		}
		return arr;

	}
	
	public JSONArray getAcornRealList() {
		
		ArrayList<Acorn> list  = dao.getAcornList();
		JSONArray arr = new JSONArray();
		
		for(int i=0; i<list.size(); i++) {
			Acorn a =  list.get(i);
			JSONObject o = new JSONObject();
			o.put("id", a.getId());
			o.put("pw", a.getPw());
			o.put("name", a.getName());
			
			arr.put(o);
		}
		return arr;
	}

}
