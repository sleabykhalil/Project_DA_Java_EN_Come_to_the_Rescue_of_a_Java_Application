package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String sourceFilepath;
	private String destinationFilepath;
	
	/**
	 * 
	 * @param sourceFilepath a full or partial path to file with symptom strings in it, one per line
	 */
	public  ReadSymptomDataFromFile (String sourceFilepath)
	   {
		this.sourceFilepath = sourceFilepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (sourceFilepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(sourceFilepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}



	@Override
	public void WriteSymptoms(String s,TreeMap<String, Integer> symptomsMap) throws IOException {
		s="result.out";
		FileWriter writer = new FileWriter(s);
		for (Map.Entry<String, Integer> symptom : symptomsMap.entrySet()) {
			writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
		}
		writer.close();
	}

}
