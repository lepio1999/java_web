package burger;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menuList")
public class MenuServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	HttpSession session =req.getSession();
		
		MenuService menu = new MenuService();
		
		ArrayList<Burger> list = (ArrayList<Burger>) menu.getMenus();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/menuList.jsp").forward(req, resp);
		
	}
}
