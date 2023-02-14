package like.vo;

public class Like {
	private int likeNum;
	private int boardNum;
	private String memberId;
	private String likeDeleted;
	private String likeDate;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int likeNum, int boardNum, String memberId, String likeDeleted, String likeDate) {
		super();
		this.likeNum = likeNum;
		this.boardNum = boardNum;
		this.memberId = memberId;
		this.likeDeleted = likeDeleted;
		this.likeDate = likeDate;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLikeDeleted() {
		return likeDeleted;
	}

	public void setLikeDeleted(String likeDeleted) {
		this.likeDeleted = likeDeleted;
	}

	public String getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}

}
