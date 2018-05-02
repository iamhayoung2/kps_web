package model.domain;

public class ContactBean {
	private int contactNo;
	private int contactType;
	private String address;
	private int certification;
	
	public ContactBean(){}
	public ContactBean(int contactNo, int contactType, String address, int certification) {
		super();
		this.contactNo = contactNo;
		this.contactType = contactType;
		this.address = address;
		this.certification = certification;
	}
	public ContactBean( int contactType, String address, int certification) {
		super();
		this.contactNo = 0;
		this.contactType = contactType;
		this.address = address;
		this.certification = certification;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public int getContactType() {
		return contactType;
	}
	public void setContactType(int contactType) {
		this.contactType = contactType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCertification() {
		return certification;
	}
	public void setCertification(int certification) {
		this.certification = certification;
	}
	@Override
	public String toString() {
		return "ContactBean [contactNo=" + contactNo + ", contactType=" + contactType + ", address=" + address
				+ ", certification=" + certification + "]";
	}
}