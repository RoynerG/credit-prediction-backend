package com.example.credit;

public class CreditRequest {
    // Numéricos
    private double duration;
    private double creditAmount;
    private double residenceSince;
    private double age;
    private double existingCredits;
    private double peopleLiable;

    // Nominales
    private String checkingStatus;
    private String creditHistory;
    private String purpose;
    private String savings;
    private String employment;
    private String personalStatus;
    private String otherDebtors;
    private String property;
    private String otherInstallments;
    private String housing;
    private String job;
    private String telephone;
    private String foreignWorker;

    // Constructor vacío necesario para Jackson
    public CreditRequest() { }

    // Getters y setters numéricos
    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }

    public double getCreditAmount() { return creditAmount; }
    public void setCreditAmount(double creditAmount) { this.creditAmount = creditAmount; }

    public double getResidenceSince() { return residenceSince; }
    public void setResidenceSince(double residenceSince) { this.residenceSince = residenceSince; }

    public double getAge() { return age; }
    public void setAge(double age) { this.age = age; }

    public double getExistingCredits() { return existingCredits; }
    public void setExistingCredits(double existingCredits) { this.existingCredits = existingCredits; }

    public double getPeopleLiable() { return peopleLiable; }
    public void setPeopleLiable(double peopleLiable) { this.peopleLiable = peopleLiable; }

    // Getters y setters nominales
    public String getCheckingStatus() { return checkingStatus; }
    public void setCheckingStatus(String checkingStatus) { this.checkingStatus = checkingStatus; }

    public String getCreditHistory() { return creditHistory; }
    public void setCreditHistory(String creditHistory) { this.creditHistory = creditHistory; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getSavings() { return savings; }
    public void setSavings(String savings) { this.savings = savings; }

    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }

    public String getPersonalStatus() { return personalStatus; }
    public void setPersonalStatus(String personalStatus) { this.personalStatus = personalStatus; }

    public String getOtherDebtors() { return otherDebtors; }
    public void setOtherDebtors(String otherDebtors) { this.otherDebtors = otherDebtors; }

    public String getProperty() { return property; }
    public void setProperty(String property) { this.property = property; }

    public String getOtherInstallments() { return otherInstallments; }
    public void setOtherInstallments(String otherInstallments) { this.otherInstallments = otherInstallments; }

    public String getHousing() { return housing; }
    public void setHousing(String housing) { this.housing = housing; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getForeignWorker() { return foreignWorker; }
    public void setForeignWorker(String foreignWorker) { this.foreignWorker = foreignWorker; }
}
