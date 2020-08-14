package com.hemebiotech.analytics;


/**
 *	 This is an application for :
 *	 	- Read Symptoms from Text file
 *	 	- Count and sort Symptoms
 *	 	- Write Symptoms counted and ordered in another Text file
 */
public class AnalyticsCounter {

	/** Programme starts here */
	public static void main(String args[])  {

		symptomCounter();
	}

	/**
	 * Count Symptoms , Tow variable needed fileController to read from input file and write in the output file
	 * @see FileController
	 * @see SystemServices
	 */
	public static void symptomCounter(){
		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();

		// write output ( count and sort (read input file()) )

		fileController.writeSymptoms(systemServices.countSymptoms(fileController.readSymptoms()));
	}
}
