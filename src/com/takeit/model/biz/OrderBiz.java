package com.takeit.model.biz;

import java.sql.Connection;

import com.takeit.common.CommonException;
import com.takeit.common.JdbcTemplate;
import com.takeit.model.dao.OrderDao;
import com.takeit.model.dto.Order;

public class OrderBiz {

	public void addOrder(Order order) {
		OrderDao dao = OrderDao.getInstance();
		Connection conn = JdbcTemplate.getConnection();
		
		try {
			dao.insertOrder(conn, order);
			dao.selectOrderNo(conn, order);
			dao.insertOrderDetail(conn, order);
			
			JdbcTemplate.commit(conn);
		} catch (CommonException e) {
			JdbcTemplate.rollback(conn);
			e.printStackTrace();
		}
		JdbcTemplate.close(conn);
	}
}
