package page;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3.page")
public class ListPageServlet3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String p = request.getParameter("p");
		int currentPage =1;
		if (p != null) {
			currentPage = Integer.parseInt(p);
		}

		MemberDao2 dao = new MemberDao2();
		int totRecords = dao.getTotalCnt();
		int pageSize = 2;
		int grpSize = 4;
		// 페이징을 위한 값들
		PageHandler handler  = new PageHandler(currentPage, totRecords, pageSize, grpSize);
		ArrayList<Member> list = dao.getListPage(currentPage, pageSize);
		// 현재페이지에 대한 목록 list
		
		request.setAttribute("list", list);
		request.setAttribute("handler", handler);
		
		request.getRequestDispatcher("WEB-INF/views/listPage3.jsp").forward(request, response);
	}
	public static void main(String[] args) {
		PageHandler h = new PageHandler(6, 33, 4, 5);
		
		System.out.println( h.getTotalPage()); //9
		System.out.println( h.getCurrentGrp()); //2
		System.out.println( h.getGrpStartPage()); //6
		System.out.println( h.getGrpEndPage()); //9
		
	}

}
