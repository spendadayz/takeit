package com.takeit.model.dao;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;

/**
 * 
 * @author 심선경
 *
 */
public class MypageDao {
	
	private static MypageDao instance = new MypageDao();
	
	public static MypageDao getInstance() {
		return instance;
	}
	
	
	/**
	 * 상점 카테고리 리스트
	 */
	public void getShopCategoryList(Connection conn, ArrayList<Seller> shopCategoryList) throws CommonException{
		
		String sql = "SELECT * FROM SHOP_CATEGORY";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Seller dto = new Seller();
				
				
				dto.setShopCategoryNo(rs.getString("SHOP_CATEGORY_NO"));
//				dto.setShopCategoryName(rs.getString("SHOP_CATEGORY"));
				
				shopCategoryList.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error", 1);
			message.setUrl("/takeit/member/myPage.jsp");
			message.setLinkTitle("마이페이지로 이동");

			throw new CommonException(message);
			
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
		
	}
	
	
	
	
	/**
	 * 상품 포장 타입 리스트 가져오기
	 * @param conn
	 * @param packTypeList
	 * @throws CommonException
	 */
		public void getpackTypeList(Connection conn , ArrayList<Item> packTypeList) throws CommonException{
			String sql = "SELECT * FROM PACKING";
			
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				
				while(rs.next()) {
					Item dto = new Item();
					
					
					dto.setPackTypeNo(rs.getString("PACK_TYPE_NO"));
					dto.setPackTypeName(rs.getString("PACK_TYPE_NAME"));
					
					packTypeList.add(dto);
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				MessageEntity message = new MessageEntity("error", 8);
				message.setUrl("/takeit/member/myPage.jsp");
				message.setLinkTitle("마이페이지로 이동");

				throw new CommonException(message);
				
			}
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
			
		}
	
	
	
	/**
	 * 상품 카테고리 리스트 가져오기
	 * @param conn
	 * @param categoryList
	 * @throws CommonException
	 */
	public void getCategotyList(Connection conn , ArrayList<Item> categoryList) throws CommonException{
		String sql = "SELECT * FROM ITEM_CATEGORY";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Item dto = new Item();
				
				dto.setItemCategoryNo(rs.getString("ITEM_CATEGORY_NO"));
				dto.setItemCategoryName(rs.getString("ITEM_CATEGORY_NAME"));
				dto.setExpirationDate(rs.getString("EXPIRATION_DATE"));
				dto.setNotice(rs.getString("NOTICE"));
				dto.setFreshPercent(rs.getInt("FRESH_PERCENT"));
				dto.setPackTypeNo(rs.getString("PACK_TYPE_NO"));
				
				categoryList.add(dto);
			}
			
			
			
		}catch (Exception e) {
			System.out.println("카테고리 목록 가져오기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error", 8);
			message.setUrl("/takeit/member/myPage.jsp");
			message.setLinkTitle("마이페이지로 이동");

			throw new CommonException(message);
			
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(stmt);
		
	}
	
	
	
	/**
	 * 상품 등록 
	 * @param conn
	 * @param dto
	 * @throws CommonException
	 */
		public void addItem(Connection conn, Item dto) throws CommonException {
			System.out.println("상품 등록 dao 입장");
			String sql = "INSERT INTO ITEM VALUES (? || lpad((ITEM_SEQ.nextval),6,'0'),"
					+ "?, ?, ?, null, ?, ?, ?, ?, sysdate, ?, ?,?)";

			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, dto.getItemCategoryNo());
				stmt.setString(2, dto.getSellerId());
				stmt.setString(3, dto.getItemName());
				stmt.setInt(4, dto.getItemPrice ());
				stmt.setString(5, dto.getItemOrigin());
				stmt.setInt(6, dto.getItemStock());
				stmt.setString(7, dto.getItemImg());
				stmt.setDouble(8, 0.0);
				stmt.setInt(9, 0);
				stmt.setString(10, dto.getItemTakeit());
				stmt.setString(11, dto.getItemCategoryNo());
				
				int result = stmt.executeUpdate();
				
				if(result == 0) {
					throw new Exception();
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			
				MessageEntity message = new MessageEntity("error", 7);
				message.setUrl("/takeit/item/login?action=itemaddForm");
				message.setLinkTitle("상품등록");

				throw new CommonException(message);
			}
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	
	
	/**
	 * 일반 회원 내 정보 상세 조회
	 * @param conn
	 * @param dto 회원 객체
	 */
	public void selectMemberDetail(Connection conn, Member dto) throws CommonException{
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setPoint(rs.getInt("point"));
				dto.setAddress(rs.getString("address"));
				dto.setAddressDetail(rs.getString("address_detail"));
				dto.setPostNo(rs.getString("postno"));
				dto.setBirth(rs.getString("birth"));
				dto.setMemberLocNo(rs.getString("member_loc_no"));
				dto.setGrade(rs.getString("grade"));
				dto.setShopLocCode(rs.getString("shop_loc_code"));
				System.out.println(dto);
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",1);
			message.setLinkTitle("마이페이지로 이동");
			message.setUrl("/takeit/member/myPage.jsp");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
	}
	
	/**
	 * 일반회원 내 정보 수정 
	 * @param conn
	 * @param dto 일반회원 객체
	 */
	public void memberInfoUpdate (Connection conn, Member dto) throws CommonException{
		String sql = "update member set member_pw=? ,name=?,mobile=?,"
					 + "email=?, postno=?, address=?, address_detail=?, birth=? where member_id=? ";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getPostNo());
			stmt.setString(6, dto.getAddress());
			stmt.setString(7, dto.getAddressDetail());
			stmt.setString(8, dto.getBirth());
			stmt.setString(9, dto.getMemberId());
			
			int result = stmt.executeUpdate();
			
			if(result == 0) {
				throw new Exception();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",2);
			message.setLinkTitle("내 정보 페이지 이동");
			message.setUrl("/takeit/member/myPage.jsp");
			throw new CommonException(message);
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	
	
	/**
	 * 판매자 정보 상세 조회
	 * @param conn
	 * @param dto	판매자 객체
	 * @throws CommonException
	 */
	public void searchSellerDetail(Connection conn, Seller dto) throws CommonException {
		
		String sql = "SELECT * FROM SELLER S JOIN SHOP_CATEGORY SP_CG "
					+ "USING(SHOP_CATEGORY_NO) " + 
					"WHERE SELLER_ID=?";
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcTemplate.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getSellerId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setSellerId(rs.getString("seller_id"));
				dto.setSellerPw(rs.getString("seller_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setPostNo(rs.getString("postno"));
				dto.setAddress(rs.getString("address"));
				dto.setAddressDetail(rs.getString("address_detail"));
				dto.setGrade(rs.getString("grade"));
				dto.setSellerNo(rs.getString("seller_no"));
				dto.setShopMobile(rs.getString("shop_mobile"));
				dto.setShopName(rs.getString("shop_name"));
				dto.setCustScore(rs.getDouble("cust_score"));
				dto.setShopKakaoId(rs.getString("shop_kakao_id"));
				dto.setShopImg(rs.getString("shop_img"));
				dto.setShopCategoryNo(rs.getString("shop_category_no"));
//				dto.setShopCategoryName(rs.getString("shop_category"));
				
//				dto.setShopLocCode(rs.getString("shop_loc_code"));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",1);
			message.setUrl("/takeit/member/sellerInfo.jsp");
			message.setLinkTitle("내 정보 보기");
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}
		
	}
	
	/**
	 * 내 정보 수정 > 판매자 
	 * @param conn
	 * @param dto 판매자 객체
	 * @throws CommonException
	 */
	public void sellerInfoUpdate(Connection conn, Seller dto) throws CommonException{
		String sql = "update seller set seller_pw=? ,name=?,mobile=?,"
				 + "email=?, postno=?, address=?, address_detail=?, seller_no=? ,"
				 + " shop_mobile=? , shop_name=?, shop_kakao_id=?, "
				 + "shop_category_no=? where seller_id=? ";
	
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getSellerPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getMobile());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getPostNo());
			stmt.setString(6, dto.getAddress());
			stmt.setString(7, dto.getAddressDetail());
			stmt.setString(8, dto.getSellerNo());
			stmt.setString(9, dto.getShopMobile());
			stmt.setString(10, dto.getShopName());
			stmt.setString(11, dto.getShopKakaoId());
			stmt.setString(12, dto.getShopCategoryNo());
			stmt.setString(13, dto.getSellerId());
			
			
			int result = stmt.executeUpdate();
			if(result == 0) {
				throw new Exception();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",2);
			message.setLinkTitle("내 정보페이지로  이동");
			message.setUrl("/takeit/member/myPage.jsp");
			throw new CommonException(message);
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	/**
	 * 비밀번호 변경 > 일반회원
	 * @param conn 
	 * @param memberPw2	변경할 비밀번호
	 * @param dto 		일반회원 객체
	 * @throws CommonException
	 */
	public void memberPwUpdate(Connection conn , String memberPw2, Member dto) throws CommonException{
		String sql = "update member set member_pw=? where member_id=? and member_pw=?";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, memberPw2);
			stmt.setString(2, dto.getMemberId());
			stmt.setString(3, dto.getMemberPw());
			
			int result = stmt.executeUpdate();
			if(result == 0) {
				throw new Exception();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error",2);
			message.setLinkTitle("내 정보페이지 이동");
			message.setUrl("/takeit/member/myPage.jsp");
			throw new CommonException(message);
		}finally {
			JdbcTemplate.close(stmt);
		}
		
	}
	
	/**
	 * 비밀번호 변경 > 판매자
	 * @param conn
	 * @param sellerPw2	변경할 비밀번호
	 * @param dto		판매자 객체
	 * @throws CommonException
	 */
		public void sellerPwUpdate(Connection conn , String sellerPw2, Seller dto) throws CommonException{
			String sql = "update seller set seller_pw=? where seller_id=? and seller_pw=?";
			
			PreparedStatement stmt = null;
			
			try {
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, sellerPw2);
				stmt.setString(2, dto.getSellerId());
				stmt.setString(3, dto.getSellerPw());
				
				int result = stmt.executeUpdate();
				
				if(result == 0) {
					throw new Exception();
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				MessageEntity message = new MessageEntity("error",2);
				message.setLinkTitle("내 정보페이지 이동");
				message.setUrl("/takeit/member/myPage.jsp");
				throw new CommonException(message);
			}finally {
				JdbcTemplate.close(stmt);
			}
			
		}
	
		/**
		 * 회원 탈퇴 일반회원
		 * @param conn
		 * @param memberId 탈퇴할 아이디
		 * @param memberPw 탈퇴할 비밀번호
		 * @throws CommonException
		 */
		public void memberDelete(Connection conn, String memberId, String memberPw) throws CommonException {
			String sql = "delete from member where member_id=? and member_pw=?";
			
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			System.out.println("회원 탈퇴 요청--dao");
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, memberId);
				stmt.setString(2, memberPw);
				
				int result = stmt.executeUpdate();
				
				
				if(result == 0) {
					throw new Exception();
				}
				
			}catch (Exception e) {
				System.out.println("탈퇴 요청 실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				MessageEntity message = new MessageEntity("error",4);
				message.setLinkTitle("마이페이지로 이동");
				message.setUrl("/takeit/member/myPage.jsp");
				throw new CommonException(message);
				
				
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(stmt);
			}
			
		}
		
		
		/**
		 * 회원 탈퇴 판매자
		 * @param conn
		 * @param sellerId 탈퇴할 아이디
		 * @param sellerPw	탈퇴할 비밀번호
		 * @throws CommonException
		 */
		public void sellerDelete(Connection conn, String sellerId, String sellerPw) throws CommonException{
			
			String sql = "delete from seller where seller_id=? and seller_pw=?";
			
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, sellerId);
				stmt.setString(2, sellerPw);
				
				int result = stmt.executeUpdate();
				
				
				if(result == 0) {
					throw new Exception();
				}
				
			}catch (Exception e) {
				System.out.println("탈퇴 요청 실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
				MessageEntity message = new MessageEntity("error",4);
				message.setLinkTitle("마이페이지로 이동");
				message.setUrl("/takeit/member/myPage.jsp");
				throw new CommonException(message);
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(stmt);
			}
		}
		
		
}
