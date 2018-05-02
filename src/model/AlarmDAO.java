package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.domain.AlarmBean;
import util.DBUtil;

public class AlarmDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static boolean addAlarm(int memberNo, AlarmBean alarm) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addAlarm"));
			pstmt.setInt(1, alarm.getCoinNo());
			pstmt.setFloat(2, alarm.getPercent());
			pstmt.setInt(3, alarm.getContactNo());
			pstmt.setInt(4, alarm.getMemberNo());
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			
		}
		return result;
	}


	public static boolean deleteAlarmByAlarmNo(int alarmNo) throws SQLException {
		boolean result =false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteAlarmByAlarmNo"));
			pstmt.setInt(1, alarmNo);
			int resultInt = pstmt.executeUpdate();
			if(resultInt == 1) {
				result = true;
			}
		}finally {
			DBUtil.close(con,pstmt);
		}
		return result;
	}

	public static ArrayList<AlarmBean> selectAllAlarmByMemberNo(int memberNo) throws SQLException{
		ArrayList<AlarmBean> alarmList = new ArrayList<AlarmBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllAlarmByMemberNo"));
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				alarmList.add(new AlarmBean(
						rset.getInt(1), rset.getInt(2), rset.getFloat(3), rset.getInt(4), memberNo
						));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return alarmList;
	}
}