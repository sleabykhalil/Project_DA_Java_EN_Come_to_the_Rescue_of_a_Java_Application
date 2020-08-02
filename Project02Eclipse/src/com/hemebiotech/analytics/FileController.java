package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class FileController implements IFileController {

	/**
	 * @param sourceFilepath file path to read symptoms from
	 * @param destinationFilepath file path to write result in it
	 */
	private String sourceFilepath;
	private String destinationFilepath;

	public String getSourceFilepath() {
		return sourceFilepath;
	}

	public void setSourceFilepath(String sourceFilepath) {
		this.sourceFilepath = sourceFilepath;
	}

	public String getDestinationFilepath() {
		return destinationFilepath;
	}

	public void setDestinationFilepath(String destinationFilepath) {
		this.destinationFilepath = destinationFilepath;
	}

	/**
	 * 
	 * @param sourceFilepath a full or partial path to file with symptom strings in it, one per line
	 */
	/* khalil
	public FileController(String sourceFilepath)
	   {
		this.sourceFilepath = sourceFilepath;
	}
	*/

	@Override
	public List<String> ReadSymptoms() {
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
	public void WriteSymptoms(TreeMap<String, Integer> symptomsMap) throws IOException {
		//s="result.out";
		if (destinationFilepath != null) {

			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilepath));
				/**
				 * for  next lines using lambda will be equal to the following
				 * 				for (Map.Entry<String, Integer> symptom : symptomsMap.entrySet()) {
				 * 					writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n"); }
				 */

				symptomsMap.forEach((k,v)-> {
					try {
						writer.write(k + " : " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
