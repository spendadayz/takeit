package com.takeit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeit.common.CommonException;
import com.takeit.model.biz.ItemBiz;
import com.takeit.model.dto.Item;
import com.takeit.model.dto.MessageEntity;


/**
 * 상품관리를 위한 FrontController servlet
 */
@WebServlet("/item/itemController")
public class FrontItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서버구동시에 해당 어플리케이션당 한개의 한개의 환경설정 
		public ServletContext application;
		public String CONTEXT_PATH;
		
		public void init() {
			application = getServletContext();
			CONTEXT_PATH = application.getContextPath();
			System.out.println("[loadOnStartup]CONTEXT_PATH : " + CONTEXT_PATH);
			application.setAttribute("CONTEXT_PATH", CONTEXT_PATH);
		}
		

		protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			request.setCharacterEncoding("utf-8");
			switch(action) {
			case "itemEnrollForm":
				itemEnrollForm(request, response);
				break;
			case "itemEnroll":
				itemEnroll(request, response);
				break;
			case "itemList":
				itemList(request, response);
				break;
			case "itemDetail":
				itemDetail(request, response);
				break;
			case "deleteItem":
				deleteItem(request, response);
				break;
			case "SellerItemForm":
				SellerItemForm(request,response);
				break;
				//		case "SellerItemForm":
				//			SellerItemForm(request,response);
				//				break;
				//		case "SellerItemForm":
				//			SellerItemForm(request,response);
				//				break;
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	//상품등록 페이지 요청 서비스
	protected void itemEnroll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemCategoryName = request.getParameter("itemCategoryName");
		String sellerId = request.getParameter("sellerId");
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemOrigin = request.getParameter("itemOrigin");
		String itemStock = request.getParameter("itemStock");
		String itemImg = request.getParameter("itemImg");
		String itemTakeIt = request.getParameter("itemTakeIt");
		String packTypeName = request.getParameter("packTypeName");
		String expirationDate = request.getParameter("expirationDate");
		String notice = request.getParameter("notice");
		String freshPercent = request.getParameter("freshPercent");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/takeit/message.jsp");
		
		if (itemCategoryName == null || itemCategoryName.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		}    

		
		if (sellerId == null || sellerId.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		}   

		
		if (itemName == null || itemName.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		} 
		
		if (itemPrice == null || itemPrice.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
		} 
		
		if (itemOrigin == null || itemOrigin.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
			messageEntity.setLinkTitle("상품등록");
			messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
			request.setAttribute("messageEntity", messageEntity);
			dispatcher.forward(request, response);
			return;
	        
		}
	  		if (itemStock == null || itemStock.trim().length() == 0) {
			MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;   	
	          
	  		}
	  		if (itemImg == null ) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
					messageEntity.setLinkTitle("상품등록");
					messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
					request.setAttribute("messageEntity", messageEntity);
					dispatcher.forward(request, response);
					return;
	  		} 
			if (itemTakeIt == null || itemTakeIt.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}	
			if (packTypeName == null || packTypeName.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (expirationDate == null || expirationDate.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (notice == null || notice.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}    
			if (freshPercent == null || freshPercent.trim().length() == 0) {
				MessageEntity messageEntity = new MessageEntity("validation", 6);
				messageEntity.setLinkTitle("상품등록");
				messageEntity.setUrl(CONTEXT_PATH + "/item/itemEnrollForm");
				request.setAttribute("messageEntity", messageEntity);
				dispatcher.forward(request, response);
				return;
			}       
	          
//			   Item dto = new Item(itemCategoryName, sellerId, itemName, itemPrice, itemOrigin,itemStock,itemImg,
//					   itemTakeIt,packTypeName,expirationDate,notice,freshPercent);
//			       
//
//		ItemBiz biz = new ItemBiz();
//
//	      try {
//	          biz.addItem(dto);
//	          
//	          MessageEntity message = new MessageEntity("success", 0);
//	          message.setUrl("/exercise/exe02/teacher/login.html");
//	          message.setLinkTitle("");
//	          request.setAttribute("message", message);
//	          RequestDispatcher rd = request.getRequestDispatcher("/exe02/teacher/message.jsp");
//	          rd.forward(request, response);
//	       } catch (CommonException e) {
//	          MessageEntity message = e.getMessageEntity();
//	       
//	          message.setLinkTitle("상품등록");
//	          message.setUrl(CONTEXT_PATH + "/exe02/controller?action=enrollItemForm");
//	          request.setAttribute("message", message);
//	          request.getRequestDispatcher("/takeit/item/message.jsp").forward(request, response);
//	          
//	       }
//	       
//	    }
	}
	//상품등록요청
		protected void itemEnrollForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String url = CONTEXT_PATH + "/item/itemEnroll.jsp";
			response.sendRedirect(url); 
		}

		/**
		 * 상품전체조회
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void itemList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			ArrayList<Item> itemList = new ArrayList<Item>();
			ItemBiz biz = new ItemBiz();
			try {
				biz.getItemList(itemList);
				if(itemList != null) {
					request.setAttribute("itemList",itemList);
					request.getRequestDispatcher("/item/newItem.jsp").forward(request, response);
				}
			} catch (CommonException e) {
				MessageEntity message = new MessageEntity("error", 24);
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		
}
//		
//		
//		protected void itemList1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//			ArrayList<Item> itemList = new ArrayList<Item>();
//			ItemBiz biz = new ItemBiz();
//			try {
//				biz.getItemList(itemList);
//			} catch (CommonException e) {
//				e.printStackTrace();
//			}
//			request.setAttribute("itemList", itemList);
//			request.getRequestDispatcher("/takeit/item/itemList.jsp").forward(request, response);
//		}		
	

		/**
		 * 상품삭제
		 * @param conn
		 * @param dto
		 */
		protected void deleteItem (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession(false);
			
			String sellerId = request.getParameter("sellerId");
			String memberPw = request.getParameter("item_no");
			
			
			ItemBiz biz = new ItemBiz();
		}	

		/**
		 * 판매자 등록 상품 조회
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void SellerItemForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
//			HttpSession session = request.getSession(false);
			
//			String sellerId = (String)session.getAttribute("sellerId");
//			String sellerId = request.getParameter("sellerId");
			String sellerId = "seller04";
			
			ItemBiz biz = new ItemBiz();
			
			Item dto = new Item();
		   dto.setSellerId(sellerId);
			try {
				biz.getSellItem(dto);
				request.setAttribute("item", dto);
				request.getRequestDispatcher("/item/sellerItem.jsp").forward(request, response);
			
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}
		}	
		
		/**
		 * 상품상세조회
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void itemDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String itemNo = request.getParameter("itemNo");
			System.out.println("itemNo = "+itemNo);
		
			
			ItemBiz biz = new ItemBiz();
			
			Item dto = new Item();
			dto.setItemNo(itemNo);
			try {
				biz.getItem(dto);
				System.out.println("dto.판매자 = "+ dto.getSellerName());
				System.out.println("dto= "+ dto);
				
				request.setAttribute("item", dto);
				request.getRequestDispatcher("/item/itemDetail.jsp").forward(request, response);
			} catch (CommonException e) {
				e.printStackTrace();
			}
			
			
		}		
		
		
//		/**
//		 *등록 상품수정
//		 * @param request
//		 * @param response
//		 * @throws ServletException
//		 * @throws IOException
//		 */
//		protected void setReviewInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//			String reviewTitle = request.getParameter("reviewTitle");
//			String reviewContents = request.getParameter("reviewContents");
//			String reviewScore = request.getParameter("reviewScore");
//			String reviewImg = request.getParameter("reviewImg");
//		
//
//			
//			ReviewBiz biz = new ReviewBiz();
//			
//			Review dto = new Review();
//			dto.setReviewTitle(reviewTitle);
//			dto.setReviewContents(reviewContents);
//			dto.setReviewScore(reviewScore);
//			dto.setReviewImg(reviewImg);
//
//			
//			try {
//				biz.setReview(dto);
//				request.setAttribute("dto", dto);
//				request.getRequestDispatcher("/review/reviewController?action=updateReviewForm").forward(request, response);
//				
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//			
//		}
				
}
