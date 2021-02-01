package com.test.rest.api.domain;

public class EmployeeDTO {

    private int bondingTimeMonths;

    private int currentAgeYears;


    public int getBondingTimeMonths() {
        return bondingTimeMonths;
    }

    public void setBondingTimeMonths(int bondingTimeMonths) {
        this.bondingTimeMonths = bondingTimeMonths;
    }

    public int getCurrentAgeYears() {
        return currentAgeYears;
    }

    public void setCurrentAgeYears(int currentAgeYears) {
        this.currentAgeYears = currentAgeYears;
    }

    @Override
    public String toString() {
        return "EmployeeDTO [bondingTimeMonths=" + bondingTimeMonths + ", currentAgeYears=" + currentAgeYears + "]";
    }

}
