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
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int boardNum =  Integer.parseInt(request.getParameter("boardNum")); 
		String boardAuthor = ((Member)session.getAttribute("member")).getMemberId();
		
		Board board = new Board();
		board.setBoardAuthor(boardAuthor);
		board.setBoardNum(boardNum);
		
		BoardService boardService = new BoardService();
		int result = boardService.deleteBoard(board);
		if(result==1) {
			// 게시글 삭제 성공
			System.out.println("성공");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login");
			// 이 전에 있던 요청대로 들어가요
			request.setAttribute("boardNum", boardNum);
			dispatcher.forward(request, response);
		} 
		if(result!=1){
			// 게시글 삭제 실패
			response.sendRedirect("deleteBoardFail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
