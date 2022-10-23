package com.app.transactions.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionList {
	
	private List<Transaction> transactions;
	private Long count;

}
