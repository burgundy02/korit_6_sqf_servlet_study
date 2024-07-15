<%@page import="com.study.dvd.dao.ProducerDao"%>
<%@page import="com.study.dvd.entity.Producer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
   table, th, td {
      border: 1px solid #dbdbdb;
      border-collapse: collapse;
   }
   
   th, td {
      padding: 5px 10px;
   }
   
</style>

</head>
<body>
   <div>
      <label>제작사 검색</label>
      <input type="text" 
         class="search-input" 
         placeholder="제작사 이름을 입력하세요">
      <button onclick="handleSearchClick()">검색</button>
   </div>
   <%
		// forward했기때문에 request안에 들어있는 파라미터 쓸 수 있음
      String searchText = request.getParameter("searchText");
												// (st)검색어를 가지고 serch할거다
      List<Producer> producers = ProducerDao.searchProducerByProducerName(searchText);
   %>
   <table>
      <thead>
         <tr>
            <th>제작사_ID</th>
            <th>제작사</th>
         </tr>
      </thead>
      <tbody>
         <% // JSTL 라이브러리 사용해 됨
         	// for문 돌리면 검색 결과를 들고와서 화면에 보여 줌
            for(Producer producer : producers) {
         %>
            <tr>
               <td><%=producer.getProducerId() %></td>
               <td><%=producer.getProducerName() %></td>
            </tr>
         <%
            };
         %>
      </tbody>
   </table>
   <script src="/dvd/static/search_producer.js"></script>
</body>
</html>