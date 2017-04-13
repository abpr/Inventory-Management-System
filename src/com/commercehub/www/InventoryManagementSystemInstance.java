package com.commercehub.www;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManagementSystemInstance implements InventoryManagementSystem {

	protected static ConcurrentHashMap<String, Product> inventory = new ConcurrentHashMap<String, Product>();
	protected static ConcurrentHashMap<String, Person> securityVerification = new ConcurrentHashMap<String, Person>();
	protected static List<TransactionResult> listOfTransactions = new ArrayList<TransactionResult>();
	
	/*
	Picks product from inventory
	*/
	public PickingResult pickProduct(String productId, int amountToPick) {
		Product currentPickedProduct = inventory.get(productId);
		int newLevel = currentPickedProduct.getProductLevel() - amountToPick;
		currentPickedProduct.setProductLevel(newLevel);
		Date dateToday = Calendar.getInstance().getTime();
		PickingResult pickingResult = new PickingResult(true, null, dateToday, productId);
		return pickingResult;
	}
	
	/*
	Restocks products into inventory
	*/
	public RestockingResult restockProduct(String productId, int amountToRestock) {
		Product currentProduct = inventory.get(productId);
		int newLevel = currentProduct.getProductLevel() + amountToRestock;
		currentProduct.setProductLevel(newLevel);
		// successfully updated
		Date dateToday = Calendar.getInstance().getTime();
		RestockingResult restockingResult = new RestockingResult(true, null, dateToday, productId);
		return restockingResult;
	}

	/*
	Searches Products in inventory
	*/
	public SearchResult searchProduct(String productID) {
		//assuming we checked if the value is already present in inventory
		//System.out.println("in search method");
		Product searchedProduct = inventory.get(productID);
		System.out.println(searchedProduct);
		searchedProduct.toString();
		boolean searchStatus = false;
		if (searchedProduct != null)
			searchStatus = true;
		Date dateToday = Calendar.getInstance().getTime();
		SearchResult searchResult = new SearchResult(searchStatus, null, dateToday, productID);
		return searchResult;
	}
	
	/*
	Displays products in inventory
	*/
	public DisplayResult displayProduct() {
		//return all the product IDs as a string
		String inventoryEntries = inventory.entrySet().toString();
		boolean status = false;
		if(inventoryEntries != null)
			status = true;
		Date dateToday = Calendar.getInstance().getTime();
		DisplayResult displayResult  = new DisplayResult(status, null, dateToday, inventoryEntries);
		System.out.println(inventoryEntries);
		return displayResult;
	}
	
}