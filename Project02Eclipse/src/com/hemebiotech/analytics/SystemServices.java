package com.hemebiotech.analytics;

import java.util.*;

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
    public List<Symptom> countSymptoms(List<String> symptomsList){

        //symptomsList = sortSymptoms(symptomsList);

        /*
         * TreeMap will put Symptoms on alphabetic order
         */
       Map symptomsMap = new HashMap<String,Integer>();
       List<Symptom> symptomsListCounted= new ArrayList<Symptom>();

        try{
            for (String symptom : symptomsList) {
                Integer counter = (Integer) symptomsMap.get(symptom);
                /*
                 * if Symptom does not exist in the list , new (key value) will be created
                 */
                symptomsMap.put(symptom, (counter == null) ? 1 : counter + 1);}

            symptomsMap.forEach((k,v)-> {
                symptomsListCounted.add(new Symptom((String)k,(Integer)v));

            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return symptomsListCounted;
   }

    /**
     * another way to sort
     * you can always use Array.sort()
     * @param symptoms : contain list of symptoms
     * @return sorted list
     */
    @Override
    public List<Symptom> sortSymptoms(List<Symptom> symptoms) {

       symptoms.sort(Comparator.comparing(Symptom::getSymptomName));
       return symptoms;
    }
}
