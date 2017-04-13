package com.commercehub.www;

import java.util.Date;
/*
Contains details regarding to a display Result
*/
public class DisplayResult extends TransactionResult{
	private String type;
	
	public DisplayResult(boolean result, String personID, Date transactionDate, String productList)
	{
		//the type of transaction is unique to each child class
		this.type = "DISPLAY";
		this.setResult(result);
		this.setPersonID(personID);
		this.setTransactionDate(transactionDate);
		this.setProductID(productList);
	}
	public String getType() {
		return type;
	}

	
}
