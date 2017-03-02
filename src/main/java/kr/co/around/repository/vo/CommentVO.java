package kr.co.around.repository.vo;

public class CommentVO {
	
	private int commentSeq;				// 댓글 고유번호 (시퀀스)
	private int userSeq;				// 댓글 작성자 시퀀스 (FK)
	private int cardSeq;				// 댓글이 달린 카드 시퀀스 (FK)
	private String commentContent;		// 댓글 내용 (140글자)
	private String commentImgPath;		// 댓글 배경 이미지 주소값
	private String commentRegDate;		// 댓글 등록 시각
	
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getCardSeq() {
		return cardSeq;
	}
	public void setCardSeq(int cardSeq) {
		this.cardSeq = cardSeq;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentImgPath() {
		return commentImgPath;
	}
	public void setCommentImgPath(String commentImgPath) {
		this.commentImgPath = commentImgPath;
	}
	public String getCommentRegDate() {
		return commentRegDate;
	}
	public void setCommentRegDate(String commentRegDate) {
		this.commentRegDate = commentRegDate;
	}
	
}
