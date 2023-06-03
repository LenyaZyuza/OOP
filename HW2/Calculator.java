package ДЗ.HW2;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    private final int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        double scale = Math.pow(10.0, precision);
        return Math.round(result * scale) / scale;
    }

    public double div(double a, double b) {
        double result = a / b;
        if (b == 0) {
            return result;
        } else {
            double scale = Math.pow(10.0, precision);
            return Math.round(result * scale) / scale;
        }
    }

    public double getNumber() {
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Wrong input");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    public char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Wrong input");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = add(number1, number2);
                break;
            case '-':
                result = subtract(number1, number2);
                break;
            case '*':
                result = multiply(number1, number2);
                break;
            case '/':
                result = div(number1, number2);
                break;
            default:
                System.out.println("Wrong input");
                result = calculate(number1, number2, getOperation());
        }
        return result;
    }
}
