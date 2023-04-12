package core;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]);//유지하게될 상태session객체 안에 상태정보 보관 한번만 세션객체에 등록하면 돼 그 후에 
			
		}
		int[] count = (int[])session.getAttribute("cnt");//형변환*******
		count[0]++;
		out.print("<h3>당신은 "+ count[0] + 
				                       "번째 방문입니다.</h3>");		
		out.close();
	}
}
//유지하고 싶은 데이터가 숫자면 int형은 안되고 integer 는 가능 새롭게 만들 때마다 생김



