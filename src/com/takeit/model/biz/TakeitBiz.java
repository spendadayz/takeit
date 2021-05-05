package com.takeit.model.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.TakeitDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.ShopLoc;
import com.takeit.model.dto.Takeit;
import com.takeit.model.dto.TakeitItem;
import com.takeit.util.Utility;

public class TakeitBiz {
	
	/**
	 * @param takeitPrice 
	 * @param shopLocCode 
	 * @throws CommonException 
	 * 
	 */
	public void addTakeit(Takeit takeit) throws CommonException {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		boolean result = existTakeit(takeit.getShopLocCode());
		
		if (result) {
			System.out.println("이미 등록되어있습니다");
			MessageEntity message = new MessageEntity("error", 11);
			throw new CommonException(message);
		}
		try {
			dao.insertTakeit(conn, takeit);
			JdbcTemplate.commit(conn);
		} catch (CommonException e) {
			JdbcTemplate.rollback(conn);
		} finally {
			JdbcTemplate.close(conn);
		}
	}
	
	public boolean existTakeit(String shopLocCode) {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		int row = dao.searchExistTakeit(conn, shopLocCode);
		JdbcTemplate.close(conn);
		
		if( row == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 1. memberDto에서 꺼낸 상점구역이 null이라면
	 * 2. 회원의 상점구역과 판매자테이블의 상점구역이 일치하는 
	 * 
	 * N. 세션에 회원정보 전체를 담을것인지? 맞다면 회원dto에서 받아오고, 아니라면 query를 통해 얻어옴
	 * 
	 */
	public void getTakeitItemList(Member member, ArrayList<TakeitItem> takeitItemList) {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		dao.searchTakeitItemList(conn, member, takeitItemList);
		
		JdbcTemplate.close(conn);
	}
	
	/**
	 * takeit 상품 상세조회
	 * 상품번호를 받아와서 조회후 
	 * 
	 * 필요한것 : 잇거래여부, 판매자 위치, 
	 * @throws CommonException 
	 * 
	 */
	public void getTakeitItem(TakeitItem takeitItem) throws CommonException {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.searchTakeitItem(conn, takeitItem);
		} catch (CommonException e) {
			throw e;
		}

		
		JdbcTemplate.close(conn);
	}
	
	/**
	 * argument로 전달받은 주소의 위치에 따른 구역코드를 설정합니다
	 * 
	 * 상점구역코드, 회원구역번호
	 * 1. Shop_Loc 테이블 내에 저장 되어있는지를 비교한다
	 *  - 상점구역 목록중에 
	 * 
	 * 
	 * 
	 */
	public void addMemberLocNo(Member member) {
		HashMap<String, String> latLng = Utility.getLatlng(member.getAddress());
		String _lat = latLng.get("lat");
		String _lng = latLng.get("lng");
		if ( _lat == null || _lng == null) { 
			System.out.println("주소가 잘못되었습니다");
			return ;
		}
		Double lat = Double.valueOf(_lat);
		Double lng = Double.valueOf(_lng);
		
		System.out.println("[debug] 위도 :" + lat);
		System.out.println("[debug] 경도 :" + lng);
		
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		ArrayList<ShopLoc> shopLocList = new ArrayList<ShopLoc>();
		dao.searchShopLocList(conn, shopLocList);
		JdbcTemplate.close(conn);
		
		double locLat = 0;
		double locLng = 0;
		
		for (ShopLoc shopLoc : shopLocList) {
			Double shopLat = Double.valueOf(shopLoc.getShopLocLat());
			Double shopLng = Double.valueOf(shopLoc.getShopLocLng());
			System.out.println("[debug]상점위도 :" + shopLat);
			System.out.println("[debug]상점경도 :" + shopLng);
			
			locLat = shopLat-lat;
			locLng = shopLng-lng;
			
			//지역에 포함된다면
			if (Math.abs(locLat) <= 0.05 && Math.abs(locLng) <= 0.05) {
				member.setShopLocCode(shopLoc.getShopLocCode());
				break;
			}
		}
		
		if (member.getShopLocCode() == null) {
			System.out.println("근처 지역상점이 없습니다");
			return ;
		}
		String memberLocNo = "";
		locLat += 0.05;
		memberLocNo += (int)(locLat*100);
		
		locLng += 0.05;
		memberLocNo += (int)(locLat*100);
		member.setMemberLocNo(memberLocNo);
		System.out.println("회원구역설정 완료");
		
		conn = JdbcTemplate.getConnection();
		boolean result = dao.isValidMemberLocNo(conn, member);
		
		if (!result) {
			dao.addMemberLocNo(conn, member);
		}
		
		JdbcTemplate.close(conn);
	}
	
	public void addShopLoc(String address, ShopLoc shopLoc) throws CommonException {
		HashMap<String, String> latLng = new HashMap<String, String>();
		latLng = Utility.getLatlng(address);
		
		String _lat = latLng.get("lat");
		String _lng = latLng.get("lng");
		
		if ( _lat == null || _lng == null) { 
			System.out.println("주소가 잘못되었습니다");
			return ;
		}
		Double lat = Double.valueOf(_lat);
		Double lng = Double.valueOf(_lng);
		
		System.out.println("[debug] 위도 :" + lat);
		System.out.println("[debug] 경도 :" + lng);
		
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		ArrayList<ShopLoc> shopLocList = new ArrayList<ShopLoc>();
		dao.searchShopLocList(conn, shopLocList);
		JdbcTemplate.close(conn);
		
		double locLat = 0;
		double locLng = 0;
		
		for (ShopLoc shopLocaion : shopLocList) {
			Double shopLat = Double.valueOf(shopLocaion.getShopLocLat());
			Double shopLng = Double.valueOf(shopLocaion.getShopLocLng());
			System.out.println("[debug]상점위도 :" + shopLat);
			System.out.println("[debug]상점경도 :" + shopLng);
			
			locLat = shopLat-lat;
			locLng = shopLng-lng;
			
			//지역에 포함된다면
			if (Math.abs(locLat) <= 0.05 && Math.abs(locLng) <= 0.05) {
				throw new CommonException();
			}
		}
		shopLoc.setShopLocLat(_lat);
		shopLoc.setShopLocLng(_lng);
		
		conn = JdbcTemplate.getConnection();
		try {
			dao.addShopLoc(conn, shopLoc);
			dao.addMemberLoc(conn, shopLoc);
			
			JdbcTemplate.commit(conn);
		} catch(CommonException e) {
			JdbcTemplate.rollback(conn);
			throw e;
		} finally {
			
			JdbcTemplate.close(conn);
		}
	}

	public void getShopLocList(ArrayList<ShopLoc> shopLocList) {
		TakeitDao dao = TakeitDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();

		dao.searchShopLocList(conn, shopLocList);
	}
}
