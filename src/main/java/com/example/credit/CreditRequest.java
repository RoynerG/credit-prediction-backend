package com.example.credit;

/**
 * DTO para recibir los parámetros de la petición de crédito.
 */
public class CreditRequest {
    private String checkingStatus;
    private int duration;
    private String creditHistory;
    private String purpose;
    private double creditAmount;
    private String savingsStatus;
    private String employment;
    private int installmentCommitment;
    private String personalStatus;
    private String otherParties;
    private int residenceSince;
    private String propertyMagnitude;
    private int age;
    private String otherPaymentPlans;
    private String housing;
    private int existingCredits;
    private String job;
    private int numDependents;
    private String ownTelephone;
    private String foreignWorker;

    // Constructor sin argumentos (necesario para deserialización JSON)
    public CreditRequest() {
    }

    public String getCheckingStatus() {
        return checkingStatus;
    }
    public void setCheckingStatus(String checkingStatus) {
        this.checkingStatus = checkingStatus;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCreditHistory() {
        return creditHistory;
    }
    public void setCreditHistory(String creditHistory) {
        this.creditHistory = creditHistory;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getCreditAmount() {
        return creditAmount;
    }
    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getSavingsStatus() {
        return savingsStatus;
    }
    public void setSavingsStatus(String savingsStatus) {
        this.savingsStatus = savingsStatus;
    }

    public String getEmployment() {
        return employment;
    }
    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public int getInstallmentCommitment() {
        return installmentCommitment;
    }
    public void setInstallmentCommitment(int installmentCommitment) {
        this.installmentCommitment = installmentCommitment;
    }

    public String getPersonalStatus() {
        return personalStatus;
    }
    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public String getOtherParties() {
        return otherParties;
    }
    public void setOtherParties(String otherParties) {
        this.otherParties = otherParties;
    }

    public int getResidenceSince() {
        return residenceSince;
    }
    public void setResidenceSince(int residenceSince) {
        this.residenceSince = residenceSince;
    }

    public String getPropertyMagnitude() {
        return propertyMagnitude;
    }
    public void setPropertyMagnitude(String propertyMagnitude) {
        this.propertyMagnitude = propertyMagnitude;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getOtherPaymentPlans() {
        return otherPaymentPlans;
    }
    public void setOtherPaymentPlans(String otherPaymentPlans) {
        this.otherPaymentPlans = otherPaymentPlans;
    }

    public String getHousing() {
        return housing;
    }
    public void setHousing(String housing) {
        this.housing = housing;
    }

    public int getExistingCredits() {
        return existingCredits;
    }
    public void setExistingCredits(int existingCredits) {
        this.existingCredits = existingCredits;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public int getNumDependents() {
        return numDependents;
    }
    public void setNumDependents(int numDependents) {
        this.numDependents = numDependents;
    }

    public String getOwnTelephone() {
        return ownTelephone;
    }
    public void setOwnTelephone(String ownTelephone) {
        this.ownTelephone = ownTelephone;
    }

    public String getForeignWorker() {
        return foreignWorker;
    }
    public void setForeignWorker(String foreignWorker) {
        this.foreignWorker = foreignWorker;
    }
}
