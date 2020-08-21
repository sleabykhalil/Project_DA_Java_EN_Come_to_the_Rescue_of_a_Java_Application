package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.List;

/**
 *	 This is an application for :
 *	 	- Read Symptoms from Text file
 *	 	- Count Symptoms
 *	 	- Sort Symptoms
 *	 	- Write Symptoms counted and ordered in another Text file
 */
public class AnalyticsCounter {

	/** Programme starts here */
	public static void main(String args[])  {

		symptomCounter();
	}

	/**
	 * This Count Symptoms ,
	 *   -  fileController : read from input file and write in the output file
	 *   -  systemServices : count an sort list of symptoms after creating list of symptoms as objects
	 * @see FileController
	 * @see SystemServices
	 * @see  Symptom
	 */
	public static void symptomCounter(){
		FileController fileController = new FileController();
		SystemServices systemServices = new SystemServices();

		// List of symptoms names after reading input file
		List<String> symptomsList;
		symptomsList = fileController.readSymptoms();

		// Count symptoms and return list of object Symptoms
		List<Symptom> symptomCountedList = new ArrayList<>();
		symptomCountedList = systemServices.countSymptoms(symptomsList);

		//Order list of symptoms alphabetically in descending order
		List<Symptom> symptomCountedOrderedList = new ArrayList<>();
		symptomCountedOrderedList = systemServices.sortSymptoms(symptomCountedList);

		// Write result in file
		fileController.writeSymptoms((ArrayList<Symptom>) symptomCountedOrderedList);
	}
}
