package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        symptomsList = sortSymptoms(symptomsList);

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

            List<Symptom> symptomsListFinal= new ArrayList<Symptom>();
            symptomsMap.forEach((k,v)-> {
                symptomsListFinal.add(new Symptom((String)k,(Integer)v));

            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return symptomsMap;
    }

    /**
     * another way to sort
     * you can always use Array.sort()
     * @param symptoms : contain list of symptoms
     * @return sorted list
     */
    @Override
    public List<String> sortSymptoms(List<String> symptoms) {
        try {
            String symptomHolderForSort;
            for (int i=0; i<(symptoms.size()) ; i++) {
                for (int j= 0; j < symptoms.size(); j++) {
                    if ((symptoms.get(i).compareToIgnoreCase(symptoms.get(j).toUpperCase())) < 0) {
                        symptomHolderForSort = symptoms.get(i);
                        symptoms.set(i, symptoms.get(j));
                        symptoms.set(j, symptomHolderForSort);
                    }
                }
            }

            return symptoms;
        } catch (Exception e) {
            System.out.println("nothing in the list");
            return null;
        }

    }
}
