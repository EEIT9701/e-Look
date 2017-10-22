package com.e_Look.Order.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.e_Look.Order.model.OrderDAO_interface;
public class OrderDAO implements OrderDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_Order = "insert into Order (memberID,receiptNO,orderTime) values (?,?,?)"; 
	private static final String UPDATE_Order = "update Order set memberID=? receiptNO=? orderTime=? where OrderID=?"; 
	private static final String DELETE_Order = "delete from Order where OrderID=?"; 
	private static final String SELECT_Order = "select OrderID,memberID,receiptNO,orderTime from Order where OrderID=?";
	private static final String SELECT_ALL_Order = "select OrderID,memberID,receiptNO,orderTime from Order";
	@Override
	public void insert(OrderVO OrderVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(INSERT_Order);
			pstmt.setInt(1,OrderVO.getMemberID());
			pstmt.setString(2,OrderVO.getReceiptNO());
			pstmt.setDate(3,OrderVO.getOrderTime());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	
	
	@Override
	public void delete(Integer OrderID) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(DELETE_Order);
			
			pstmt.setInt(1,OrderID);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(OrderVO OrderVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(UPDATE_Order);
			
			pstmt.setInt(1,OrderVO.getMemberID());
			pstmt.setString(2,OrderVO.getReceiptNO());
			pstmt.setDate(3,OrderVO.getOrderTime());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	
	@Override
	public OrderVO findByPrimaryKey(Integer OrderID) {
		OrderVO OrderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_Order);
			pstmt.setInt(1, OrderID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				OrderVO = new OrderVO();
				OrderVO.setOrderID(rs.getInt(1));
				OrderVO.setMemberID(rs.getInt(2));
				OrderVO.setReceiptNO(rs.getString(3));
				OrderVO.setOrderTime(rs.getDate(4));
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return OrderVO;
	
	}

	@Override
	public List<OrderVO> getAll() {
		List<OrderVO> list = new LinkedList<OrderVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL_Order);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				OrderVO OrderVO= new OrderVO();
				OrderVO.setOrderID(rs.getInt(1));
				OrderVO.setMemberID(rs.getInt(2));
				OrderVO.setReceiptNO(rs.getString(3));
				OrderVO.setOrderTime(rs.getDate(4));
				list.add(OrderVO);
			}	
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}