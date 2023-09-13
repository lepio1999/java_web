package moviePrj_09_06;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieService {
	
	MovieDAO dao = new MovieDAO();
	
	public JSONArray getMovieList() {
		
		ArrayList<Movie>list = new ArrayList<>();
		list.add(new Movie("반지의 제왕 : 반지 원정대","1","2001"));
		list.add(new Movie("반지의 제왕: 두 개의 탑","2","2002"));
		list.add(new Movie("반지의 제왕: 왕의 귀환","3","2003"));
		
		JSONArray arr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			Movie m = list.get(i);
			JSONObject o = new JSONObject();
			o.put("name", m.getName());
			o.put("chart", m.getChart());
			o.put("year", m.getYear());
			
			arr.put(o);
		}
		return arr;

	}
	
public JSONArray getMovieRealList() {
		/*
		ArrayList<movie>list = new ArrayList<>();
		list.add(new movie("반지의 제왕 : 반지 원정대","1","2001"));
		list.add(new movie("반지의 제왕: 두 개의 탑","2","2002"));
		list.add(new movie("반지의 제왕: 왕의 귀환","3","2003"));
		*/
		
		ArrayList<Movie> list = dao.getMovieList();
		JSONArray arr = new JSONArray();
		
		for(int i=0; i<list.size(); i++) {
			Movie m = list.get(i);
			JSONObject o = new JSONObject();
			o.put("name", m.getName());
			o.put("chart", m.getChart());
			o.put("year", m.getYear());
			
			arr.put(o);
		}
		return arr;

	}

}
