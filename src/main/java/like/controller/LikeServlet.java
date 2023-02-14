package like.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import member.vo.Member;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		Member member = new Member();
		member.setMemberId("testId");
		member.setMemberName("testName");
		String userAsString = objectMapper.writeValueAsString(member);
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");//전송타입 지정
        PrintWriter out =response.getWriter();
        out.print(userAsString);
        out.flush();//내부 버퍼의 내용을 파일에 writer, 호출하지 않으면 내용이 버퍼에만 남고 파일에 안 쓰일 수 있다.
        out.close();//스
	}

}
