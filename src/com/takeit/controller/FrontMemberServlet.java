package com.takeit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.takeit.common.CommonException;
import com.takeit.model.biz.MemberBiz;
import com.takeit.model.dao.MemberDao;
import com.takeit.model.dto.Member;
import com.takeit.model.dto.MessageEntity;

/**
 * 일반 회원관리 컨트롤러
 */
@WebServlet(urlPatterns = {"/member/controller"}, loadOnStartup = 1)
public class FrontMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContext application;
	public String CONTEXT_PATH;
	
	public void init() {
		application = getServletContext();
		CONTEXT_PATH = application.getContextPath();
		System.out.println("[loadOnStartup]CONTEXT_PATH : " + CONTEXT_PATH);
		application.setAttribute("CONTEXT_PATH", CONTEXT_PATH);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String action = request.getParameter("action");
		
		switch(action) {
		case "memberInput":
			memberInput(request, response);
			break;
		case "memberLogin":
			memberLogin(request, response);
			break;
		case "memberLogout":
			memberLogout(request, response);
			break;
		case "memberFindId":
			memberFindId(request, response);
			break;
		case "memberFindPw":
			memberFindPw(request, response);
			break;
		case "memberIdChk":
			memberIdChk(request, response);
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * 일반 회원가입 
	 */
	protected void memberInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동확인 : memberInput");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String postNo = request.getParameter("postNo");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String birth = request.getParameter("birth");
				
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(name);
		System.out.println(mobile);
		System.out.println(email);
		System.out.println(postNo);
		System.out.println(address);
		System.out.println(addressDetail);
		System.out.println(birth);
		
		Member dto = new Member(memberId, memberPw, name, mobile, email, postNo, address, addressDetail, birth);
		
		MemberBiz biz = new MemberBiz();
				
		try {
			biz.addMember(dto);
		
			MessageEntity message = new MessageEntity("success", 0);
			message.setUrl("/takeit/member/memberLogin.jsp");
			message.setLinkTitle("로그인");
			request.setAttribute("message", message);
			rd.forward(request, response);
		
		} catch (CommonException e) {
			
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("뒤로가기");
			message.setUrl(CONTEXT_PATH + "/member/memberInput.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
	
	/**
	 * 로그인
	 */
	protected void memberLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동확인 : memberLogin");
		
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		RequestDispatcher rdIndex = request.getRequestDispatcher("/index.jsp");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println(memberId);
		System.out.println(memberPw);
		
		Member dto = new Member();
		
		MemberBiz biz = new MemberBiz();
		
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw);
		
		try {
			biz.login(dto);
			
			if(dto.getAddress() != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("memberId", memberId); 
				session.setAttribute("dto", dto); 			
				rdIndex.forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 5);
				message.setLinkTitle("뒤로가기");
				message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			//e.printStackTrace();
			//MessageEntity message = e.getMessageEntity();
			MessageEntity message = new MessageEntity("error", 5);
			message.setLinkTitle("뒤로가기");
			message.setUrl(CONTEXT_PATH + "/member/memberLogin.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}

	/**
	 * 로그아웃
	 */
	protected void memberLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("작동확인 : memberLogout");
		
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
	protected void memberFindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("작동 확인 : memberFindId");

		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(name);
		System.out.println(email);
		
		MemberBiz biz = new MemberBiz();
		Member dto = new Member();

		dto.setName(name);
		dto.setEmail(email);
		
		try {
			System.out.println("확인");
			biz.idFind(dto);
			//if(dto.getMemberId() != null){
				request.setAttribute("idInfo", dto.getMemberId());
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
	protected void memberFindPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("작동 확인 : memberFindPw");

		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		
		String memberId = request.getParameter("memberId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		System.out.println(memberId);
		System.out.println(name);
		System.out.println(email);

		MemberBiz biz = new MemberBiz();
		Member dto = new Member();

		dto.setMemberId(memberId);
		dto.setName(name);
		dto.setEmail(email);
		
		try {
			System.out.println("확인");
			biz.pwFind("dto", dto);
			if(dto.getMemberPw() != null) {
				request.setAttribute("pwInfo", dto.getMemberPw());
				request.getRequestDispatcher("/member/pwFindMessage.jsp").forward(request, response);
			}else {
				MessageEntity message = new MessageEntity("error", 6);
				message.setLinkTitle("뒤로가기");
				message.setUrl("memberFindPw.jsp");
				request.setAttribute("message", message);
				rd.forward(request, response);
			}
		} catch (CommonException e) {
			e.printStackTrace();
			MessageEntity message = e.getMessageEntity();
			message.setLinkTitle("뒤로가기");
			message.setUrl("memberFindPw.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}
	
	/**
	 * 아이디 중복체크
	 */
	protected void memberIdChk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		MemberBiz biz = new MemberBiz();

		try {
			int result = biz.idCheck(memberId);
			if(result == 1) {
				response.getWriter().write("1");
			}else {
				response.getWriter().write("0");
			}
		} catch (CommonException e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
}
