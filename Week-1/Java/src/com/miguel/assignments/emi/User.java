package com.miguel.assignments.emi;

public class User {
    private float loanAmount;
    private float returnOfInterest;
    private float tenure;

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getReturnOfInterest() {
        return returnOfInterest;
    }

    public void setReturnOfInterest(float returnOfInterest) {
        this.returnOfInterest = returnOfInterest;
    }

    public float getTenure() {
        return tenure;
    }

    public void setTenure(float tenure) {
        this.tenure = tenure;
    }
}
