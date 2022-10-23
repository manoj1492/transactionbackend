package com.app.transactions.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.app.transactions.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
public class TransactionService {
	
	@Value("classpath:data/data.json")
	private Resource transactionsData;
	
	public List<Transaction> getAllTransactions(String customerId){
		List<Transaction> transactionList = new ArrayList<>();
		try {
			InputStream stream = transactionsData.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			String transactionsString = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"));
			TypeFactory typeFactory = mapper.getTypeFactory();
			transactionList = mapper.readValue(transactionsString, typeFactory.constructCollectionType(List.class, Transaction.class));
			transactionList = transactionList.stream().filter(x-> x.getCustomerInfo().getCustomerId().equals(Long.valueOf(customerId))).collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionList;
	}
	
	

}
