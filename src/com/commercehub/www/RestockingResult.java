package com.commercehub.www;

import java.util.Date;
/*
Contains details regarding to a restocking Result
*/
public class RestockingResult extends TransactionResult{


	private String type;
	
	public RestockingResult(boolean result, String personID, Date transactionDate, String productID)
	{
		this.type = "RESTOCK_PRODUCT";
		this.setResult(result);
		this.setPersonID(personID);
		this.setTransactionDate(transactionDate);
		this.setProductID(productID);
	}
	
	public String getType() {
		return type;
	}

}
