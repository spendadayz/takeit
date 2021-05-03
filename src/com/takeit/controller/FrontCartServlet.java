package com.takeit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeit.common.CommonException;
import com.takeit.model.biz.CartBiz;
import com.takeit.model.dto.Cart;
import com.takeit.model.dto.MessageEntity;

/**
 * 장바구니 관리 컨트롤러
 */
@WebServlet("/cartController")
public class FrontCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서버 구동시에 해당 어플리케이션당 한 개의 환경설정, 모든 서블릿(jsp)공유객체, 서버 종료시까지 사용
		public ServletContext application;
		public String CONTEXT_PATH;
		
		public void init() {
			application = getServletContext();
			CONTEXT_PATH = (String) application.getAttribute("CONTEXT_PATH");	
		}	   

		
		protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			request.setCharacterEncoding("utf-8");
			switch(action) {
			case "cartList":
				cartList(request,response);
				break;
//			case "":
//				(request,response);
//				break;
//			case "":
//				(request,response);
//				break;
//			case "":
//				(request,response);
//				break;
			}
		}



		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			process(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			process(request, response);
		}
		
		/**장바구니 전체 목록 조회*/
		private void cartList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("[dubug]장바구니 전체 목록 요청");
			HttpSession session = request.getSession(false);
			String memberId = (String)session.getAttribute("memberId");
			memberId = memberId.trim();
			
			CartBiz cbiz = new CartBiz();
			ArrayList<Cart> cartList = new ArrayList<Cart>(); 
			
			try {
				cbiz.getCartList(memberId, cartList);
				session.setAttribute("cartList", cartList);
				request.getRequestDispatcher("/item/cartList.jsp").forward(request, response);
			} catch (CommonException e) {
				MessageEntity message = new MessageEntity("error", 21);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
			
		}

}
