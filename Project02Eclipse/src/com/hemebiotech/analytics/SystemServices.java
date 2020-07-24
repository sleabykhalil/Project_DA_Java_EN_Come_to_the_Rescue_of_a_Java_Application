package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SystemServices  implements ISystemService{

    @Override
    public Map<String,Integer> CountSymptoms(List<String> symptomsList){
        /**
         * TreeMap will put Symptoms on alphabetic order
         */
        Map symptomsMap = new TreeMap<String,Integer>();
        try{
            for (String s : symptomsList) {
                Integer counter = (Integer) symptomsMap.get(s);
                /**
                 * if Symptom does not exist in the list , new (key value) will be created
                 */
                symptomsMap.put(s, (counter == null) ? 1 : counter + 1);}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return symptomsMap;
    }

    @Override
    public TreeMap<String,Integer> ReadInputFile(){

        TreeMap symptomsMap = new TreeMap<String, Integer>();
        ReadSymptomDataFromFile fileReader =
                new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        for (String s : fileReader.GetSymptoms()) {
            Integer counter = (Integer) symptomsMap.get(s);
            symptomsMap.put(s, (counter == null) ? 1 : counter + 1);
        }
        return symptomsMap;
    }

    @Override
    public void WrightOutputFile() {
       try {
           FileWriter writer = new FileWriter("result.out");
           TreeMap symptomsMap = ReadInputFile();

         /*  symptomsMap.forEach((k,v)-> {
               try {
                   writer.write(k + " : " + v + "\n");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           });
           */

           for (Map.Entry<String,Integer> symptom : symptomsMap.entrySet()) {
               writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
           }
           ;
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
