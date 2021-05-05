package com.takeit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.common.CommonException;
import com.takeit.model.biz.OrderBiz;
import com.takeit.model.dto.Order;
import com.takeit.model.dto.OrderDetail;

/**
 * Servlet implementation class FrontOrderServlet
 */
@WebServlet("/order/orderController")
public class FrontOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		switch (action) {
		case "order":
			order(request, response);
			break;
		case "orderList":
			orderList(request, response);
			break;
		case "sellerOrderList":
			sellerOrderList(request, response);
			break;
		}
	}
	protected void sellerOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sellerId = "seller01";
		
		OrderBiz biz = new OrderBiz();
		ArrayList<Order> orderList = new ArrayList<>();
		
		try {
			biz.getSellerOrderList(sellerId, orderList);
			
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("/order/sellerOrderList.jsp").forward(request, response);
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}
	
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = (String)request.getSession(false).getAttribute("memberId"); 
		memberId = "user01";
		//상품
//		String itemTakeit = request.getParameter("itemTakeit");
//		//주문상세
//		String[] itemNos= request.getParameterValues("itemNo");
//		String[] _itemQtys = request.getParameterValues("itemQty");
//		String[] _itemPayPrices = request.getParameterValues("itemPayPrice");
		//주문
//		String _orderPrice = request.getParameter("orderPrice");
//		//배송
//		String shipStatusCode = request.getParameter("shipStatusCode");
//		//수령인
//		String receiveMethod = request.getParameter("receiveMethod");
//		String recipientName = request.getParameter("recipientName");
//		String recipientPostNo = request.getParameter("recipientPostNo");
//		String recipientAddr = request.getParameter("recipientAddr");
//		String recipientMobile = request.getParameter("recipientMobile");
//		String shipRequest = request.getParameter("shipRequest");

		//상품
		String itemTakeit = "T";
		//주문
		String _orderPrice = "21000";		
		//주문상세
		String[] _itemNos= {"FR000002", "BF000003"};
		
		String[] _itemQtys = {"2", "3"};
		String[] _itemPayPrices = {"3000", "5000"};	
		//수령인
		String receiveMethod = "배송";
		String recipientName = "홍길동";
		String recipientPostNo = "12345";
		String recipientAddr = "경기도";
		String recipientMobile = "010-1234-1231";
		String shipRequest = "보내주세요";		
		//배송
		String shipStatusCode = "O-GET";
		
		
		
		Order order = new Order();
		ArrayList<OrderDetail> orderDetails = new ArrayList<>();
		OrderDetail orderDetail = null;
		for (int index = 0; index < _itemNos.length; index++) {
			orderDetail = new OrderDetail();
			orderDetail.setItemNo(_itemNos[index]);
			orderDetail.setItemQty(Integer.valueOf(_itemQtys[index]));
			orderDetail.setItemPayPrice(Integer.valueOf(_itemPayPrices[index]));
			orderDetails.add(orderDetail);
		}
		int orderPrice = Integer.valueOf(_orderPrice);
		
		order.setOrderDetails(orderDetails);
		
		order.setItemTakeit(itemTakeit);
		
		order.setOrderPrice(orderPrice);
		order.setMemberId(memberId);
		order.setReceiveMethod(receiveMethod);
		order.setRecipientName(recipientName);
		order.setRecipientPostNo(recipientPostNo);
		order.setRecipientAddr(recipientAddr);
		order.setRecipientMobile(recipientMobile);
		
		order.setShipRequest(shipRequest);
		order.setShipStatusCode(shipStatusCode);		
		
		OrderBiz biz = new OrderBiz();
		biz.addOrder(order);
		
	}
}
