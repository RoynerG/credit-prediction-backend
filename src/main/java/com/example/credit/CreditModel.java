package com.example.credit;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resultado de la predicción de crédito")
public class CreditModel {

    @Schema(description = "Clase predicha: good o bad", example = "good")
    private String predictedClass;

    @Schema(description = "Probabilidad de buen crédito", example = "0.85")
    private double probabilityGood;

    @Schema(description = "Probabilidad de mal crédito", example = "0.15")
    private double probabilityBad;

    // -- Constructores, getters y setters --

    public CreditModel() {}

    public String getPredictedClass() { return predictedClass; }
    public void setPredictedClass(String predictedClass) { this.predictedClass = predictedClass; }

    public double getProbabilityGood() { return probabilityGood; }
    public void setProbabilityGood(double probabilityGood) { this.probabilityGood = probabilityGood; }

    public double getProbabilityBad() { return probabilityBad; }
    public void setProbabilityBad(double probabilityBad) { this.probabilityBad = probabilityBad; }
}
