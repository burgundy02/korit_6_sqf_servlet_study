package com.study.dvd.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Dvd {
	private int dvdId;
	private String registrationNumber;
	private String title;
	private int producerId;
	private String producerName;
	private int publisherId;
	private String publisherName;
	private int publicationYear;
	private LocalDate databaseDate;
}
