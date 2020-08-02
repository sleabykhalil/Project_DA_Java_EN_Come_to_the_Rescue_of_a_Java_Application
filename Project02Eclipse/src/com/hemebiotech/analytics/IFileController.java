package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface IFileController {


	/**
	 * If no data is available, return an empty List
	 * This will read from input File,
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> ReadSymptoms ();



	/**
	 * This function to write the results in file
	 * @param symptomsMap Symptoms counted and they will be ordered as they are in TreeMap
	 */
	void WriteSymptoms(TreeMap<String,Integer> symptomsMap) ;


}
