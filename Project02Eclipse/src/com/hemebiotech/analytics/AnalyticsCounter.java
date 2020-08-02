package com.hemebiotech.analytics;



public class AnalyticsCounter {


	public static void main(String args[])  {


		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();


		fileController.WriteSymptoms(systemServices.CountSymptoms(fileController.ReadSymptoms()));

	}
}
