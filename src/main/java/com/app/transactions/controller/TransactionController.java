package com.app.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.transactions.model.Transaction;
import com.app.transactions.model.TransactionList;
import com.app.transactions.model.TransactionResponse;
import com.app.transactions.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Object> getAllTransactions(@PathVariable("id") String id){
		List<Transaction> transactionList= service.getAllTransactions(id);
		TransactionResponse response = new TransactionResponse();
		TransactionList transactionListData = new TransactionList();
		transactionListData.setTransactions(transactionList);
		transactionListData.setCount(Long.valueOf(transactionList.size()));
		response.setData(transactionListData);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> login(){
		String loginStatus = "Login Successful";
		TransactionResponse response = new TransactionResponse();
		response.setData(loginStatus);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
}
