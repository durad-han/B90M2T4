package kr.co.around.repository.vo;

public class SearchVO extends PageVO {
	
	private int cardSeq;
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
	

}
