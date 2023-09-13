package prj0831;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/himvc")
public class HelloMVCServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//입력정보 추출
		
		//모델: 데이터를 만드는 일
		
		//응답 view 처리흐름을 forword 시킨다
		
		RequestDispatcher r=req.getRequestDispatcher("WEB-INF/views/helloView.jsp");
		r.forward(req, resp);
		
	}
}
