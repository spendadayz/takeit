package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Order;
import com.takeit.model.dto.OrderDetail;

public class OrderDao {
	private static OrderDao instance = new OrderDao();
	
	public static OrderDao getInstance() {
		return instance;
	}
	
	public void insertOrder(Connection conn, Order order) throws CommonException {
		String sql = 
				"INSERT INTO Orders VALUES(? || TO_CHAR(SYSDATE,'yyyymmdd') || LPAD(ORDER_SEQ.NEXTVAL, 6, '0') "
				+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, order.getItemTakeit());
			stmt.setString(2, order.getReceiveMethod());
			stmt.setString(3, order.getRecipientName());
			stmt.setString(4, order.getRecipientPostNo());
			stmt.setString(5, order.getRecipientAddr());
			stmt.setString(6, order.getRecipientMobile());
			stmt.setString(7, order.getShipRequest());
			stmt.setInt(8, order.getOrderPrice());
			stmt.setString(9, order.getShipStatusCode());
			stmt.setString(10, order.getMemberId());
			
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}
	
	public void selectOrderNo(Connection conn, Order order) throws CommonException {
		String sql = 
				"SELECT ORDER_NO FROM ORDERS WHERE ROWNUM = 1 ORDER BY 1 DESC ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				order.setOrderNo(rs.getString("Order_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
	}
	
	public void insertOrderDetail(Connection conn, Order order) throws CommonException {
		String sql = 
				"INSERT INTO Order_Detail VALUES(?, ?, ?, ?) ";
		
		PreparedStatement stmt = null;
		try {
			
			for (int index = 0; index < order.getOrderDetails().size(); index++) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, order.getOrderDetails().get(index).getItemNo());
				stmt.setString(2, order.getOrderNo());
				stmt.setInt(3, order.getOrderDetails().get(index).getItemQty());
				stmt.setInt(4, order.getOrderDetails().get(index).getItemPayPrice());
				
				int row = stmt.executeUpdate();
				if (row == 0) {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}

	public void selectSellerOrderList(Connection conn, String sellerId, ArrayList<Order> orderList) throws CommonException {
		String sql = "SELECT * "
				+ "FROM ITEM JOIN ORDER_DETAIL USING(ITEM_NO) JOIN ORDERS USING(ORDER_NO) JOIN SHIPPING USING(SHIP_STATUS_CODE) "
				+ "WHERE ITEM.SELLER_ID = ? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  sellerId);
			rs = stmt.executeQuery();
			
			Order order = null;
			ArrayList<OrderDetail> orderDetails = null;
			OrderDetail orderDetail = null;
			while (rs.next()) {
				order = new Order();
				orderDetails = new ArrayList<OrderDetail>();
				orderDetail = new OrderDetail();
				for (Order dto : orderList) {
					if (dto.getOrderNo().equals(rs.getString("order_no"))) {
						order = dto;
						orderDetails = dto.getOrderDetails();
						break;
					}
				}
				
				orderDetail.setItemNo(rs.getString("item_no"));
				orderDetail.setItemName(rs.getString("item_name"));
				orderDetail.setItemQty(rs.getInt("Item_Qty"));
				orderDetail.setItemPayPrice(rs.getInt("item_pay_price"));
				orderDetails.add(orderDetail);
				
				order.setOrderDetails(orderDetails);

				order.setOrderNo(rs.getString("order_No"));
				order.setShipStatus(rs.getString("ship_Status"));
				order.setShipRequest(rs.getString("ship_Request"));
				order.setMemberId(rs.getString("member_Id"));
				
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 28);
			
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
		
	}
}
