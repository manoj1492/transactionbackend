package com.app.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {
	private Long customerId;
	private String name;
	private String address;
	private Long phone;
	private Long accountNum;

}
