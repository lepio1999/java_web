package prj0828;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

//서블릿의 시작은 service 매서드이다

@WebServlet("/hi")
public class SecondServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("secount servlet");
		PrintWriter out =resp.getWriter();
		out.print("hi Secound servlet!!!!!!!!!");
	}
}
