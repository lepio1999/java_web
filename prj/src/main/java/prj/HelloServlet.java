package prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HelloServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html/charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter  out = resp.getWriter();
		String name = req.getParameter("name");
		
		if(name == null) {
			out.println("guest hi");
		}else {
			out.println(name+"hi");
		}
		out.close();
	}

}
