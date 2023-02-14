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
 * Servlet implementation class CreateCommentServlet
 */
@WebServlet("/createComment")
public class CreateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCommentServlet() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String commentContent = request.getParameter("commentContent");
		String commentAuthor = ((Member)session.getAttribute("member")).getMemberId();
		String boardNum = request.getParameter("boardNum");
		
		Comment comment = new Comment();
		comment.setCommentContent(commentContent);
		comment.setCommentAuthor(commentAuthor);
		comment.setBoardNum(boardNum);
		CommentService service = new CommentService();
		int result = service.createComment(comment);
		
		if(result ==1) {
			// 정상적으로 댓글이 생성되었습니다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardDescription");
			dispatcher.forward(request, response);
		} else {
			// 댓글 작성에 실패하였습니다.
			response.sendRedirect("createCommentFail.html");
		}
	}

}
