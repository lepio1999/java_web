package prjtest;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoodsService {
	GoodsDAO dao = new GoodsDAO();
	public ArrayList<String> getMenuList(){
		ArrayList<String> list = new ArrayList<>();
		
		list.add("아메리카노");
		list.add("바닐라라떼");
		list.add("카라멜마키야또");
		
		return list;
	}
	
	public ArrayList<String>getMenuRealList(){
		ArrayList<String>list = dao.selectAll();
		return list;
	}
	
	public void registerMenu(Menu m) {
		dao.insertMenu3(m);
	}
	
	public void deletMember(String id) {
		dao.deletOne(id);
	}
	

	
	
	
}
