package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")//매핑패스
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int local_v = 0;
		member_v++;//메모리할당을 유지하고 있기 때문에 계속 수행
		local_v++;//스레드별로 요청시 할당(메모리 유지하고 싶으면 멤버변수 사용해야해)
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}
}
//http://localhost:8088/edu/memberlocal
//클라이언트별로 데이터 유지하고 싶으면 session에 보관해야함