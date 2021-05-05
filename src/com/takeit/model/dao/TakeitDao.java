package com.takeit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.ShopLoc;
import com.takeit.model.dto.Takeit;
import com.takeit.model.dto.TakeitItem;
import com.takeit.util.Utility;

public class TakeitDao {
	private static TakeitDao instance = new TakeitDao();
	
	public static TakeitDao getInstance() {
		return instance;
	}

	public void searchTakeitItemList(Connection conn, Member member, ArrayList<TakeitItem> takeitItemList) {
		String sql = 
				"SELECT * "
				+ "FROM ITEM JOIN ITEM_CATEGORY USING (ITEM_CATEGORY_NO) JOIN PACKING USING (PACK_TYPE_NO) JOIN SELLER USING (SELLER_ID) JOIN TAKEIT USING(SHOP_LOC_CODE) "
				+ "WHERE SELLER_ID IN ( "
				+ "		SELECT SELLER_ID "
				+ "		FROM SELLER "
				+ "		WHERE SHOP_LOC_CODE = ( "
				+ "			SELECT SHOP_LOC_CODE "
				+ "			FROM TAKEIT "
				+ "			WHERE TAKEIT_ALIVE = 'T' AND SHOP_LOC_CODE = ? AND MEMBER_LOC_NO = ? "
				+ "			) "
				+ "		) "
				+ "AND ITEM_TAKEIT = 'T' ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getShopLocCode());
			stmt.setString(2, member.getMemberLocNo());
			rs = stmt.executeQuery();
			
			TakeitItem takeitItem = null;
			while (rs.next()) {
				takeitItem = new TakeitItem();
				//상품
				takeitItem.setItemNo(rs.getString("item_No"));
				takeitItem.setSellerId(rs.getString("seller_Id"));
				takeitItem.setItemName(rs.getString("item_Name"));
				takeitItem.setItemPrice(rs.getInt("item_Price")); //int
				takeitItem.setItemImg(rs.getString("item_Img"));
				takeitItem.setItemCustScore(rs.getDouble("item_Cust_Score")); //double
				takeitItem.setItemInputDate(rs.getString("item_Input_Date"));
				
				Date firstDate = Utility.convertStringToDate(Utility.getCurrentDate(), "yyyy-MM-dd HH:mm:ss");
				Date secondDate = Utility.convertStringToDate(rs.getString("item_input_date"), "yyyy-MM-dd HH:mm:ss");
				int a = Utility.getDayBetweenAandB(firstDate, secondDate);
				int b = Integer.valueOf(rs.getString("expiration_date"));
				int c = 100 - (int)(( (double)(b - a) / b) * 100);
				if (c > 100 ) {
					c = 100;
				}
				takeitItem.setDiscRate(c);
				takeitItem.setItemTakeit(rs.getString("item_TakeIt"));
				//잇거래
				takeitItem.setTakeitNo(rs.getString("takeit_No"));
				takeitItem.setTakeitPrice(rs.getInt("takeit_Price")); //int
				takeitItem.setTakeitCurrPrice(rs.getInt("takeit_Curr_Price")); //int
				takeitItem.setTakeitDate(rs.getString("takeit_date"));
				takeitItem.setTakeitCustScore(rs.getDouble("takeit_Cust_Score")); //double
				takeitItem.setTakeitAlive(rs.getString("takeit_Alive"));
				takeitItem.setMemberLocNo(rs.getString("member_Loc_No"));
				takeitItem.setShopLocCode(rs.getString("shop_Loc_Code"));
				//판매자
				takeitItem.setSellerName(rs.getString("name"));
				takeitItem.setShopName(rs.getString("Shop_name"));
				
				
				takeitItemList.add(takeitItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}		
	}

	public void searchTakeitItem(Connection conn, TakeitItem takeitItem) throws CommonException {
		String sql = 
				"SELECT * "
				+ "FROM ITEM JOIN ITEM_CATEGORY USING (ITEM_CATEGORY_NO) JOIN PACKING USING (PACK_TYPE_NO) JOIN SELLER USING (SELLER_ID) JOIN TAKEIT USING(SHOP_LOC_CODE) "
				+ "WHERE ITEM_NO = ? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, takeitItem.getItemNo());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				//포장타입
				takeitItem.setPackTypeNo(rs.getString("pack_Type_No"));
				takeitItem.setPackTypeName(rs.getString("pack_Type_Name"));
				//카테고리
				takeitItem.setItemCategoryNo(rs.getString("item_Category_No"));
				takeitItem.setItemCategoryName(rs.getString("item_Category_Name"));
				takeitItem.setExpirationDate(rs.getString("expiration_Date"));
				takeitItem.setNotice(rs.getString("notice"));
				takeitItem.setFreshPercent(rs.getInt("fresh_Percent")); // int
				//상품
				takeitItem.setItemNo(rs.getString("item_No"));
				takeitItem.setSellerId(rs.getString("seller_Id"));
				takeitItem.setItemName(rs.getString("item_Name"));
				takeitItem.setItemPrice(rs.getInt("item_Price")); //int
				takeitItem.setSalesUnit(rs.getString("sales_Unit"));
				takeitItem.setItemOrigin(rs.getString("item_Origin"));
				takeitItem.setItemStock(rs.getInt("item_Stock")); //int
				takeitItem.setItemImg(rs.getString("item_Img"));
				takeitItem.setItemCustScore(rs.getDouble("item_Cust_Score")); //double
				takeitItem.setItemInputDate(rs.getString("item_Input_Date"));
				System.out.println(rs.getString("item_Input_date"));
				
				Date secondDate = Utility.convertStringToDate(rs.getString("item_input_date"), "yyyy-MM-dd HH:mm:ss");
				Date firstDate = Utility.convertStringToDate(Utility.getCurrentDate(), "yyyy-MM-dd HH:mm:ss");
				int a= Utility.getDayBetweenAandB(firstDate, secondDate);
				int b = Integer.valueOf(rs.getString("expiration_date"));
				int c = 100 - (int)(( (double)(b - a) / b) * 100);
				if (c > 100 ) {
					c = 100;
				}
				takeitItem.setDiscRate(c);
				takeitItem.setItemTakeit(rs.getString("item_TakeIt"));
				//잇거래
				takeitItem.setTakeitNo(rs.getString("takeit_No"));
				takeitItem.setTakeitPrice(rs.getInt("takeit_Price")); //int
				takeitItem.setTakeitCurrPrice(rs.getInt("takeit_Curr_Price")); //int
				takeitItem.setTakeitDate(rs.getString("takeit_date"));
				takeitItem.setTakeitCustScore(rs.getDouble("takeit_Cust_Score")); //double
				takeitItem.setTakeitAlive(rs.getString("takeit_Alive"));
				takeitItem.setMemberLocNo(rs.getString("member_Loc_No"));
				takeitItem.setShopLocCode(rs.getString("shop_Loc_Code"));
				//판매자
				takeitItem.setSellerName(rs.getString("name"));
				takeitItem.setShopName(rs.getString("Shop_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageEntity message = new MessageEntity("error", 12);
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
	}

	public void searchShopLocList(Connection conn, ArrayList<ShopLoc> shopLocList) {
		String sql = 
				"SELECT * "
				+ "FROM SHOP_LOC";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ShopLoc shopLoc = null;
			while (rs.next()) {
				shopLoc = new ShopLoc();
				shopLoc.setShopLocCode(rs.getString("shop_Loc_Code"));
				shopLoc.setShopLocName(rs.getString("shop_Loc_Name"));
				shopLoc.setShopLocLat(rs.getString("shop_Loc_Lat"));
				shopLoc.setShopLocLng(rs.getString("shop_Loc_Lng"));
				
				shopLocList.add(shopLoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
	}
	
	public boolean isValidMemberLocNo(Connection conn, Member member) {
		String sql = 
				"SELECT 1 "
				+ "FROM MEMBER_LOC "
				+ "WHERE MEMBER_LOC_NO = ? AND SHOP_LOC_CODE = ? "; 
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberLocNo());
			stmt.setString(2, member.getShopLocCode());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
		return false;
	}

	public void addMemberLocNo(Connection conn, Member member) {
		String sql = 
				"INSERT INTO MEMBER_LOC VALUES(?,?,?) ";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberLocNo());
			stmt.setString(2, member.getShopLocCode());
			stmt.setString(3, member.getShopLocCode() + member.getMemberLocNo());
			
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}
	
	public void addMemberLoc(Connection conn, ShopLoc shopLoc) throws CommonException {
		String sql = 
				"BEGIN "
				+ "FOR i IN 0 .. 99 LOOP "
				+ "INSERT INTO MEMBER_LOC VALUES (i, ?, ?||'-'||i); "
				+ "END LOOP; "
				+ "END; ";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, shopLoc.getShopLocCode());
			stmt.setString(2, shopLoc.getShopLocCode());
			
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error", 11);
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}
	}

	public void addShopLoc(Connection conn, ShopLoc shopLoc) throws CommonException {
		String sql = 
				"INSERT INTO SHOP_LOC VALUES(?,?,?,?) ";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, shopLoc.getShopLocCode());
			stmt.setString(2, shopLoc.getShopLocName());
			stmt.setString(3, shopLoc.getShopLocLat());
			stmt.setString(4, shopLoc.getShopLocLng());
			
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error", 11);
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}	
	}

	public int searchExistTakeit(Connection conn, String shopLocCode) {
		String sql = 
				"SELECT 1 "
				+ "FROM TAKEIT "
				+ "WHERE TAKEIT_ALIVE = 'T' AND SHOP_LOC_CODE = ? "; 
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, shopLocCode);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
		}	
		return 0;
	}
	
	public void insertTakeit(Connection conn, Takeit takeit) throws CommonException {
		String sql = 
				"BEGIN "
				+ "FOR i IN 0 .. 99 LOOP "
				+ "INSERT INTO TAKEIT "
				+ "VALUES ('TAKE' || TO_CHAR(SYSDATE,'YYYYMMDD') || LPAD(TAKEIT_SEQ.NEXTVAL, 6, '0') "
				+ ", ?, 0, SYSDATE, 0.0, 'T', i, ?); "
				+ "END LOOP; "
				+ "END; ";
		
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, takeit.getTakeitPrice());
			stmt.setString(2, takeit.getShopLocCode());
			
			int row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
			MessageEntity message = new MessageEntity("error", 11);
			throw new CommonException(message);
		} finally {
			JdbcTemplate.close(stmt);
		}
	}	
}
