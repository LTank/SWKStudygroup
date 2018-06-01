package com.company;

public class CalculatorContext {
    private CalcStrategy calcStrategy;

    public CalculatorContext(CalcStrategy calcStrategy){
        this.calcStrategy = calcStrategy;
    }

    public int executeStrategy(int num1, int num2){
        return calcStrategy.doOperation(num1, num2);
    }
}
