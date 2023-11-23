package com.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.api.service.OrderService;
import com.ps.common.TransactionRequest;
import com.ps.common.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService oservice;
	
	@PostMapping("/bookorder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest req) {
		return oservice.saveorder(req);
	}
}
