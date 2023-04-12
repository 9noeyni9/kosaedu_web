package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/getHTML", "/getXML", "/getJSON", "/getImage" })
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();//URI만 추출 /서버주소 포트번호 뺀 이후
		System.out.println(uri);
		String filename = "";
		String contentType = "";
		if (uri.endsWith("getHTML")) {//endWith: 뭘로 끝나는지
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.html";	
			contentType = "text/html; charset=utf-8";
		} else if (uri.endsWith("getXML")) {
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.xml";	
			contentType = "text/xml; charset=utf-8";
		} else if (uri.endsWith("getJSON")) {
			filename = getServletContext().getRealPath("/")+"/clientexam/sample.json";	
			contentType = "text/json; charset=utf-8";//"application/json"					
		} else {
			filename = getServletContext().getRealPath("/")+"/images/trans_duke.png";	
			contentType = "image/png";
		}
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);//FileInputStream 객체 생성
		response.setContentType(contentType);
		if(contentType.startsWith("image")) {
			byte[] content = new byte[(int)f.length()];//파일 사이즈 배열 만듬(바이너리 형식-바이트 형식 사용)
			ServletOutputStream sos = response.getOutputStream();//response.getOutputStream 사용
			fis.read(content);//이미지 파일 사이즈만큼 읽어서 
			sos.write(content);//작성			
			sos.close();
		} else {
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			PrintWriter out = response.getWriter();
			String line = null; 
			while((line = br.readLine()) != null) 
				out.println(line);
			out.close();
			br.close();
			isr.close();			
		}		
		fis.close();
	}
}
