package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;


/**
 * Handle reading and writing to files
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
	 * Read symptoms from input file
	 * @return List of string every element contains line from the file ,one symptom par line
	 */
	@Override
	public List<String> ReadSymptoms() {
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
	 * @param symptomsMap Symptoms counted and they will be ordered as they are in TreeMap
	 */
	@Override
	public void WriteSymptoms(TreeMap<String, Integer> symptomsMap) {
		if (destinationFilepath != null) {

			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilepath));
				/*
				  for  next lines using lambda will be equal to the following
				  				for (Map.Entry<String, Integer> symptom : symptomsMap.entrySet()) {
				  					writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n"); }
				 */

				symptomsMap.forEach((k,v)-> {
					try {
						writer.write(k + " : " + v + "\n");
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
