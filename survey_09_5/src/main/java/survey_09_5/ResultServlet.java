package survey_09_5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class ResultServlet  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String animal = (String)session.getAttribute("animal");
		String flower = req.getParameter("flower");
		//데이터 심기
		
		//좋아하는 동물정보

		//좋아하는 꽃정보
		req.setAttribute("flower", flower);
		req.setAttribute("animal", animal);
		req.getRequestDispatcher("WEB-INF/views/result.jsp").forward(req, resp);
	}
}
