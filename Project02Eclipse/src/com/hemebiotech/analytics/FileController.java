package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


/**
 * Handle files reading and writing.
 * files paths can be changed from properties file named defaultProperties
 */

public class FileController implements IFileController {


	/**
	 *  sourceFilepath a full or partial path to file with symptom strings in it, one per line
	 *  destinationFilepath file path to write result in it
	 */

	private String sourceFilepath;
	private String destinationFilepath;

	public void setSourceFilepath(String sourceFilepath) {
		this.sourceFilepath = sourceFilepath;
	}

	public void setDestinationFilepath(String destinationFilepath) {
		this.destinationFilepath = destinationFilepath;
	}


	/**
	 * Constructor read paths from properties file
	 */
	public FileController() {
		try {
			this.getPaths();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get File paths from defaultProperties file and set them to source and destination
	 * @exception FileNotFoundException files name and path fixed as default
	 */
	public void getPaths()  {
		try {
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("defaultProperties");
			defaultProps.load(in);
			in.close();

			sourceFilepath = (String) defaultProps.get("source");
			destinationFilepath = (String) defaultProps.get("destination");
		} catch (FileNotFoundException e){
			sourceFilepath = "Project02Eclipse/symptoms.txt";
			destinationFilepath = "result.out";
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Read symptoms from input file
	 * @return List of string every element contains line from the file ,one symptom par line
	 */
	@Override
	public List<String> readSymptoms() {
		ArrayList<String> result = new ArrayList<>();
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
				System.out.println("Input file not found");
			}
		}
		return result;
	}

	/**
	 * Write symptoms in output file after counting
	 * @param symptomsList Symptoms counted and ordered
	 */
	@Override
	public void writeSymptoms(ArrayList<Symptom> symptomCountedOrderedList) {
		if (destinationFilepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilepath));
				/*
				  for  next lines using lambda will be equal to the following
				  				for (Map.Entry<String, Integer> symptom : symptomsMap.entrySet()) {
				  					writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n"); }
				 */
				symptomCountedOrderedList.forEach(symptom -> {
					try {
						writer.write( symptom.getSymptomName() + " : " + symptom.getSymptomRepetition() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Output file cannot be created");
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
