package comment.vo;

public class Comment {

	private int commentNum;
	private String commentContent;
	private String commentDate;
	private String commentAuthor;
	private String boardNum;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentNum, String commentContent, String commentDate, String commentAuthor, String boardNum) {
		super();
		this.commentNum = commentNum;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentAuthor = commentAuthor;
		this.boardNum = boardNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	public String getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", commentAuthor=" + commentAuthor + "]";
	}
	
	
}
