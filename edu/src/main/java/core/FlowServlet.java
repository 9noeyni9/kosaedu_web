package core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/flow")
public class FlowServlet extends HttpServlet {//서블릿의 수행 흐름
	private static final long serialVersionUID = 1L;
    public FlowServlet() {//생성자 구현(최초 요청시 객체 생성)
        super();
        System.out.println("FlowServlet 객체 생성....");
    }
    
//    이 밑에 세개 다 콜백 함수
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드 호출....");
	}//최초수행
	public void destroy() {//서블릿 객체가 메모리에서 사라질 때 자동 리로드 수행시 or 프로그램 종료시
		System.out.println("destroy() 메서드 호출....");
	}//마지막 한번만 수행
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메서드 호출....");
	}//클라이언트가 요청마다 수행할 내용은 service에 담아야함(오버라이딩),또는 doGet사용

}