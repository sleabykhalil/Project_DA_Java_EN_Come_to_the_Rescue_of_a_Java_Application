package com.hemebiotech.analytics;


import java.io.FileInputStream;
import java.util.Properties;

public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {

		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("defaultProperties");
		defaultProps.load(in);
		in.close();
		defaultProps.get("source");
		defaultProps.get("destination");


		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();

		fileController.setSourceFilepath((String) defaultProps.get("source"));
		fileController.setDestinationFilepath((String) defaultProps.get("destination"));

		fileController.WriteSymptoms(systemServices.CountSymptoms(fileController.ReadSymptoms()));

	}
}
