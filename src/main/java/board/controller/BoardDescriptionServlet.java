package board.controller;

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
import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class BoardDiscriptionServlet
 */
@WebServlet("/boardDescription")
public class BoardDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		HttpSession session = request.getSession(false);
		
		// board 정보 가져오기
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNum));
		
		BoardService service = new BoardService();
		Board result = service.getOneBoard(boardNum);
		

		CommentService commentService = new CommentService();
		List<Comment> comment = commentService.getAllComments(boardNum);
		if (comment!=null) {
			request.setAttribute("comment", comment);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardDescription.jsp");
		request.setAttribute("board", result); // 리퀘스트 객체에 내가 얻어온 게시글 내용을 잠시 저장해요!
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
