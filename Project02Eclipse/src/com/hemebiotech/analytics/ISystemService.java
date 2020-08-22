package com.hemebiotech.analytics;

import java.util.List;

/**
 * All business functionality can be add here ,
 * there is two functionality now:
 *      Counting Symptoms
 *      sorting symptoms
 */

public interface ISystemService {

    /**
     * This tacks items from input string list and put the items in HashMap :
     *  - key is Symptom
     *  - value is the counter
     *
     * @param symptomsList list returns from GetSymptoms function
     * @return Map contains all items without duplicates as keys and how many times they appears as values
     */
    List<Symptom> countSymptoms(List<String> symptomsList);

    /**
     * sort symptoms alphabetically
     * @param symptomsListCounted list of Symptoms objects read from input File and counted
     * @return sorted list of symptoms
     */
    List<Symptom> sortSymptoms(List<Symptom> symptomsListCounted);
}
