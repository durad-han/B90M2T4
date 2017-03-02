package kr.co.around.repository.vo;

public class ImgVO {
	
	private int imgSeq;			// 이미지 고유번호 (시퀀스)
	private String imgPath;		// 이미지 저장 경로
	
	public int getImgSeq() {
		return imgSeq;
	}
	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
