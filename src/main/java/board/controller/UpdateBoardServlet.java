package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.vo.Member;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		
		BoardService service = new BoardService();
		Board board = service.getOneBoard(boardNum);
		
		HttpSession session = request.getSession(false);
		String member = ((Member)session.getAttribute("member")).getMemberId();
		
		
		// JSP로 전달해주기 위한 임시 보관
		request.setAttribute("board", board);
		request.setAttribute("member", member);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateBoardForm.jsp");
		dispatcher.forward(request, response);
		
//		updateBoardForm
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		String boardAuthor = ((Member)session.getAttribute("member")).getMemberId();
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardNum(boardNum);
		board.setBoardAuthor(boardAuthor);
//		 board 쿼리 수정
		BoardService service = new BoardService();
		int result = service.updateBoard(board);
		
		if(result==1) {
			// 게시글 수정 성공 
			System.out.println("성공");
//			이렇게 사용하는게 아니에요
//			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardDescriptionServlet");

			
//			이것도 새로운 페이지로 전환이 안됩니다.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardDescription");
			dispatcher.forward(request, response);

//			redirect 사용하기: request, response객체 못보내서 오류나는듯?  
//			response.sendRedirect("boardDescription");
			
//			요건 가능한데 좋은 방법이 아님
//			BoardDescriptionServlet servlet = new BoardDescriptionServlet();
//			servlet.doGet(request, response);
		} else {
			// 게시글 수정 실패
			System.out.println("실패");
			response.sendRedirect("updateBoardFail.html");
		}
		
	}

}
