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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getSession(false);
		request.getSession(false);
		// 게시글 가져오기
		List<Board> list = null;
		BoardService boardService = new BoardService();
		list = boardService.getAllBoard();
		// 게시글 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
		request.setAttribute("boardList", list); // 리퀘스트 객체에 내가 얻어온 게시글 내용을 잠시 저장해요!
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet은 MVC(Model-View-Controller) pattern에서 Controller역할을 해요

		// Model (2가지가 있어요)
		// 1. Data Model : 우리가 사용하는 Data를 관리해요 (관리하기 위해 VO를 만들어요)
		// 2. Business Logic Model : Service Class가 이 역할을 담당해요!
		// - 데이터베이스 처리가 들어올 수 있어요!! 이 데이터베이스 처리는 DAO가 담당해요!

		// View : HTML, JSP, View
		// Controller: View와 Model을 연결해주는 역할을 해요! => Servlet이 그 역할을 담당해요!
		// View로부터 사용자 데이터를 받아서 Model(Service)에게 전달해서 로직처리시키고
		// 로직 처리된 결과를 Model(Service)로부터 받아와요!
		// 그 결과를 보고 특정 View를 선택(HTML, JSP)해서 그 View를 클라이언트에게 전달하도록 시켜요!

		// 1. 입력받고
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");

		// 입력받은 Data로 VO를 생성해요!
		// 데이터베이스 테이블을 기준으로 VO를 생성해야 하니... 당연히 Table이 있어야 해요!
		// Table을 생성한 후 VO를 만들고 데이터를 세팅해서 Service에게 넘겨줄 준비를 했어요!
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);

		// 2. 로직처리하고
		// 로직처리를 하기 위해 Service객체를 생성해야 해요!
		MemberService service = new MemberService();
		// 객체가 생성되었으면 일을 시켜욧!
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고와요!
		// 만약 로그인이 실패하면 null을 리턴받을 꺼에요!
		Member result = service.login(member); // 비지니스 로직
		List<Board> list = null;
		if (result != null) {
			BoardService boardService = new BoardService();
			list = boardService.getAllBoard();

		}

		// 3. 출력 처리해요!
		if (result != null) {
			// 로그인에 성공했어요!
			// 로그인에 성공한 흔적을 남겨놔야 해요! (Session에 남겨놓으면 될것 같아요!)
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result); // vo 자체를 저장해요!
			// 게시판 HTML페이지를 클라이언트에게 전송해요(JSP)
			// JSP는 그 실체가 Servlet이에요
			// html -> servlet => service => dao =>
			// service => controller => jsp(servlet) => client
			// 게시판 HTML 페이지를 페이지를 Client에게 전송해요! (JSP로 전송할꺼에요)
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list); // 리퀘스트 객체에 내가 얻어온 게시글 내용을 잠시 저장해요!
			// 세션안에는 지속적으로 저장해야할 필요성이 있는 데이터를 저장하고,
			// JSP에 잠깐 주기 위해 필요한 데이터는 request에 붙어요!
			dispatcher.forward(request, response);
		} else {
			// 로그인에 실패했어요!
			// 오류 HTML page를 Client에게 전송해요!(HTML로 전송할꺼에요)
			response.sendRedirect("loginFail.html");
		}
	}

}
