package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Handle business logic
 */

public class SystemServices  implements ISystemService{
    /**
     * TreeMap used :
     *      - Add each line as a key ,so duplicated erased.
     *      - Add 1 to the value , so symptom counted.
     * @param symptomsList list returned from ReadSymptoms
     * @return TreeMap contains the result which will be send to WriteSymptoms
     * @see FileController
     */
    @Override
    public TreeMap countSymptoms(List<String> symptomsList){
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
