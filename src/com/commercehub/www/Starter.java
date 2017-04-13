package com.commercehub.www;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Starts IMS
*/
public class Starter {
	
	public static void main(String[] args)
	{
		// will create new threads as needed
		ExecutorService executorService =Executors.newCachedThreadPool();
		Runnable workerThread = new InventoryLauncher();
		executorService.execute(workerThread);
		//not using submit because there is no need to track the result, it will be written to the list of transactions.
		//all relevant details are recorded in the TransactionResult inherited classes
		executorService.shutdown();
		//to keep running until all submitted tasks complete
		while(!executorService.isTerminated())
		{
			
		}
		System.out.println("Shutting down");
	}

}
