package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderingVO;
import model.ProductVO;

public class ProductDAO {

	public ProductVO addNewProduct(ProductVO pd) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into product values (?, ?, ?, ?)");
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO pVo = pd;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pVo.getProductno());
			pstmt.setString(2, pVo.getProductname());
			pstmt.setInt(3, pVo.getProductprice());
			pstmt.setString(4, pVo.getProductpicpath());
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
		return pd;
	}
	public int getProductLastNo() {
		int result = 999;
		StringBuffer sql = new StringBuffer();
		sql.append("select max(productno) from product");
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
	public int countProduct() throws Exception {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from product");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	public ProductVO getProductCheck(int pronum) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from product where productno like ? order by productno desc");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO VO = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pronum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				VO = new ProductVO();
				VO.setProductno(rs.getInt("productno"));
				VO.setProductname(rs.getString("productname"));
				VO.setProductprice(rs.getInt("productprice"));
				VO.setProductpicpath(rs.getString("productpicpath"));
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
		return VO;
	}
	public void deleteFromProduct(int numba) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete product where productno = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, numba);
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
	}

	public ArrayList<ProductVO> getProductTotal() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select productno, productname, productprice, productpicpath from product order by productno");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO sVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sVo = new ProductVO();
				sVo.setProductno(rs.getInt("productno"));
				sVo.setProductname(rs.getString("productname"));
				sVo.setProductprice(rs.getInt("productprice"));
				sVo.setProductpicpath(rs.getString("productpicpath"));
				list.add(sVo);
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
	
	public ProductVO updateProduct(ProductVO VO, int numba) throws Exception {
		// 데이터 처리를 위한 SQL 문
		StringBuffer sql = new StringBuffer();
		sql.append("update product set productname=?, productprice=?, productpicpath=? where productno =?");
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO retval = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, VO.getProductname());
			pstmt.setInt(2, VO.getProductprice());
			pstmt.setString(3, VO.getProductpicpath());
			pstmt.setInt(4, numba);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("수정 완료");
				retval = new ProductVO();
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
	
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from product");
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
