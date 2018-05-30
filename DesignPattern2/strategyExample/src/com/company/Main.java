package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nAdd");
        CalculatorContext calculator = new CalculatorContext(new AddNumbers());
        System.out.println("\tcalculator.executeStrategy(3,3): " + calculator.executeStrategy(3, 3));

        System.out.println("\nSubtract");
        calculator = new CalculatorContext(new SubtractNumbers());
        System.out.println("\tcalculator.executeStrategy(3,3): " + calculator.executeStrategy(3, 3));

        System.out.println("\nMultiply");
        calculator = new CalculatorContext(new MultiplyNumbers());
        System.out.println("\tcalculator.executeStrategy(3,3): " + calculator.executeStrategy(3, 3));

        System.out.println("\nDivide");
        calculator = new CalculatorContext(new DivideNumbersBadly());
        System.out.println("\tcalculator.executeStrategy(3,3): " + calculator.executeStrategy(3, 3));

    }
}
