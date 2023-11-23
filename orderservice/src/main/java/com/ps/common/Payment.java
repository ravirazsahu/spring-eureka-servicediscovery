package com.ps.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	
	private int paymentid;
	private String payemtnstatus;
	private String transactionid;
	private int orderId;
	private double amount;
	
}
