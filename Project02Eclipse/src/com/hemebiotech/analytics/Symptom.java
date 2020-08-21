package com.hemebiotech.analytics;

/**
 * Symptom class with two attributes
 *      symptom name
 *      symptom repetition
 * for future needs new attributes can be added
 */

public class Symptom {
    private String symptomName;
    private Integer symptomRepetition;

    // constructor can set name and repetition, will be used after counting symptoms
    /**
     * Constructor set arguments to attributes , the value will be taken from HashMap
     * @param symptomName symptom name
     * @param symptomRepetition symptom repetition
     */
    public Symptom(String symptomName, Integer symptomRepetition) {
        this.symptomName = symptomName;
        this.symptomRepetition = symptomRepetition;
    }

    // setters and getters
    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public Integer getSymptomRepetition() {
        return symptomRepetition;
    }

    public void setSymptomRepetition(Integer symptomRepetition) {
        this.symptomRepetition = symptomRepetition;
    }

}
