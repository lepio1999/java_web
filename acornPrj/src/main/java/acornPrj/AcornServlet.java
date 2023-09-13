package acornPrj;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/acornList")
public class AcornServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	HttpSession session =req.getSession();
		
		AcornService menu = new AcornService();
		
		ArrayList<Acorn> list = (ArrayList<Acorn>) menu.getAcorns();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/AcornList.jsp").forward(req, resp);
		
	}
}
