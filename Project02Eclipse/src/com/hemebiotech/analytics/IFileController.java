package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Read list of symptoms from input file and write symptoms in result file,
 * @see ISystemService the results are counted and sorted
 */
public interface IFileController {

	/**
	 * If no data is available, return an empty List
	 * This will read from input File,
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> readSymptoms ();

	/**
	 * This function to write the results in output file
	 * @param symptomCountedOrderedList List of Symptoms counted sorted
	 */
    void writeSymptoms(ArrayList<Symptom> symptomCountedOrderedList);
}
