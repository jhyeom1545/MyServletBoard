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
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("createBoard.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String boardAuthor = ((Member)session.getAttribute("member")).getMemberId(); // 확인
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardAuthor(boardAuthor);
		board.setBoardLike(0);
		
		System.out.println(board);
		BoardService boardService = new BoardService();
		int result = boardService.createBoard(board);
		if (result == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("createBoardSuccess.jsp");
			dispatcher.forward(request,  response);	
		} else {
			response.sendRedirect("createBoardFail.html");
		}
			
	}

}
