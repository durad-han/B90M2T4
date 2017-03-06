package kr.co.around.repository.vo;

public class UserVO {
	
	private int userSeq;			// 유저 고유번호 (시퀀스)
	private String userId;			// 유저 아이디
	private String userPass;		// 유저 비밀번호 (널값 가능)
	private String userRegDate;		// 유저 가입일
	private String userKey;			// 유저 키 (카카오 로그인시 필요)
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

}
