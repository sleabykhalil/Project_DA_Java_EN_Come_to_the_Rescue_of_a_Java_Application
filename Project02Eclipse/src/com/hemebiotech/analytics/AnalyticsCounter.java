package com.hemebiotech.analytics;


/**
 * Main class
 * Tow variable needed fileController to read from input file and write in the output file
 * @see FileController
 * @see SystemServices
 */
public class AnalyticsCounter {


	public static void main(String args[])  {


		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();

		// write output ( count and sort (read input file()) )

		fileController.WriteSymptoms(systemServices.CountSymptoms(fileController.ReadSymptoms()));

	}
}
