package kr.co.around.repository.vo;

public class HashtagVO {
	
	private int hashtagSeq;				// 해시태그 고유번호 (시퀀스)
	private String hashtagContent;		// 해시태그 내용 (30글자)
	private int hashtagFrequency;		// 해시태그 사용 빈도수 (기본값 1)
	
	public int getHashtagSeq() {
		return hashtagSeq;
	}
	public void setHashtagSeq(int hashtagSeq) {
		this.hashtagSeq = hashtagSeq;
	}
	public String getHashtagContent() {
		return hashtagContent;
	}
	public void setHashtagContent(String hashtagContent) {
		this.hashtagContent = hashtagContent;
	}
	public int getHashtagFrequency() {
		return hashtagFrequency;
	}
	public void setHashtagFrequency(int hashtagFrequency) {
		this.hashtagFrequency = hashtagFrequency;
	}

}
