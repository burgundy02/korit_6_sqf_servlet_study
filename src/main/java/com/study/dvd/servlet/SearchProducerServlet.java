package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

				// 1 이쪽으로 요청을 가져옴
@WebServlet("/producer/search")
public class SearchProducerServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /*
     * 1. 요청(enter) URL = /producer/search
     * 2. dao.ProducerDao   => searchProducerByProducerName()
     * 3. entity.Producer
     * 4. search_producer.jsp
     */
   
   // 2  주소창에다가 엔터치는 건 get요청
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 3: (엔터치고 요청한 다음에 jsp를 화면에 띄운다.) jsp파일과 연결해서 열어라 / forward해주면 jsp로 받는다.
      req.getRequestDispatcher("/WEB-INF/views/search_producer.jsp").forward(req, resp);
   }
   
   // 여기까지 URL입력하고 엔터치면 jsp파일 화면에 띄움

  
}