package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//post방식 한글처리 필수
		PrintWriter out= response.getWriter();
		String name = request.getParameter("name");
		String memo = request.getParameter("memo");
		LocalDate now = LocalDate.now();//유저마다 등록일이 다르기 때문에 static처럼 고정된 날 또는 멤버변수 (객체 생성시 한번만 메모리 할당되기 떄문에)로 정하면 안돼!!
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		out.print("<h2>"+name+"님이"+now.format(formatter)+"에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print(memo+"<br>");
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		out.close();
	}
}