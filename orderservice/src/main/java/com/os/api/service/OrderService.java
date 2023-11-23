package com.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.os.api.entity.Order;
import com.os.api.repository.OrderRepository;
import com.ps.common.Payment;
import com.ps.common.TransactionRequest;
import com.ps.common.TransactionResponse;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orepo;
	
	@Autowired
	private RestTemplate rest;
	
	public TransactionResponse saveorder(TransactionRequest req) {
		Order order=req.getOrder();
		Payment pay=req.getPayment();
		pay.setOrderId(order.getId());
		pay.setAmount(order.getPrice());
		//rest call
//		Payment response=rest.postForObject("http://localhost:8081/payment/dopayment", pay, Payment.class);
		Payment response=rest.postForObject("http://PAYMENT-SERVICE/payment/dopayment", pay, Payment.class);
		String message="success".equalsIgnoreCase(response.getPayemtnstatus())?"Payment is successful.":"Payment failed!!!";
		orepo.save(order);
		
		return new TransactionResponse(order,response.getTransactionid(),response.getAmount(),message);
	}

}
