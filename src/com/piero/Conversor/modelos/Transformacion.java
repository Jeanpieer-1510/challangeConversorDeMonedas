package com.piero.Conversor.modelos;

public class Transformacion {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double conversionResult;
    private double cantidad; // Nuevo campo para almacenar la cantidad original

    // Constructor actualizado
    public Transformacion(String baseCode, String targetCode, double conversionRate, double conversionResult, double cantidad) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
        this.cantidad = cantidad; // Inicializar el campo nuevo
    }

    // Getters
    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public double getCantidad() { // Getter del nuevo campo
        return cantidad;
    }

    // Setters
    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public void setCantidad(double cantidad) { // Setter del nuevo campo
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "El valor " +
                cantidad + " [" + baseCode + "] " +
                "corresponde al valor final de ==> " + conversionResult + " [" + targetCode + "] " +
                "teniendo una tasa de conversión de: " + conversionRate;
    }
}