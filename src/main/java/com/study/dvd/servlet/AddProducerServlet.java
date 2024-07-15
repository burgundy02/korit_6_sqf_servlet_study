package com.study.dvd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dvd.dao.ProducerDao;
import com.study.dvd.entity.Producer;


@WebServlet("/producer/add")
public class AddProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/add_producer.jsp").forward(req, resp);
	}
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post요청때는 db에 영어가 아닌건 깨져서 들어간다 -> UTF-8로 해주기 // Encoding은 한글을쓸거면 req, resp에 필요
		req.setCharacterEncoding("UTF-8");
		String producerName = req.getParameter("producer");
		Producer producer = Producer.builder().producerName(producerName).build();
		// insert 완료
		boolean isSuccess = ProducerDao.save(producer) > 0; // return값이 0보다 크면 true
		req.setAttribute("isSuccess", isSuccess); // key, value는 true or false
		// insert후 여기로 페이지를 넘긴다
		req.getRequestDispatcher("/WEB-INF/views/add_producer_result.jsp").forward(req, resp);
	}
}
