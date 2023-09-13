package page;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list2.page")
public class ListPageServlet2 extends HttpServlet{	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pageSize=4;
		int grpSize = 5;
		String page = request.getParameter("p");
		int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		MemberDao2 dao = new MemberDao2();
		//dao.getListPage(currentPage, pageSize=4);
		ArrayList<Member> list = dao.getListPage(currentPage, pageSize);
		int totalCnt = dao.getTotalCnt();
		
		
		request.setAttribute("list", list);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", currentPage);
		request.setAttribute("grpSize", grpSize);

		
		request.getRequestDispatcher("WEB-INF/views/listPage2.jsp").forward(request, response);
		
	}

}
