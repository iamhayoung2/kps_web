package model.domain;

public class CoinPredBean {
	private int timeStamp;
	private float priminum;

	public CoinPredBean() {};
	public CoinPredBean(int timeStamp, float priminum) {
		super();
		this.timeStamp = timeStamp;
		this.priminum = priminum;
	}
	
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	public float getPriminum() {
		return priminum;
	}
	public void setPriminum(float priminum) {
		this.priminum = priminum;
	}
	
	@Override
	public String toString() {
		return "Coin [timeStamp=" + timeStamp + ", priminum=" + priminum + "]";
	}
}
