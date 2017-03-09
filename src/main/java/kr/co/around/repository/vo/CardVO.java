package kr.co.around.repository.vo;

public class CardVO {

	private int cardSeq;				// 카드 고유번호 (시퀀스)
	private int userSeq;				// 카드 작성자 시퀀스 (FK)
	private String cardContent;			// 카드 내용 (140글자)
	private String cardFeeling;			// 카드 기분 (1:, 2:, 3:, 4:, 5: )
	private String cardHashtag;			// 카드에 작성된 해시태그 ( #.. #.. ) " " 사용하여 구분
	private double cardLongitude;		// 카드 마커 경도값
	private double cardLatitude;		// 카드 마커 위도값
	private String cardImgPath;			// 카드 배경 이미지 주소값
	private String cardRegDate;			// 카드 등록 시각
	private double distance;
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getCardSeq() {
		return cardSeq;
	}
	public void setCardSeq(int cardSeq) {
		this.cardSeq = cardSeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getCardContent() {
		return cardContent;
	}
	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}
	public String getCardFeeling() {
		return cardFeeling;
	}
	public void setCardFeeling(String cardFeeling) {
		this.cardFeeling = cardFeeling;
	}
	public String getCardHashtag() {
		return cardHashtag;
	}
	public void setCardHashtag(String cardHashtag) {
		this.cardHashtag = cardHashtag;
	}
	public String getCardImgPath() {
		return cardImgPath;
	}
	public void setCardImgPath(String cardImgPath) {
		this.cardImgPath = cardImgPath;
	}
	public String getCardRegDate() {
		return cardRegDate;
	}
	public void setCardRegDate(String cardRegDate) {
		this.cardRegDate = cardRegDate;
	}
	public double getCardLongitude() {
		return cardLongitude;
	}
	public void setCardLongitude(double cardLongitude) {
		this.cardLongitude = cardLongitude;
	}
	public double getCardLatitude() {
		return cardLatitude;
	}
	public void setCardLatitude(double cardLatitude) {
		this.cardLatitude = cardLatitude;
	}

	
}
