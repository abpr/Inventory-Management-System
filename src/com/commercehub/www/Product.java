package com.commercehub.www;
/*
Product object to enable further addition of data members and member functions
*/
public class Product {
	
	private String productID;
	private String productName;
	private float productPrice;
	private int productLevel;
	private String productLocation;
	
	public Product(String productID, String productName, float price, int level, String location)
	{
		this.productID = productID;
		this.productName = productName;
		this.productLevel = level;
		this.productLocation = location;
		this.productPrice = price;
	}
	
	//overriding the toString method to print the inventory
	public String toString()
	{
		return "\nProduct ID:\t"+productID+"|Product Name:\t"+productName+"|Product Level:\t"+productLevel+"|Product Location:\t"+productLocation+"|Product Price:\t"+productPrice+"\n";
	}
	public void setProductID(String pID)
	{
		this.productID = pID;
	}
	public void setProductName(String name)
	{
		this.productName = name;
	}
	public void setProductPrice(float price)
	{
		this.productPrice = price;
	}
	public void setProductLevel(int quantity)
	{
		this.productLevel = quantity;
	}
	public void setProductLocation(String location)
	{
		this.productLocation = location;
	}
	public String getProductID()
	{
		return this.productID;
	}
	public String getProductName()
	{
		return this.productName;
	}
	public String getProductLocation()
	{
		return this.productLocation;
	}
	public int getProductLevel()
	{
		return this.productLevel;
	}
	public float getProductPrice()
	{
		return productPrice;
	}

}
