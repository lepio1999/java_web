package burger;
import java.util.ArrayList;

public class MenuService {
	
	
	menuDAO dao = new menuDAO();
	
	public ArrayList<Burger> getMenus(){
		
		ArrayList<Burger> list = dao.selectAll();
		
		
		return list;
	}
	

}
