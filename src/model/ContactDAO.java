package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.domain.ContactBean;
import util.DBUtil;

public class ContactDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static ContactBean selectContactByContactNo(int contactNo) throws SQLException{
		ContactBean contact = new ContactBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectContactByContactNo"));
			pstmt.setInt(1, contactNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				contact.setContactNo(contactNo);
				contact.setContactType(rset.getInt(1));
				contact.setAddress(rset.getString(2));
				contact.setCertification(rset.getInt(3));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return contact;
	}
	public static ArrayList<ContactBean> selectAllContactByMemberNo(int memberNo) throws SQLException{
		ArrayList<ContactBean> contactList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			contactList = new ArrayList<ContactBean>();
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllContactByMemberNo"));
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				contactList.add(new ContactBean(
						rset.getInt(1),rset.getInt(2), rset.getString(3), rset.getInt(4)
				));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return contactList;
	}
	
	public static boolean deleteContactByMemberNo(int memberNo) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteContactByMemberNo"));
			pstmt.setInt(1, memberNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static boolean deleteContactByContactNo(int contactNo) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteContactByContactNo"));
			pstmt.setInt(1, contactNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static boolean addContact(int memberNo, ContactBean contact) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addContact"));
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, contact.getContactType());
			pstmt.setString(3, contact.getAddress());
			pstmt.setInt(4, contact.getCertification());
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	public static boolean updateContactAddress(int contactNo, String address) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateContactAddress"));
			pstmt.setString(1, address);
			pstmt.setInt(2, contactNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	public static boolean updateContactCertification(int contactNo, int certification) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateContactCertification"));
			pstmt.setInt(1, certification);
			pstmt.setInt(2, contactNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	public static int selectContactByAddress(String address) throws SQLException {
		int memberNo = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectContactByAddress"));
			pstmt.setString(1, address);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				memberNo = rset.getInt(1);
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberNo;
	}
}