package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Cart;
import com.takeit.model.dto.MessageEntity;

public class CartDao {
	private static CartDao instance = new CartDao();
	private CartDao() {}
	public static CartDao getInstance() {
		return instance;
	}
	
	/**장바구니 전체 목록 조회*/
	public void getCartList(Connection con, String memberId, int cartTotalPrice, ArrayList<Cart> cart) throws CommonException {
		System.out.println("[debug] 장바구니 전체 목록 dao 요청");
		String sql = "SELECT I.ITEM_NO AS ITEM_NO, I.ITEM_NAME AS ITEM_NAME, S.NAME AS SELLER_NAME, I.ITEM_IMG AS ITEM_IMG, "
				+ "C.CART_ITEM_QTY AS CART_ITEM_QTY, I.ITEM_PRICE AS ITEM_PRICE, (I.ITEM_PRICE * C.CART_ITEM_QTY) AS TOTAL_PRICE "
				+ "FROM CART C, ITEM I, SELLER S "
				+ "WHERE C.ITEM_NO = I.ITEM_NO "
				+ "AND I.SELLER_ID = S.SELLER_ID "
				+ "AND C.MEMBER_ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("[debug] 총 결제 금액= " + cartTotalPrice);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Cart dto = new Cart();
				dto.setItemNo(rs.getString("ITEM_NO"));
				dto.setItemName(rs.getString("ITEM_NAME"));
				dto.setSellerName(rs.getString("SELLER_NAME"));
				dto.setCartItemQty(rs.getInt("CART_ITEM_QTY"));
				dto.setItemPrice(rs.getInt("ITEM_PRICE"));
				dto.setTotalPrice(rs.getInt("TOTAL_PRICE"));
				dto.setItemImg(rs.getString("ITEM_IMG"));
				cartTotalPrice += dto.getTotalPrice();
				System.out.println("[debug] 누적 총 결제 금액= " + cartTotalPrice);
				cart.add(dto);
			}
			System.out.println("[debug] 장바구니 전체 목록 dao 요청 완료");
			
		} catch (SQLException e) {
			System.out.println("[debug] 장바구니 전체 목록 dao 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error",21);
			message.setLinkTitle("메인으로");
			message.setUrl("/takeit/index");
			throw new CommonException(message);
		} finally{
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
	}
	
	/**장바구니 등록*/
	public void addCart(Connection con, Cart cart) throws CommonException {
		System.out.println("[debug] 장바구니 등록 dao 요청");
		String sql = "INSERT INTO CART VALUES(?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cart.getMemberId());
			pstmt.setString(2, cart.getItemNo());
			pstmt.setInt(3, cart.getCartItemQty());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",20);
			message.setLinkTitle("장바구니");
			message.setUrl("/takeit/item/cartList.jsp");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
	}
	
	/**장바구니 삭제*/
	public void removeCart(Connection con, String memberId, String itemNo) throws CommonException{
		System.out.println("[debug] 장바구니 삭제 dao 요청");
		String sql = "DELETE FROM CART WHERE MEMBER_ID=? AND ITEM_NO=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, itemNo);
			pstmt.executeUpdate();
			System.out.println("[debug] 장바구니 삭제 dao 요청 완료");
		} catch (SQLException e) {
			System.out.println("[debug] 장바구니 삭제 dao 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",23);
			message.setLinkTitle("장바구니");
			message.setUrl("/takeit/item/cartList.jsp");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
	}
	
	/**장바구니 전체 삭제*/
	public void removeAllCart(Connection con, String memberId) throws CommonException {
		System.out.println("[debug] 장바구니 전체 삭제 dao 요청");
		String sql = "DELETE FROM CART WHERE MEMBER_ID=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			System.out.println("[debug] 장바구니 전체 삭제 dao 요청 완료");
		} catch (SQLException e) {
			System.out.println("[debug] 장바구니 전체 삭제 dao 요청 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",23);
			message.setLinkTitle("장바구니");
			message.setUrl("/takeit/item/cartList.jsp");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
	}
	
	/**장바구니 변경*/
	public void changeCartQty(Connection con, Cart cart) throws CommonException {
		System.out.println("[debug] 장바구니 수량변경 dao 요청");
		String sql = "UPDATE CART SET CART_ITEM_QTY=? WHERE MEMBER_ID=? AND ITEM_NO=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cart.getCartItemQty());
			pstmt.setString(2, cart.getMemberId());
			pstmt.setString(3, cart.getItemNo());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",20);
			message.setLinkTitle("장바구니");
			message.setUrl("/takeit/item/cartList.jsp");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
	}

	
}
