package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String memberId = ((Member) session.getAttribute("member")).getMemberId();
		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
		String boardNum = request.getParameter("boardNum");

		Comment comment = new Comment();
		comment.setCommentAuthor(memberId);
		comment.setCommentNum(commentNum);
		

		CommentService service = new CommentService();
		int result = service.deleteComment(comment);
		
		if(result==1) {
			// 댓글 삭제 성공
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardDescription");
			dispatcher.forward(request, response);
		} else {
			// 댓글 삭제 실패
			response.sendRedirect("deleteCommentFail");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
