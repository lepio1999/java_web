package coffee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list4.page")

public class ListPageServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String p = req.getParameter("p");
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		
		CoffeeDao dao = new CoffeeDao();
		int totRecords = dao.getTotalCnt();
		int pageSize = 5;
		int grpSize = 3;
		
		PageHandler handler = new PageHandler(currentPage, totRecords, pageSize, grpSize);
		ArrayList<Coffee>list  = dao.getListPage(currentPage, pageSize);
		
		req.setAttribute("list", list);
		req.setAttribute("handler", handler);
		
		req.getRequestDispatcher("WEB-INF/views2/listPage.jsp").forward(req, resp);
	}
	public static void main(String[] args) {
		PageHandler h = new PageHandler(6, 33, 4, 5);
		
		System.out.println(h.getTotalPage());
		System.out.println(h.getCurrentGrp());
		System.out.println(h.getGrpStartPage());
		System.out.println(h.getGrpEndPage());
	}

}
