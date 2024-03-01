package com.example.addition;

public final class NumberData {
    private final Double number1;
    private final Double number2;

    public NumberData(Double number1, Double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Double getNumber1() {
        return number1;
    }

    public Double getNumber2() {
        return number2;
    }
}