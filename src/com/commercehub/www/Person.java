package com.commercehub.www;
/*
Person declared as class, to enable further specializing of various roles
*/

public class Person {
	private String personID;
	private String personName;
	private String designation;
	private String password;
	
	public Person(String id, String name, String designation, String password)
	{
		this.personID = id;
		this.personName = name;
		this.designation =designation;
		this.password = password;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
