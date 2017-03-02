package kr.co.around.repository.vo;

public class MyFavoriteVO {
	
	private int mySeq;				// 관심글 고유번호 (시퀀스)
	private int userSeq;			// 관심글 작성자 시퀀스 (FK)
	private String myContent;		// 관심글 내용 (140글자)
	private String myHashtag;		// 관심글에 작성된 해시태그 ( #.. ; #.. ) ; 을 사용하여 구분
	private String myFeeling;		// 관심글 기분 (1:, 2:, 3:, 4:, 5: )
	private String myReg_Date;		// 관심글 등록 시각
	
	public int getMySeq() {
		return mySeq;
	}
	public void setMySeq(int mySeq) {
		this.mySeq = mySeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getMyContent() {
		return myContent;
	}
	public void setMyContent(String myContent) {
		this.myContent = myContent;
	}
	public String getMyHashtag() {
		return myHashtag;
	}
	public void setMyHashtag(String myHashtag) {
		this.myHashtag = myHashtag;
	}
	public String getMyFeeling() {
		return myFeeling;
	}
	public void setMyFeeling(String myFeeling) {
		this.myFeeling = myFeeling;
	}
	public String getMyReg_Date() {
		return myReg_Date;
	}
	public void setMyReg_Date(String myReg_Date) {
		this.myReg_Date = myReg_Date;
	}

}
