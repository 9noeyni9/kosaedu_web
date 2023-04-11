package core;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet 수행");
		RequestDispatcher rd = 
				request.getRequestDispatcher("/clientexam/output.html");//"/edu/clientexam/output.html": 에러 경로 에러..?동일한 web-application에서만 적용하려고 경로를 무조건 /edu를 붙임 그래서 /edu를 붙이면 한번더 경로 설정이 되는 것
		/*RequestDispatcher rd = 
				request.getRequestDispatcher("http://www.naver.com/");*/
		rd.forward(request,  response);
	}//개발자도구 network 확인해보면 다시 요청해도 요청이 한번만 이뤄진 걸로 보임 클라이언트가 모르게 함
}







