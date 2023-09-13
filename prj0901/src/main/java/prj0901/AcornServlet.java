package prj0901;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acorn")
public class AcornServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Model
		//
		AcornService s = new AcornService();
		 //ArrayList<String> list = s.getMemberList();
		 ArrayList<String> list = s.getmemverRealList();
		System.out.println(list);
		
		
		//model 심기
		 request.setAttribute("list", response);
		 request.getRequestDispatcher("WEB-INF/views/acorn.jsp").forward(request, response);
	}
}
