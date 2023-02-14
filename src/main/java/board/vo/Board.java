package board.vo;


public class Board {
	private int boardNum;
    private String boardTitle;  
    private String boardContent; 
    private String boardAuthor;
    private String boardDate; 
    private int boardLike;
    private int commentCount;
	
    public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, String boardTitle, String boardContent, String boardAuthor, String boardDate,
			int boardLike, int commentCount) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardAuthor = boardAuthor;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
		this.commentCount = commentCount;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardAuthor=" + boardAuthor + ", boardDate=" + boardDate + ", boardLike=" + boardLike
				+ ", commentCount=" + commentCount + "]";
	}

    
}
