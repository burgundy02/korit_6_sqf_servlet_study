package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Producer;
import com.study.dvd.utill.DBConnectionMgr;

public class ProducerDao {
	// 싱글톤으로 객체 가지고 옴
   private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
   
   									// searchProducerByProducerName 이 메소드가 호출될 때 필요한 매개변수()
   public static List<Producer> searchProducerByProducerName(String searchText) {
	   // db에 있는거 다 여기에 넣어줘야 함
      List<Producer> producers = new ArrayList<Producer>();
      
      // db연결할 때 필수 3개
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
    	  // db연결
         con = pool.getConnection();
         StringBuilder sql = new StringBuilder();
         sql.append("select * from producer_tb ");
         sql.append("where producer_name like ? limit 0, 50");
         pstmt = con.prepareStatement(sql.toString());
         pstmt.setString(1, "%" + searchText + "%"); // 이게 ?안에 들어감 // %양 옆에 붙이면 와일드 카드로 쓸 수 있음
         rs = pstmt.executeQuery(); // 쿼리결과가 rs들어감
         
         // 반복문 // rs가 호출될 떄 마다 row의 행이 바뀐다 -> 하나의 행을 객체로 만들어서 위의 List에 하나하나 담는다.
         while(rs.next()) {
            Producer producer = Producer.builder()
                  .producerId(rs.getInt(1))
                  .producerName(rs.getString(2))
                  .build();
            
            producers.add(producer);  // add해서 producer List에 담는다.
            
         }
      } catch (Exception e) {
         e.printStackTrace();
         // 객체 소멸시키기
      } finally {
         pool.freeConnection(con, pstmt, rs);
      }
      
      return producers;
   }
   
   
   						// saveProducer에(save로 줄임) producer객체 들어옴
   public static int save(Producer producer) {
	   int successCount = 0;
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		   con = pool.getConnection();
		   String sql = "insert into producer_tb values(0, ?)";
		   pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Statement 임포트 java,sql
		   pstmt.setString(1,  producer.getProducerName());
		   successCount = pstmt.executeUpdate();
		   rs = pstmt.getGeneratedKeys();
		   while(rs.next()) {
			   producer.setProducerId(rs.getInt(1)); // 키 값이 첫 번쨰 칼럼에 딱 하나 있을 것임
		   }
		   
	} catch (Exception e) {
		
	}finally {
		pool.freeConnection(con, pstmt, rs);
	}
	   
	   return successCount;
   	}
   
   
}
