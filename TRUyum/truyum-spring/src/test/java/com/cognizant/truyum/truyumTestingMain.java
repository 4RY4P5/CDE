package com.cognizant.truyum;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class truyumTestingMain {

	public static void main(String[] args) {
	
		Result result = JUnitCore.runClasses(TestingSuite.class);

		if (result.getFailureCount() == 0) {
			System.out.println("****There are No Failures****");
		} else {
			for (Failure failure : result.getFailures())

			{
				System.out.println("*****The Test execution failed*****\n" + failure.getMessage());
			}
		}
		System.out.println("Result" + result.wasSuccessful());
	}

}


