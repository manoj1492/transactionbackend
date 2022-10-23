package com.app.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Region {

	@JsonProperty("Port Louis")
	PORTLOUIS,
	@JsonProperty("Curepipe")
	CUREPIPE,
	@JsonProperty("Vacoas")
	VACOAS,
	@JsonProperty("Port Mathurin")
	PORTMATHURIN;
	
	public Region[] getValues() {
		return Region.values();
	}
}
