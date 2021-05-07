
package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.ItemDao;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.Review;



/** 
 * 등록상품전체 조회
 * @return ArrayList<Item>
 */

public class ItemBiz {

  private ItemDao dao = ItemDao.getInstance(); 
	


	
	public void getItemList(ArrayList<Item> ItemList) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.ItemList(con, ItemList);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
	}
	/**
	 * 판매자 등록상품 전체조회

	 * @param dto review
	 * @return 성공시 등록 미입력시 오류처리
	 */
	public void getMySellList(ArrayList<Item> itemList ,String sellerId) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			System.out.println("비즈");
			dao.getMyReviewList(con, itemList,sellerId);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
	}

	   /**
     * <pre>
	 * 상품등록
	 * -- 상품등록 입력 데이터 : 상품번호,상품카테고리이름,판매가,할인율,판매단위,재고량,원산지,포장타입,판매자,이미지,안내사항,유통기한,잇거래여부	 * -- 시스템 추가 데이터 : 상품 등록일
	 * </pre>
	 * @param dto 상품객체
     * @return 성공시 등록 미입력시 오류처리
	 */

public void enrollItem(Item dto) throws CommonException{
	Connection conn = JdbcTemplate.getConnection();
	try {
		
		dao.addItem(conn, dto);
	} catch(CommonException e) {
		throw e; 
	} finally {
		JdbcTemplate.close(conn);
	}
}
/**상품삭제*/
public void deleteItem(Item dto){
	
	Connection conn = JdbcTemplate.getConnection();
	try {
		dao.deleteItem(conn,dto);
		JdbcTemplate.commit(conn);
	}catch (Exception e) {
		e.printStackTrace();
		JdbcTemplate.rollback(conn);
	}finally {
		JdbcTemplate.close(conn);
	}
	
}

/**상품상세조회*/
public void getItem(Item dto) throws CommonException {
	ItemDao dao = ItemDao.getInstance();
	Connection conn = JdbcTemplate.getConnection();
	System.out.println("dto = "+ dto.getItemNo());
	try {
		dao.searchItem(conn, dto);
	} catch (CommonException e) {
		throw e;
	}

	
	JdbcTemplate.close(conn);
}



/**판매자등록상품 보기*/
public void getSellItem(Item dto) throws CommonException {

	Connection conn = JdbcTemplate.getConnection();

	try {
		dao.searchItem(conn, dto);
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}finally {
		JdbcTemplate.close(conn);
	}
}

/**판매자상품상세조회*/
public void searchSell(Item dto,String itemNo) throws CommonException {
	ItemDao dao = ItemDao.getInstance();
	Connection conn = JdbcTemplate.getConnection();
	System.out.println("dto = "+ dto.getItemNo());
	try {
		dao.searchItem(conn, dto);
	} catch (CommonException e) {
		throw e;
	}

	
	JdbcTemplate.close(conn);
}

/**
 * 판매상품변경
 * @param dto item
 */
public void setSellItem(Item dto) throws CommonException{
	Connection conn = JdbcTemplate.getConnection();
	try {
		dao.updateSellItem(conn,dto);
		JdbcTemplate.commit(conn);
		
	} catch (Exception e) {
		e.printStackTrace();
		JdbcTemplate.rollback(conn);
		throw e;
	}finally {
		JdbcTemplate.close(conn);
		
	}
	}

	/**카테고리별 상품 목록*/
	public void getCategoryItemList(ArrayList<Item> categoryItemList, String categoryNo, String categoryName) throws CommonException {
		Connection con = JdbcTemplate.getConnection();
		try {
			dao.getCategoryItemList(con, categoryItemList, categoryNo, categoryName);
		} catch (CommonException e) {
			throw e;
		} finally {
			JdbcTemplate.close(con);
		}
		
	}


}

	