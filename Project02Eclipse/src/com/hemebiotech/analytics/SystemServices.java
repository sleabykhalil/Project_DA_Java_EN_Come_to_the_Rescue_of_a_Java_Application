package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SystemServices  implements ISystemService{

    @Override
    public TreeMap<String,Integer> CountSymptoms(List<String> symptomsList){
        /*
         * TreeMap will put Symptoms on alphabetic order
         */
       TreeMap symptomsMap = new TreeMap<String,Integer>();
        try{
            for (String symptom : symptomsList) {
                Integer counter = (Integer) symptomsMap.get(symptom);
                /*
                 * if Symptom does not exist in the list , new (key value) will be created
                 */
                symptomsMap.put(symptom, (counter == null) ? 1 : counter + 1);}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return symptomsMap;
    }




}
