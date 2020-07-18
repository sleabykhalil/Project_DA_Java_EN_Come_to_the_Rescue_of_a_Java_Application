package com.hemebiotech.analytics;

public class Symptom {

    private String symptomName ;
    public Integer symptomCount;

    public String getSymptomName() {
        return symptomName;
            }

    public Integer getSymptomCount() {
        return symptomCount;
    }

    public void setSymptomCount(Integer symptomCount) {
        this.symptomCount = symptomCount;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }
}
