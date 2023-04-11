package core;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet 수행");
		response.sendRedirect("/edu/clientexam/output.html");///forward랑 다르게 contextpath(/edu)먼저 주고 시작,응답헤더 : key-value로 옴 브라우저는 다시 요청하게 됨
		//response.sendRedirect("http://www.naver.com/");
	}
}







