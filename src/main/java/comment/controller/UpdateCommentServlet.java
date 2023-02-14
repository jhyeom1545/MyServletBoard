package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updateComment")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String commentNum = request.getParameter("commentNum");
		String boardNum = request.getParameter("boardNum");
		System.out.println("boardNum: "+boardNum);
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		CommentService commentService = new CommentService();
		Comment comment = commentService.getOneComment(commentNum);
		System.out.println(comment);
		if(!comment.getCommentAuthor().equals(memberId)) {
			response.sendRedirect("updateCommmentFail.html");
		}
		
		request.setAttribute("comment", comment);
		request.setAttribute("boardNum", boardNum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateCommentForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 멤버 아이디
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		// 댓글 번호
		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
		
		// 댓글 내용
		String commentContent = request.getParameter("commentContent");
		
		// VO에 넣기
		Comment comment = new Comment();
		comment.setCommentNum(commentNum);
		comment.setCommentContent(commentContent);
		comment.setCommentAuthor(memberId);

		// 서비스 실행
		CommentService commentService = new CommentService();
		int result = commentService.updateComment(comment);
		
		if(result ==1 ) {
			// 실행 성공하면 새로고침
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardDescription");
			dispatcher.forward(request, response);
			
		} else {
			// 실행 실패하면 html 반환
			response.sendRedirect("updateCommentFail.html");
		}
	}

}
