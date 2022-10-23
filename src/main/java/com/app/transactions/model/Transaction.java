package com.app.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private String reference;
	private CustomerInfo customerInfo;
	private Beneficiary beneficiary;
	private Double amount;
	private Currency currency;
	private String cardNum;
	private Region region;

}
