
package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.ItemDao;
import com.takeit.model.dto.Item;



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


/**
 * 판매자 등록 상품보기
 * @param dto 상품 
 */
public void getSellItem(Item dto){
	Connection conn = JdbcTemplate.getConnection();
	
	try {
		dao.SellDetail(conn, dto);
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		JdbcTemplate.close(conn);
	}
}
/**
 * 판매상품변경
 * @param dto item
 */
public void setSellItem(Item dto) throws CommonException{
	Connection conn = JdbcTemplate.getConnection();
	try {
		dao.updateSellItem(conn,dto);
	
	} catch (Exception e) {
		e.printStackTrace();
		JdbcTemplate.rollback(conn);
		throw e;
	}finally {
		JdbcTemplate.close(conn);
		
	}
	}


}

	