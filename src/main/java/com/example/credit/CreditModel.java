package com.example.credit;

/**
 * DTO que representa la respuesta de la predicción de crédito.
 */
public class CreditModel {
    /** Clase predicha ("good" o "bad") */
    private String predictedClass;

    /** Probabilidad de que sea "good" */
    private double probabilityGood;

    /** Probabilidad de que sea "bad" */
    private double probabilityBad;

    // Constructor sin argumentos
    public CreditModel() {
    }

    public String getPredictedClass() {
        return predictedClass;
    }

    public void setPredictedClass(String predictedClass) {
        this.predictedClass = predictedClass;
    }

    public double getProbabilityGood() {
        return probabilityGood;
    }

    public void setProbabilityGood(double probabilityGood) {
        this.probabilityGood = probabilityGood;
    }

    public double getProbabilityBad() {
        return probabilityBad;
    }

    public void setProbabilityBad(double probabilityBad) {
        this.probabilityBad = probabilityBad;
    }

    @Override
    public String toString() {
        return "CreditModel{" +
                "predictedClass='" + predictedClass + '\'' +
                ", probabilityGood=" + probabilityGood +
                ", probabilityBad=" + probabilityBad +
                '}';
    }
}
