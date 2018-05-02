package model.domain;

public class MemberBean {
	private int no;
	private String id;
	private String pw;
	private int riskNo;
	private int alarmAgree;
	
	public MemberBean() {}
	public MemberBean(String id, String pw, int alarmAgree , int riskNumber) {
		super();
		this.no=0;
		this.id = id;
		this.pw = pw;
		this.riskNo = riskNumber;
		this.alarmAgree = alarmAgree;
	}
	public MemberBean(int no, String id, String pw, int alarmAgree , int riskNumber) {
		super();
		this.no= no;
		this.id = id;
		this.pw = pw;
		this.riskNo = riskNumber;
		this.alarmAgree = alarmAgree;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRiskNo() {
		return riskNo;
	}
	public void setRiskNo(int riskNo) {
		this.riskNo = riskNo;
	}
	public int getAlarmAgree() {
		return alarmAgree;
	}
	public void setAlarmAgree(int alarmAgree) {
		this.alarmAgree = alarmAgree;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", riskNo=" + riskNo + ", alarmAgree=" + alarmAgree + "]";
	}
}