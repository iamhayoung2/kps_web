package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.domain.ContactBean;
import model.domain.MemberBean;
import model.domain.MemberInfoBean;
import util.DBUtil;

public class MemberInfoDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	public static ArrayList<MemberInfoBean> memberInfoList = new ArrayList<>();
	
	public static ArrayList<MemberInfoBean> getMemberInfoList(){
		return memberInfoList;
	}
	
	public static boolean getMemberInfoFromDB() {
		ArrayList<MemberBean> memberList = new ArrayList<>();
		try {
			memberList = MemberDAO.selectAllMember();
			for(MemberBean mb: memberList) {
				memberInfoList.add(new MemberInfoBean(
						mb, AlarmDAO.selectAllAlarmByMemberNo(mb.getNo()),
						ContactDAO.selectAllContactByMemberNo(mb.getNo())
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBConnect failed.");
			return false;
		}
		return true;
	}
	
	public static MemberInfoBean getMemberInfoByMemberNo(int memberNo) {
		MemberInfoBean memberInfo = new MemberInfoBean();
		try {
			MemberBean member = MemberDAO.selectMember(memberNo);
			member.setNo(memberNo);
			memberInfo.setMember(member);
			memberInfo.setAlarmInfo(AlarmDAO.selectAllAlarmByMemberNo(memberNo));
			memberInfo.setContactInfo(ContactDAO.selectAllContactByMemberNo(memberNo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}
	
	public static boolean updateMemberInfoByMemberNo(MemberInfoBean memberInfo) {
		try {
			MemberDAO.updateMember(memberInfo.getMember());
			for(ContactBean contact: memberInfo.getContactInfo()) {
				ContactDAO.updateContactAddress(contact.getContactNo(), contact.getAddress());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
