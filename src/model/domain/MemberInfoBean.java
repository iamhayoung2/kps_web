package model.domain;

import java.util.ArrayList;

public class MemberInfoBean {
	private MemberBean member;
	private ArrayList<AlarmBean> alarmInfo;
	private ArrayList<ContactBean> contactInfo;
	
	public MemberInfoBean() {}
	public MemberInfoBean(MemberBean member) {
		this.member = member;
		alarmInfo = new ArrayList<>();
		contactInfo = new ArrayList<>();
	}
	public MemberInfoBean(MemberBean member, ArrayList<AlarmBean> alarmInfo, ArrayList<ContactBean> contactInfo) {
		super();
		this.member = member;
		this.alarmInfo = alarmInfo;
		this.contactInfo = contactInfo;
	}
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}
	public ArrayList<AlarmBean> getAlarmInfo() {
		return alarmInfo;
	}
	public void setAlarmInfo(ArrayList<AlarmBean> alarmInfo) {
		this.alarmInfo = alarmInfo;
	}
	public ArrayList<ContactBean> getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ArrayList<ContactBean> contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "MemberInfoBean [member=" + member + ", alarmInfo=" + alarmInfo + ", contactInfo=" + contactInfo + "]";
	}
}
