package com.commercehub.www;

import java.util.Date;
/*
Contains details regarding to a picking Result
*/
class PickingResult extends TransactionResult {

	private String type;
	
	public PickingResult(boolean result, String personID, Date transactionDate, String productID)
	{
		this.type = "PICK_PRODUCT";
		this.setResult(result);
		this.setPersonID(personID);
		this.setTransactionDate(transactionDate);
		this.setProductID(productID);
	}
	
	public String getType() {
		return type;
	}

}
