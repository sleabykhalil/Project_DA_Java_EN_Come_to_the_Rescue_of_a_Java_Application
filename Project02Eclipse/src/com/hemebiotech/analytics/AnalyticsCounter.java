package com.hemebiotech.analytics;



public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {

		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();

		fileController.setSourceFilepath("Project02Eclipse/symptoms.txt");
		fileController.setDestinationFilepath("result.out");

		fileController.WriteSymptoms(systemServices.CountSymptoms(fileController.ReadSymptoms()));

	}
}
