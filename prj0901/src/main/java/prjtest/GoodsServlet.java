package prjtest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goods")

public class GoodsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GoodsService s = new GoodsService();
		ArrayList<String>list = s.getMenuList();
		System.out.println(list);
		
		req.setAttribute("list", resp);
		req.getRequestDispatcher("WEB-INF/views2/goods.jsp");
	}

}
