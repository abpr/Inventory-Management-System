package com.commercehub.www;

import java.util.Scanner;

public class InventoryLauncher extends InventoryManagementSystemInstance implements Runnable {

	/*
	Performs verification and validation before picking a product
	*/
	public void performPick(InventoryManagementSystemInstance managerObject, String userName, Scanner in) {
		// pick products
		System.out.println("Enter the product ID:\n");
		String currProductID = new String();
		currProductID = in.next();
		// check if the product is there or not
		if (inventory.containsKey(currProductID)) {
			System.out.println("The level of Entered product is : "
					+ InventoryManagementSystemInstance.inventory.get(currProductID).getProductLevel());
			System.out.println("Enter the level to pick");
			int currentLevel = 0;
			String temp1 = in.next();
			while (!temp1.matches("\\d+") || (temp1.length() > 9)) {
				System.out.println("Enter valid Level\n");
				temp1 = in.next();
			}
			currentLevel = Integer.parseInt(temp1);
			// checking if its not negative
			while (currentLevel < 0 || currentLevel > InventoryManagementSystemInstance.inventory.get(currProductID)
					.getProductLevel()) {
				System.out.println("Enter valid Level\n");
				temp1 = in.next();
				if (temp1.matches("\\d+") && (temp1.length() <= 9)
						&& (Integer.parseInt(temp1) > 0
								&& Integer.parseInt(temp1) <= InventoryManagementSystemInstance.inventory
										.get(currProductID).getProductLevel()))
					break;
			}
			currentLevel = Integer.parseInt(temp1);
			PickingResult pickingResult = managerObject.pickProduct(currProductID, currentLevel);
			// updating the person who did the
			// transaction
			pickingResult.setPersonID(userName);
			listOfTransactions.add(pickingResult);
			if (pickingResult.isResult() == true)
				System.out.println("---------------------------\nSuccessfully Picked\n---------------------------");
			else
				System.out.println("---------------------------\nTransaction Failed\n---------------------------");
		} else {
			System.out.println("The product you entered does not exist in inventory. Please add.");
		}
	}

	/*
	Validates input before restocking
	*/
	public void performRestock(InventoryManagementSystemInstance managerObject, String userName, Scanner in) {
		System.out.println("Enter the product ID:\n");
		String currProductID = new String();
		currProductID = in.next();
		// check if the product is there or not
		if (inventory.containsKey(currProductID)) {
			int amount = 0;
			System.out.println("Product available in Inventory. Enter the Amount to be restocked\n");
			String temp = in.next();
			while (!temp.matches("\\d+") || (temp.length() > 9)) {
				System.out.println("Enter valid Amount\n");
				temp = in.next();
			}
			amount = Integer.parseInt(temp);
			RestockingResult restockingResult = managerObject.restockProduct(currProductID, amount);
			restockingResult.setPersonID(userName);
			listOfTransactions.add(restockingResult);
			if (restockingResult.isResult() == true)
				System.out.println("---------------------------\nSuccessfully Restocked\n---------------------------");
			else
				System.out.println("---------------------------\nTransaction Failed\n---------------------------");
		} else {
			performAdd(currProductID, in);
		}
	}

	/*
	Performs validating before addition of new products
	*/
	public void performAdd(String currProductID, Scanner in) {
		System.out.println(
				"Product Not available in Inventory. Creating a new Entry. Enter the Product Level. (Enter 0 to cancel)\n");
		int level = 0;
		String temp = in.next();
		while (!temp.matches("\\d+") || (temp.length() > 9)) {
			System.out.println("Enter valid Level\n");
			temp = in.next();
		}
		level = Integer.parseInt(temp);
		if (level == 0) {
			in.close();
			return;
		} else {
			// invoke the restocking method
			System.out.println("Enter product Name");
			String name = in.next();
			System.out.println("Enter product Location");
			String location = in.next();

			float price = 0;
			System.out.println("Enter product Price");
			String temp1 = in.next();
			while (!temp1.matches("\\d+.\\d+") || !temp1.matches("\\d+") || temp1.length() > 9) {
				System.out.println("Enter valid Price\n");
				temp1 = in.next();
			}
			price = Float.parseFloat(temp1);
			in.nextLine();
			Product newRestockProduct = new Product(currProductID, name, price, level, location);
			inventory.put(currProductID, newRestockProduct);
			System.out.println("---------------------------\nSuccessfully Added\n---------------------------");
		}
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		try {
			String menuString = "\n1: Restock Products \n2: Pick Products\n3: Display All Products\n4: Search Products by ProductID \nAny Other number to Quit";
			InventoryManagementSystemInstance managerObject = new InventoryManagementSystemInstance();
			Person p1 = new Person("p001", "name1", "Picker", "pass");
			Person p2 = new Person("r001", "name2", "Restocker", "pass");
			Person p3 = new Person("a001", "name3", "Admin", "pass");
			securityVerification.put("r001", p1);
			securityVerification.put("p001", p2);
			securityVerification.put("a001", p3);

			int loggedOut = 0;
			String userName = new String();
			while (true) {
				if (loggedOut == 1)
					break;
				System.out.println("Enter UserID to proceed\t");
				userName = in.next();
				System.out.println("Enter password to proceed\t");
				String password = in.next();
				if (securityVerification.containsKey(userName)) {
					Person p = securityVerification.get(userName);
					String passwordInStorage = p.getPassword();
					if (password.equals(passwordInStorage)) {
						// only after successful verification allow else deny
						int input = 1;
						System.out.println("Logging you in\t");
						while (input < 5 && input > 0) {
							System.out.println(menuString);
							System.out.println(
									"What would you like to do ?\n-------------------------\nInput choice number\n-------------------------\n");
							String temp2 = in.next();

							if (!temp2.matches("\\d+") || (temp2.length() > 9)) {
								System.out.println("Enter valid Input Choice\n");
								// temp2 = in.nextLine();
								continue;
							}
							input = Integer.parseInt(temp2);
							switch (input) {
							case 1:
								performRestock(managerObject, userName, in);

								break;
							case 2:
								performPick(managerObject, userName, in);

								break;
							case 3:
								// display all products
								System.out.println(
										"---------------------------\nDisplay Results\n---------------------------");
								DisplayResult displayResult = managerObject.displayProduct();
								listOfTransactions.add(displayResult);

								break;
							case 4:
								// search products
								System.out.println("Enter the product ID:\n");
								String currProductID = new String();
								currProductID = in.next();
								// check if the product is there or not
								if (inventory.containsKey(currProductID)) {
									SearchResult searchResult = managerObject.searchProduct(currProductID);
									listOfTransactions.add(searchResult);
								} else {
									System.out.println("Product Not found");
								}

								break;

							default:
								System.out.println("exiting");
								// in.close();
								// loggedOut = 1;
								break;

							}

						}
					}

					else
						System.out.println("Username/ Password invalid");
				}

				else
					System.out.println("Username/ Password invalid");
			}
		} catch (

		Exception exception) {
			System.out.println("Something went wrong");
		} finally {
			in.close();
		}

	}

}
