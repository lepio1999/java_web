package cartprj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session =  req.getSession();
		
		ArrayList<String> list = (ArrayList<String>)  session.getAttribute("cartList");
		
		System.out.println( list);
		
		req.setAttribute("cartList", list);
		req.getRequestDispatcher("WEB-INF/views/cartList.jsp").forward(req, resp);
		
		
	}

}
