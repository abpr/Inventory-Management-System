package com.commercehub.www;

import java.util.Date;
/*
Contains details regarding to a search Result
*/
public class SearchResult extends TransactionResult{
	
	private String type;
	
	public SearchResult(boolean result, String personID, Date transactionDate, String productID)
	{
		this.type = "SEARCH";
		this.setResult(result);
		this.setPersonID(personID);
		this.setTransactionDate(transactionDate);
		this.setProductID(productID);
	}
	

	public String getType() {
		return type;
	}

	}
