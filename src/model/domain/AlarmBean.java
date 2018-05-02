package model.domain;

public class AlarmBean {
	private int alarmNo;
	private int coinNo;
	private float percent;
	private int contactNo;
	private int memberNo;
	
	public AlarmBean() {}
	
	public AlarmBean(int alarmNo, int coinNo, float percent, int contactNo, int memberNo) {
		super();
		this.alarmNo = alarmNo;
		this.coinNo = coinNo;
		this.percent = percent;
		this.contactNo = contactNo;
		this.memberNo = memberNo;
	}
	public AlarmBean(int coinNo, float percent, int contactNo, int memberNo) {
		super();
		this.coinNo = coinNo;
		this.percent = percent;
		this.contactNo = contactNo;
		this.memberNo = memberNo;
	}

	public int getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}

	public int getCoinNo() {
		return coinNo;
	}

	public void setCoinNo(int coinNo) {
		this.coinNo = coinNo;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "AlarmBean [alarmNo=" + alarmNo + ", coinNo=" + coinNo + ", percent=" + percent + ", contactNo="
				+ contactNo + ", memberNo=" + memberNo + "]";
	}
}
