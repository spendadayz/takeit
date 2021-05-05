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
import com.takeit.model.biz.SellerBiz;
import com.takeit.model.biz.TakeitBiz;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;
import com.takeit.model.dto.ShopLoc;

/**
 * 판매자 회원관리 컨트롤러
 */
@WebServlet(urlPatterns = {"/seller/controller"})
public class FrontSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = (String) application.getAttribute("CONTEXT_PATH");	
	}	 
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		switch(action) {
		case "sellerInputForm":
			sellerInputForm(request, response);
			break;
		case "sellerInput":
			sellerInput(request, response);
			break;
		case "sellerLogin":
			sellerLogin(request, response);
			break;
		case "sellerLogout":
			sellerLogout(request, response);
			break;
		case "sellerFindId":
			sellerFindId(request, response);
			break;
		case "sellerFindPw":
			sellerFindPw(request, response);
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void sellerInputForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TakeitBiz takeitBiz = new TakeitBiz();
		
		ArrayList<ShopLoc> shopLocList = new ArrayList<>();
		takeitBiz.getShopLocList(shopLocList);
		System.out.println(shopLocList.get(0).getShopLocName());
		request.setAttribute("shopLocList", shopLocList);
		
//		ItemBiz itemBiz = new ItemBiz();
//		
//		ArrayList<ItemCategory> itemCategoryList = new ArrayList<>();
//		itemBiz.getItemCategoryList(itemCategoryList);
//		request.setAttribute("itemCategoryList", itemCategoryList);
//		
		request.getRequestDispatcher("/seller/sellerInput.jsp").forward(request, response);
	}
	
	
	/**
	 * 판매자 회원가입
	 */
	protected void sellerInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동확인 : sellerInput");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");

		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String sellerNo = request.getParameter("sellerNo");
		String shopMobile = request.getParameter("shopMobile");
		String shopName = request.getParameter("shopName");
		String shopKakaoId = request.getParameter("shopKakaoId");
		String shopImg = request.getParameter("shopImg");
		String shopCategoryNo = request.getParameter("shopCategoryNo");

		System.out.println(sellerId);
		System.out.println(sellerPw);
		System.out.println(name);
		System.out.println(mobile);
		System.out.println(email);
		System.out.println(postNo);
		System.out.println(address);
		System.out.println(addressDetail);
		System.out.println(shopMobile);
		System.out.println(shopName);
		System.out.println(shopKakaoId);
		System.out.println(shopImg);
		System.out.println(shopCategoryNo);
		
		Seller dto = new Seller(sellerId, sellerPw, name, mobile, email, postNo, address, addressDetail, sellerNo, shopMobile, shopName, shopKakaoId, shopImg, shopCategoryNo);
		
		SellerBiz biz = new SellerBiz();
		
		try {
			biz.addSeller(dto);
			if(dto.getSellerId() != null) {
				MessageEntity message = new MessageEntity("success", 0);
				message.setUrl("/takeit/member/memberLogin.jsp");
				message.setLinkTitle("로그인");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 0);
				message.setLinkTitle("뒤로가기");
				message.setUrl(CONTEXT_PATH + "/seller/sellerInput.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			//e.printStackTrace();
			//MessageEntity message = e.getMessageEntity();
			MessageEntity message = new MessageEntity("error", 0);
			message.setLinkTitle("뒤로가기");
			message.setUrl(CONTEXT_PATH + "/seller/sellerInput.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
	
	/**
	 * 로그인
	 */
	protected void sellerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동확인 : sellerLogin");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		RequestDispatcher rdIndex = request.getRequestDispatcher("/index.jsp");
		
		String sellerId = request.getParameter("sellerId");
		String sellerPw = request.getParameter("sellerPw");
		
		System.out.println(sellerId);
		System.out.println(sellerPw);
		
		Seller dto = new Seller();
		
		SellerBiz biz = new SellerBiz();
		
		dto.setSellerId(sellerId);
		dto.setSellerPw(sellerPw);
		
		try {
			biz.login(dto);
			
			if(dto.getAddress() != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("sellerId", sellerId); 
				session.setAttribute("dto", dto); 			
				rdIndex.forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 5);
				message.setLinkTitle("뒤로가기");
				message.setUrl(CONTEXT_PATH + "/seller/sellerLogin.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			//e.printStackTrace();
			//MessageEntity message = e.getMessageEntity();
			MessageEntity message = new MessageEntity("error", 5);
			message.setLinkTitle("뒤로가기");
			message.setUrl(CONTEXT_PATH + "/seller/sellerLogin.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}

	/**
	 * 로그아웃
	 */
	protected void sellerLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("작동확인 : sellerLogout");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		
		HttpSession session = request.getSession(false);
		
		session.removeAttribute("dto");
		
		session.invalidate();
	
		MessageEntity message = new MessageEntity("success", 2);
		message.setUrl("/takeit/index.jsp");
		message.setLinkTitle("처음으로");
		request.setAttribute("message", message);
		rd.forward(request, response);
	}
	
	/**
	 * 아이디 찾기
	 */
	protected void sellerFindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동 확인 : sellerFindId");

		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(name);
		System.out.println(email);
		
		SellerBiz biz = new SellerBiz();
		Seller dto = new Seller();

		dto.setName(name);
		dto.setEmail(email);
		
		try {
			System.out.println("확인");
			biz.idFind(dto);
			//if(dto.getMemberId() != null){
				request.setAttribute("idInfo", dto.getSellerId());
				request.setAttribute("entryDate", dto.getEntryDate());
				request.getRequestDispatcher("/member/idFindMessage.jsp").forward(request, response);;
//			}else {
//				MessageEntity message = new MessageEntity("error", 6);
//				message.setLinkTitle("뒤로가기");
//				message.setUrl("memberFindId.jsp");
//				request.setAttribute("message", message);
//				rd.forward(request, response);
//			}
		}catch (CommonException e) {
			e.printStackTrace();
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("뒤로가기");
			message.setUrl("memberFindId.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
	
	/**
	 * 비밀번호 찾기
	 */
	protected void sellerFindPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("작동 확인 : sellerFindPw");

		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		
		String sellerId = request.getParameter("sellerId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(sellerId);
		System.out.println(name);
		System.out.println(email);

		SellerBiz biz = new SellerBiz();
		Seller dto = new Seller();

		dto.setSellerId(sellerId);
		dto.setName(name);
		dto.setEmail(email);
		
		try {
			System.out.println("확인");
			biz.pwFind("dto", dto);
			if(dto.getSellerPw() != null) {
				request.setAttribute("pwInfo", dto.getSellerPw());
				request.getRequestDispatcher("/member/pwFindMessage.jsp").forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 6);
				message.setLinkTitle("뒤로가기");
				message.setUrl("sellerFindPw.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			e.printStackTrace();
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("뒤로가기");
			message.setUrl("sellerFindPw.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
}
