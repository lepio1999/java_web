package prj0828;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		//사용자(클라이언트)정보추출
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		//비즈니스 로직
		boolean result = true;
		
		//응답 정상적인 로그인, 아이디, 비번이 잘못된 경우
		if(result) { //정상적인 아이디, 비번
			out.println(userid +"정상 로그인 환영합니다.!!");
		}else {
			out.println("아이디비번 확인하세요.!!");
			
		}
		out.close();
	}

}
