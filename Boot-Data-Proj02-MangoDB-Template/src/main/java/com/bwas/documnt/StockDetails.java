package com.bwas.documnt;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Stock_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDetails {
	@Id
	private String id;
	private Integer stockId;
	private String stockName;
	private Double stockPrice;
	private String exchange;
	private LocalDateTime tradingTime;
	private Boolean isListed;
}
