package com.takeit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeit.model.biz.BoardBiz;

/**
 * 게시판 관리 컨트롤러
 */
@WebServlet("/boardController")
public class FrontBoardServlet extends HttpServlet {
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
		case "boardList":
			boardList(request, response);
			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request, response);
//			break;
//		case "":
//			(request,response);
//			break;
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

	protected void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[debug]게시글 전체 조회 요청");
		
		BoardBiz biz = new BoardBiz();
		request.setAttribute("boards", biz.getBoardList());
		request.getRequestDispatcher("/mms04/boardList.jsp").forward(request, response);
	}

}
