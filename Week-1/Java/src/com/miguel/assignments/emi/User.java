package com.miguel.assignments.emi;

public class User {
    private double loanAmount;
    private double rateOfInterest;
    private double years;


    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        rateOfInterest = rateOfInterest/(12*100);
        this.rateOfInterest = rateOfInterest;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        years = years*12;
        this.years = years;
    }
}
