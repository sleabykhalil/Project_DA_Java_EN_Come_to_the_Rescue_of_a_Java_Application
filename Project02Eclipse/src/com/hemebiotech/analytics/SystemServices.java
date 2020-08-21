package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handle business logic
 */

public class SystemServices  implements ISystemService{
    /**
     * HashMap used :
     *      - Add each line as a key ,so duplicated erased.
     *      - Add 1 to the value , so symptom counted.
     * @param symptomsList list returned from ReadSymptoms
     * @return List of symptoms objets
     * @see Symptom
     * @see FileController
     */
    @Override
    public List<Symptom> countSymptoms(List<String> symptomsList){

        // HashMap used to count Symptoms
        Map<String,Integer> symptomsMap = new HashMap<>();
        List<Symptom> symptomsListCounted= new ArrayList<>();

        try{
            for (String symptom : symptomsList) {
                Integer counter = symptomsMap.get(symptom);

                // if Symptom does not exist in the list , new (key value) will be created
                symptomsMap.put(symptom, (counter == null) ? 1 : counter + 1);}

            symptomsMap.forEach((k,v)-> symptomsListCounted.add(new Symptom(k, v)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return symptomsListCounted;
   }

    /**
     * Sort Symptoms by name alphabetically in descending order
     * @param symptomsListCounted : contain list of symptoms counted by countSymptoms method
     * @return sorted list of symptoms objects
     */
    @Override
    public List<Symptom> sortSymptoms(List<Symptom> symptomsListCounted) {

        /*
           - comparator.comparing will sort and return result in the same symptomsListCounted

             The Double Colon Operator started in Java 8
             Comparator c = (symptom s1, symptom s2) -> s1.getSymptomName().compareTo(s2.getSymptomName());

             Note: sorting is case sensitive ,
               for case insensitive add  String.CASE_INSENSITIVE_ORDER as second parameter to  comparing method
        */

        symptomsListCounted.sort(Comparator.comparing(Symptom::getSymptomName));
        return symptomsListCounted;
    }
}
