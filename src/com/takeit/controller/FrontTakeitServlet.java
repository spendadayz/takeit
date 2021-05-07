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
import com.takeit.model.biz.TakeitBiz;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;
import com.takeit.model.dto.Seller;
import com.takeit.model.dto.ShopLoc;
import com.takeit.model.dto.Takeit;
import com.takeit.model.dto.TakeitItem;

/**
 * 잇거래 요청 컨트롤러
 * @author 김태경
 */
@WebServlet("/takeit/takeitController")
public class FrontTakeitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = application.getContextPath();
	}
	
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
		case "takeitItemList":
			takeitItemList(request, response);
			break;
		case "takeitItemDetail":
			takeitItemDetail(request, response);
			break;
		case "shopLocInputForm":
			shopLocInputForm(request, response);
			break;
		case "shopLocInput":
			shopLocInput(request, response);
			break;
		case "takeitInputForm":
			takeitInputForm(request, response);
			break;
		case "takeitInput":
			takeitInput(request, response);
			break;
		}
	}
	
	/** 잇거래 등록 요청 서비스 */
	protected void takeitInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("dto") == null) {
			MessageEntity message = new MessageEntity("message", 0);
			message.setLinkTitle("로그인");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		String shopLocCode = request.getParameter("shopLocCode");
		String takeitPrice = request.getParameter("takeitPrice");
		
		if (shopLocCode == null || shopLocCode.trim().length() == 0 ||
				takeitPrice == null || takeitPrice.trim().length() == 0) {
			MessageEntity message = new MessageEntity("validation", 4);
			message.setLinkTitle("잇거래 등록");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=takeitInputForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		shopLocCode = shopLocCode.trim();
		takeitPrice = takeitPrice.trim();
		
		Takeit dto = new Takeit();
		dto.setShopLocCode(shopLocCode);
		dto.setTakeitPrice(takeitPrice);
		
		TakeitBiz biz = new TakeitBiz();
		
		try { 
			biz.addTakeit(dto);
			
			MessageEntity message = new MessageEntity("success", 7);
			message.setLinkTitle("마이페이지");
			message.setUrl(CONTEXT_PATH + "/member/myPage.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (CommonException e) {
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("잇거래 등록");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=takeitInputForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
	/** 잇거래 등록 화면 요청 서비스 */
	protected void takeitInputForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("dto") == null) {
			MessageEntity message = new MessageEntity("message", 0);
			message.setLinkTitle("로그인");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		TakeitBiz biz = new TakeitBiz();
		ArrayList<ShopLoc> shopLocList = new ArrayList<ShopLoc>();
		
		try {
			biz.getShopLocList(shopLocList);
			request.setAttribute("shopLocList", shopLocList);
			request.getRequestDispatcher("/takeit/takeitInput.jsp").forward(request, response);
		} catch (CommonException e) {
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("잇거래 등록");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=takeitInputForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	
	/** 상점구역 등록 요청 서비스 */
	protected void shopLocInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("dto") == null) {
			MessageEntity message = new MessageEntity("message", 0);
			message.setLinkTitle("로그인");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		String address = request.getParameter("address");
		String shopLocCode = request.getParameter("shopLocCode");
		String shopLocName = request.getParameter("shopLocName");
		
		if (address == null || address.trim().length() == 0 ||
				shopLocCode == null || shopLocCode.trim().length() == 0 ||
				shopLocName == null || shopLocName.trim().length() == 0) {
			MessageEntity message = new MessageEntity("validation", 4);
			message.setLinkTitle("상점구역 등록");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=shopLocInputForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		address = address.trim();
		shopLocCode = shopLocCode.trim();
		shopLocName = shopLocName.trim();
		
		ShopLoc shopLoc = new ShopLoc();
		shopLoc.setShopLocCode(shopLocCode);
		shopLoc.setShopLocName(shopLocName);
		
		TakeitBiz biz = new TakeitBiz();
		
		try {
			biz.addShopLoc(address, shopLoc);
			MessageEntity message = new MessageEntity("success", 7);
			message.setLinkTitle("마이페이지");
			message.setUrl(CONTEXT_PATH + "/member/myPage.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (CommonException e) {
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("상점구역 등록");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=shopLocInputForm");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	
	/** 상점구역 등록화면 요청 서비스 */
	protected void shopLocInputForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("dto") == null) {
			MessageEntity message = new MessageEntity("message", 0);
			message.setLinkTitle("로그인");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/takeit/shopLocInput.jsp").forward(request, response);
	}
	
	/** 잇거래상품 상세조회 요청 서비스 */
	protected void takeitItemDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String itemNo = request.getParameter("itemNo");
		
		if (itemNo == null || itemNo.trim().length() == 0) {
			MessageEntity message = new MessageEntity("error", 12);
			message.setLinkTitle("잇거래");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=takeitItemList");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		itemNo = itemNo.trim();
		
		TakeitItem takeitItem = new TakeitItem();
		takeitItem.setItemNo(itemNo);
		
		TakeitBiz biz = new TakeitBiz();
		
		try {
			biz.getTakeitItem(takeitItem);
			
			request.setAttribute("takeitItem", takeitItem);
			request.getRequestDispatcher("/takeit/takeitItemDetail.jsp").forward(request, response);
		} catch (CommonException e) {
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("잇거래");
			message.setUrl(CONTEXT_PATH + "/takeit/takeitController?action=takeitItemList");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	
	/** 테이크잇 상품목록 요청 서비스	*/
	protected void takeitItemList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scope = request.getParameter("scope");
		if (scope != null) {
			application.setAttribute("takeitScope", scope);
		}
		HttpSession session = request.getSession(false);
		if (application.getAttribute("takeitScope").equals("my") && (session == null || session.getAttribute("dto") == null)) {
			MessageEntity message = new MessageEntity("message", 0);
			message.setLinkTitle("로그인");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		if (session == null || session.getAttribute("dto") == null) {
			application.setAttribute("takeitScope", "all");
		}
		
		String takeitScope = (String)application.getAttribute("takeitScope");
		ArrayList<TakeitItem> takeitItemList = new ArrayList<TakeitItem>();
		TakeitBiz biz = new TakeitBiz();
		
		switch (takeitScope) {
		case "all":
			try {
				biz.getTakeitItemList(takeitItemList); 
				
				request.setAttribute("takeitItemList", takeitItemList);
				request.getRequestDispatcher("/takeit/takeitItemList.jsp").forward(request, response);
			} catch (CommonException e) {
				MessageEntity message = e.getMessageEntity();
				message.setLinkTitle("메인으로");
				message.setUrl(CONTEXT_PATH + "/index");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			break;
		case "my":
			Object dto = session.getAttribute("dto");
			String shopLocCode = null;
			String memberLocNo = null;
			Member member = null;
			
			if (dto instanceof Member) {
				shopLocCode = ((Member)dto).getShopLocCode();
				memberLocNo = ((Member)dto).getMemberLocNo();
				
				member = new Member();
				member.setShopLocCode(shopLocCode);
				member.setMemberLocNo(memberLocNo);
			} else if (dto instanceof Seller) {
				shopLocCode = ((Seller)dto).getShopLocCode();
			}
			
			if (shopLocCode == null) {
				shopLocCode = "none";
			}
			if (memberLocNo == null) {
				memberLocNo = "none";
			}
			
			takeitItemList = new ArrayList<TakeitItem>();
			biz = new TakeitBiz();
			
			try {
				if (dto instanceof Member) {
					biz.getTakeitItemList(member, takeitItemList); 
				} else if (dto instanceof Seller) {
					biz.getTakeitItemList(shopLocCode, takeitItemList);
				}
				request.setAttribute("takeitItemList", takeitItemList);
				request.getRequestDispatcher("/takeit/takeitItemList.jsp").forward(request, response);
			} catch (CommonException e) {
				MessageEntity message = e.getMessageEntity();
				message.setLinkTitle("메인으로");
				message.setUrl(CONTEXT_PATH + "/index");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			break;
		}
	}
}


