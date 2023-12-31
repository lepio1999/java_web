package prjtest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class GoodsServletReg extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		
		GoodsService s = new GoodsService();
		s.registerMenu(new Menu(id,name,price));
		
		req.getRequestDispatcher("WEB-INF/views/ok.jsp");
		
		
	}

}
