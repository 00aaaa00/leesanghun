package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.OrderingVO;

public class OrderingDAO {

	public OrderingVO addNewOrder(OrderingVO ov) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"insert into ordering (orderno, productno, productname, productprice, productamount) values (?, ?, ?, ?, ?)");
		Connection con = null;
		PreparedStatement pstmt = null;
		OrderingVO VO = ov;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, VO.getOrderno());
			pstmt.setInt(2, VO.getProductno());
			pstmt.setString(3, VO.getProductname());
			pstmt.setInt(4, VO.getProductprice());
			pstmt.setInt(5, VO.getProductamount());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return ov;
	}

	public OrderingVO updateOrderingAmount(OrderingVO VO, int numba) throws Exception {
		// 데이터 처리를 위한 SQL 문
		StringBuffer sql = new StringBuffer();
		sql.append("update ordering set productamount=? where productno =?");
		Connection con = null;
		PreparedStatement pstmt = null;
		OrderingVO retval = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, VO.getProductamount());
			pstmt.setInt(2, numba);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("수정 완료");
				retval = new OrderingVO();
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return retval;
	}

	public void ClearOrder() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete ordering");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	public ArrayList<OrderingVO> getOrderTotal() {
		ArrayList<OrderingVO> list = new ArrayList<OrderingVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select orderno, productno, productname, productprice, productamount from ordering order by productno");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderingVO VO = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO = new OrderingVO();
				VO.setOrderno(rs.getInt("orderno"));
				VO.setProductno(rs.getInt("productno"));
				VO.setProductname(rs.getString("productname"));
				VO.setProductprice(rs.getInt("productprice"));
				VO.setProductamount(rs.getInt("productamount"));
				list.add(VO);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}

	public int getOrderLastNo() {
		int result = 999;
		StringBuffer sql = new StringBuffer();
		sql.append("select max(orderno) from ordering");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return result;
	}

	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ordering");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for (int i = 1; i <= cols; i++) {
				columnName.add(rsmd.getColumnName(i));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return columnName;
	}
}
