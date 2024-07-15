package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@Override							// req요청				// resp응답 
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = "김준일";
//		
//		resp.setContentType("text/html"); // 응답될 데이터의 타입
//		resp.setCharacterEncoding("utf-8");
//		
//		resp.getWriter().println(""
//				+ "<html>"
//				+ "<head>"
//				+ "<title>hello</title>"
//				+ "</head>"
//				+ "<body>"
//				+ "<h1>Hello Servlet!!!</h1>"
//				+ "<h2>" + name + "</h2>"
//				+ "</body>"
//				+ "</html>");
//	}
	
	
		@Override  // 서블릿을 통해서 캡슐화를 거친다.
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// Parameter는 무조건 문자열로 들어감
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			
			System.out.println(name);
			System.out.println(age);
			
			// getRequestDispatcher: req로 들어온걸 연결시켜줌
			req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
		}
	
}
