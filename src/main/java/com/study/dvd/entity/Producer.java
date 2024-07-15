package com.study.dvd.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Producer {
	// 기준: 데이터베이스 테이블안에 들어있는 id, name을 만듦
   private int producerId;
   private String producerName;
}