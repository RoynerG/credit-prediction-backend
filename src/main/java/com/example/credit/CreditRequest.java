package com.example.credit;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos de entrada para la predicción de crédito")
public class CreditRequest {

    @Schema(description = "Estado de cuenta corriente", example = "<0")
    private String checkingStatus;

    @Schema(description = "Duración del crédito en meses", example = "12")
    private int duration;

    @Schema(description = "Historial crediticio", example = "all paid")
    private String creditHistory;

    @Schema(description = "Propósito del crédito", example = "radio/tv")
    private String purpose;

    @Schema(description = "Monto del crédito", example = "1000")
    private double creditAmount;

    @Schema(description = "Estado de ahorros", example = "<100")
    private String savingsStatus;

    @Schema(description = "Nivel de empleo", example = "1<=X<4")
    private String employment;

    @Schema(description = "Compromiso de cuota mensual", example = "2")
    private int installmentCommitment;

    @Schema(description = "Estado civil y género", example = "male single")
    private String personalStatus;

    @Schema(description = "Otros deudores", example = "none")
    private String otherParties;

    @Schema(description = "Años de residencia", example = "4")
    private int residenceSince;

    @Schema(description = "Magnitud de la propiedad", example = "real estate")
    private String propertyMagnitude;

    @Schema(description = "Edad", example = "35")
    private int age;

    @Schema(description = "Otros planes de pago", example = "none")
    private String otherPaymentPlans;

    @Schema(description = "Tipo de vivienda", example = "own")
    private String housing;

    @Schema(description = "Créditos existentes", example = "1")
    private int existingCredits;

    @Schema(description = "Ocupación/Trabajo", example = "skilled")
    private String job;

    @Schema(description = "Número de dependientes", example = "1")
    private int numDependents;

    @Schema(description = "¿Tiene teléfono propio?", example = "yes")
    private String ownTelephone;

    @Schema(description = "¿Trabajador extranjero?", example = "yes")
    private String foreignWorker;

    // -- Constructores, getters y setters --

    public CreditRequest() {}

    // Getters y setters (uno por campo)
    public String getCheckingStatus() { return checkingStatus; }
    public void setCheckingStatus(String checkingStatus) { this.checkingStatus = checkingStatus; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getCreditHistory() { return creditHistory; }
    public void setCreditHistory(String creditHistory) { this.creditHistory = creditHistory; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public double getCreditAmount() { return creditAmount; }
    public void setCreditAmount(double creditAmount) { this.creditAmount = creditAmount; }

    public String getSavingsStatus() { return savingsStatus; }
    public void setSavingsStatus(String savingsStatus) { this.savingsStatus = savingsStatus; }

    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }

    public int getInstallmentCommitment() { return installmentCommitment; }
    public void setInstallmentCommitment(int installmentCommitment) { this.installmentCommitment = installmentCommitment; }

    public String getPersonalStatus() { return personalStatus; }
    public void setPersonalStatus(String personalStatus) { this.personalStatus = personalStatus; }

    public String getOtherParties() { return otherParties; }
    public void setOtherParties(String otherParties) { this.otherParties = otherParties; }

    public int getResidenceSince() { return residenceSince; }
    public void setResidenceSince(int residenceSince) { this.residenceSince = residenceSince; }

    public String getPropertyMagnitude() { return propertyMagnitude; }
    public void setPropertyMagnitude(String propertyMagnitude) { this.propertyMagnitude = propertyMagnitude; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getOtherPaymentPlans() { return otherPaymentPlans; }
    public void setOtherPaymentPlans(String otherPaymentPlans) { this.otherPaymentPlans = otherPaymentPlans; }

    public String getHousing() { return housing; }
    public void setHousing(String housing) { this.housing = housing; }

    public int getExistingCredits() { return existingCredits; }
    public void setExistingCredits(int existingCredits) { this.existingCredits = existingCredits; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public int getNumDependents() { return numDependents; }
    public void setNumDependents(int numDependents) { this.numDependents = numDependents; }

    public String getOwnTelephone() { return ownTelephone; }
    public void setOwnTelephone(String ownTelephone) { this.ownTelephone = ownTelephone; }

    public String getForeignWorker() { return foreignWorker; }
    public void setForeignWorker(String foreignWorker) { this.foreignWorker = foreignWorker; }
}
