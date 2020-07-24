package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * This will read from input File,
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> GetSymptoms ();

	/**
	 * This tacks items from input string list and put the items in Map the
	 * 														key is Symptom value is the counter
	 * @param Symptoms list returns from GetSymptoms function
	 * 
	 * @return Map contains all items without duplicates as keys and how many times they appears as values
	 */
	Map<String,Integer> CountSymptoms(List<String> Symptoms);

	/**
	 * This function to write the results in file
	 * @param fileName file path to write result in it
	 * @param symptomsMap Symptoms counted and they will be ordered as they are in TreeMap
	 * @throws IOException
	 */
	void WriteSymptoms(String fileName,TreeMap<String,Integer> symptomsMap) throws IOException;
}
