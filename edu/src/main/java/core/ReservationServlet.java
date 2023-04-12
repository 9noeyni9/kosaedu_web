package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String room = request.getParameter("room");
		String requirements[] = request.getParameterValues("requirements");
		String date = request.getParameter("date");
		String[] arr = date.split("[-]");
		
		if(name=="") {//console 에러 이유 : forward 
			RequestDispatcher rd = 
					request.getRequestDispatcher("/first.html");			
			rd.forward(request,  response);
			return;
		}
		if(passwd =="") {//pw.equals("")
			response.sendRedirect("https://www.daum.net/");//500에러 이유: sendRedirect : return문이 없으면 밑에는 의미가 없지만 수행하게됨
			return;//더 밑으로 내려가지 못 하게 return해주는 것
		}
		
		out.print("<h1>"+name+"님의 예약내용</h1>");
		out.print("<hr>");
		out.print("<ul> 룸 : " + room+ "</ul>");
		
		if(requirements != null && requirements.length != 0) {
			out.print("<ul> 추가 요청 사항 : ");
			int count =0;
			for(String req : requirements) {
				out.print(req);
				if(count<requirements.length-1)
				out.print(", ");
				count++;
			}
			out.print("</ul>");
		}else {
			out.print("<ul> 추가 요청 사항 : 없음</ul>");
		}

		out.print("<ul> 예약날짜 : "+ arr[0]+"년 "+arr[1]+"월 "+arr[2]+"일" + "</ul>");
		
		
		out.print("<a href='"+request.getHeader("referer")+"'>예약입력화면으로</a>");
		
		
		out.close();
		
	}
	
}
