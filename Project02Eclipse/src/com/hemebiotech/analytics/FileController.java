package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;



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
	 * @throws IOException
	 */

	public void getPaths() throws IOException {

		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("defaultProperties");
		defaultProps.load(in);
		in.close();

		setSourceFilepath((String) defaultProps.get("source"));
		setDestinationFilepath((String) defaultProps.get("destination"));

	}

	public FileController() {

		try {
			this.getPaths();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
			}
		}
		return result;
	}

	@Override
	public void WriteSymptoms(TreeMap<String, Integer> symptomsMap) {
		//s="result.out";
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
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
