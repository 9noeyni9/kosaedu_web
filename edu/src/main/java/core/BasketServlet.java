package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		/*String pid = session.getAttribute("id");*/
		
		
		if(session.getAttribute("pid") == null) {
			session.setAttribute("pid", new int[10]);			
		}
		if(id == null) {
			session.invalidate();
			out.print("");
		}else {
		int[] count = (int[])session.getAttribute("pid");
		int i = Integer.parseInt(id.substring(1));		
		count[i-1]++;
		/* String jsons =""; */
		out.print("{\""+id+"\":\""+count[i-1]+"\"}");		
		out.close();
		}
		
		
		}		

}
