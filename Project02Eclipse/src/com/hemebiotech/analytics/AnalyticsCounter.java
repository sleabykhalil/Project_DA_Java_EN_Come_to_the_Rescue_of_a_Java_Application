package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;    // initialize to 0
	private static int rashCount = 0;        // initialize to 0
	private static int pupilCount = 0;        // initialize to 0
	private static Map<String, Integer> symptomsMap;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));

			String line = reader.readLine();

			//int i = 0;    // set i to 0
			//int headCount = 0;    // counts headaches
			while (line != null) {
				//i++;    // increment i
				//System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
					System.out.println("number of rash: " + rashCount);
				} else if (line.contains("pupils")) {
					pupilCount++;
					System.out.println("symptom from file: " + line);
					System.out.println("number of pupils: " + pupilCount);
				}

				line = reader.readLine();    // get another symptom
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("file not found");
		}

		// get result in Hashmap
		symptomsMap = new HashMap<String, Integer>();
		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		for (String s : fileReader.GetSymptoms()) {
			Integer counter = symptomsMap.get(s);
			symptomsMap.put(s, (counter == null) ? 1 : counter + 1);


			// next generate output
			FileWriter writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");

			// write my results
			writer.write("-----------\n");
			for (Map.Entry<String, Integer> symptom : symptomsMap.entrySet()) {
				writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
			}
			;

			writer.close();


		}
	}
}
