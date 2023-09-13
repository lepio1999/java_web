package ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el1")
public class El1 extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String[] food = {"떡볶이","김밥","라면"}; 
		 
		req.setAttribute("food",food);
		String[] bookNames = { "소설" , "역사" , "인문", "정치" , "미술" ,"종교","여행", "과학"} ;
		req.setAttribute("book", bookNames);
		
		ArrayList<Coffe> coffes = new ArrayList<>();
		coffes.add(new Coffe("c001","아메리카노","2000"));
		coffes.add(new Coffe("c002","카페라떼","1000"));
		coffes.add(new Coffe("c003","카푸치노","3000"));
		
		req.setAttribute("coffes", coffes);
		
		//HttpServlet session =  req.getSession();
		//session.setAttribute("id", "acorn01");
		
		HttpSession session = req.getSession() ;
		session.setAttribute("id", "acorn");
		
				
		req.getRequestDispatcher("WEB-INF/views/el1.jsp").forward(req, resp);
		
	
	}
}
