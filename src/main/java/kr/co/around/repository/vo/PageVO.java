package kr.co.around.repository.vo;

public class PageVO {
	private int pageNo = 1;

	public int getBegin() {
		return (pageNo -1) * 3 + 1;
	}
	public int getEnd() {
		return pageNo * 3;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
