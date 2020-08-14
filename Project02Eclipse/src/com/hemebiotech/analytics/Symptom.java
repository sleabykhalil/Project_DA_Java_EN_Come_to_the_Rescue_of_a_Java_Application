package com.hemebiotech.analytics;

public class Symptom {
    private String symptomName;
    private Integer symptomRepetition;


    public Symptom(String symptomName, Integer symptomRepetition) {
        this.symptomName = symptomName;
        this.symptomRepetition = symptomRepetition;
    }

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
