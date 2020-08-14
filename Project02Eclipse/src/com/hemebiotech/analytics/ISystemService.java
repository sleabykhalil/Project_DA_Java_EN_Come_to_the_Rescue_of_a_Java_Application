package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * All functionality can be add here ,
 * there is one functionality now:
 *      Counting Symptoms
 */

public interface ISystemService {

    /**
     * This tacks items from input string list and put the items in TreeMap :
     *  - key is Symptom
     *  - value is the counter
     *
     * @param symptoms list returns from GetSymptoms function
     * @return Map contains all items without duplicates as keys and how many times they appears as values
     */
    Map<String,Integer> countSymptoms(List<String> symptoms);

    /**
     * sort symptoms alphabetically
     * @param symptoms
     * @return
     */
    List<String> sortSymptoms(List<String> symptoms);
}
