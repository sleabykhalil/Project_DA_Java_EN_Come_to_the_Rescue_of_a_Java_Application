package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.List;

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
		List<String> symptomsList;
		List<Symptom> symptomCountedList = new ArrayList<>();
		List<Symptom> symptomCountedOrderedList = new ArrayList<Symptom>();

		symptomsList = fileController.readSymptoms();
		symptomCountedList = systemServices.countSymptoms(symptomsList);
		symptomCountedOrderedList = systemServices.sortSymptoms(symptomCountedList);
		fileController.writeSymptoms((ArrayList<Symptom>) symptomCountedOrderedList);
	}
}
