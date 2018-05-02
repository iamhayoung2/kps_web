package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.domain.CoinPredBean;
import util.DBUtil;

public class BitCoinDAO {
	static int addTime = 0;
	static int getPreTime= 0;
	static ResourceBundle sql = DBUtil.getResourceBundle();
	public static ArrayList<CoinPredBean> bitCoinPredList = new ArrayList<>();
	public static ArrayList<CoinPredBean> bitCoinPremiumList = new ArrayList<>();
	
	static {
		getBitCoinPredFromDB();
		getBitCoinPremiumFromDB();
	}
	public static void getBitCoinPredFromDB() {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		if(getPreTime == 0 || (currentTime-getPreTime) > 60*5) {
			getPreTime=currentTime;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			bitCoinPredList = new ArrayList<>();
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql.getString("selectAllBitPred"));
				rset = pstmt.executeQuery();
				while(rset.next()) {
					bitCoinPredList.add(
							new CoinPredBean(rset.getInt(1),rset.getFloat(2)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(con, pstmt, rset);
			}
		}
	}
	
	public static void getBitCoinPremiumFromDB() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		bitCoinPremiumList = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllBitCoinPremium"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				bitCoinPremiumList.add(
						new CoinPredBean(rset.getInt(1),rset.getFloat(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
	}
	
	public static int addBitCoinPremium(int timestamp, float premium) {
		int resultInt = 0;
		bitCoinPremiumList.add(new CoinPredBean(timestamp, premium));
		int currentTime = (int) (System.currentTimeMillis()/1000);

		//--- ***** ----
//		if((currentTime-addTime) >= (60*5)) {
//			addTime = currentTime;
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try {
//				con = DBUtil.getConnection();
//				pstmt = con.prepareStatement(sql.getString("insertBitCoinPremium"));
//				pstmt.setInt(1, timestamp);
//				pstmt.setFloat(2, premium);
//				resultInt = pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				DBUtil.close(con, pstmt);
//			}
//		}
		
		return resultInt;
	}
	public static ArrayList<CoinPredBean> getBitCoinPremiumList(){
		return bitCoinPremiumList;
	}
	public static  ArrayList<CoinPredBean> getBitCoinPredList(){
		getBitCoinPredFromDB();
		return bitCoinPredList;
	}
}