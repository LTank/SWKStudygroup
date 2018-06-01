package com.company;

public class SubtractNumbers implements CalcStrategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
