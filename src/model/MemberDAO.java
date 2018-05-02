package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.domain.MemberBean;
import util.DBUtil;

public class MemberDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static boolean addMember(MemberBean member) throws SQLException{
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addMember"));
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setInt(3, member.getAlarmAgree());
			pstmt.setInt(4, member.getRiskNo());
			int addResult = pstmt.executeUpdate();
			if(addResult == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;		
	}
	
	public static boolean deleteMember(int memberNo) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteMember"));
			pstmt.setInt(1, memberNo);
			int addResult = pstmt.executeUpdate();
			if(addResult == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;			
	}
	
	public static MemberBean selectMember(int memberNo) throws SQLException {
		MemberBean member = null;
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectMemberByNo"));
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				member = new MemberBean(
						rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4), rset.getInt(5)
						);
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
	public static MemberBean selectMember(String memberId) throws SQLException {
		MemberBean member = null;
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectMemberById"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				member = new MemberBean(
						rset.getInt(1),rset.getString(2),rset.getString(3),rset.getInt(4), rset.getInt(5)
						);
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
	public static ArrayList<MemberBean> selectAllMember() throws SQLException{
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllMember"));
			rset= pstmt.executeQuery();
			while(rset.next()) {
				memberList.add(new MemberBean(
						rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4),rset.getInt(5)
						));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberList;
	}
	
	public static int selectMemberNoById(String id) throws SQLException {
		int memberNo = 0;
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectMemberNo"));
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				memberNo = rset.getInt(1);
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberNo;
	}
	
	public static boolean updateMemberPw(int memberNo, String newPw) throws SQLException {
		boolean result = false;
		Connection con  = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateMemberPw"));
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, newPw);
			int resultInt = pstmt.executeUpdate();
			if (resultInt == 1) {
				result = true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static boolean updateMemberAlarmAgree(int memberNo, int alarmAgree) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateMemberAlarmAgree"));
			pstmt.setInt(1, alarmAgree);
			pstmt.setInt(2, memberNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static boolean updateMemberRiskType(int memberNo, int riskNo) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateMemberRiskNo"));
			pstmt.setInt(1, riskNo);
			pstmt.setInt(2, memberNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	public static boolean updateMember(MemberBean member) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateMember"));
			pstmt.setString(1, member.getPw());
			pstmt.setInt(2, member.getAlarmAgree());
			pstmt.setInt(3, member.getRiskNo());
			pstmt.setInt(4, member.getNo());
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
}