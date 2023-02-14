package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateMember.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member sessionMember = (Member)session.getAttribute("member");
		
		String memberName = request.getParameter("memberName");
		String memberPw1 = request.getParameter("memberPw1");
		String memberPw2 = request.getParameter("memberPw2");
		String memberId = sessionMember.getMemberId();
			// 비밀번호가 일치하지 않습니다. 
		    
			// 비밀번호가 일치할 경우 회원정보 수정 로직 실행
			// Member 만들어주기
			Member member = new Member();
			member.setMemberName(memberName);
			member.setMemberPw(memberPw1);
			member.setMemberId(memberId);
			
			MemberService service = new MemberService();
			// // // 여기서 뭔가 오류가 있는것 같아요!!! 회원정보가 수정되지 않ㅇ아요!
			int result = service.updateMember(member);
			if (result == 1) {
//				response.sendRedirect("updateMemberSuccess");
				
				// 게시글 페이지
				RequestDispatcher dispatcher = request.getRequestDispatcher("updateMemberSuccess.jsp");
				dispatcher.forward(request, response);
			} else {
				// 업데이트가 실패하면 실행
				response.sendRedirect("updateMemberFail");
			}
	}

}
