package ДЗ.HW2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(2);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter the first number: ");
                double number1 = calculator.getNumber();
                System.out.println("Enter the second number: ");
                double number2 = calculator.getNumber();
                System.out.println("Enter operator (+, -, *, /):");
                char operation = calculator.getOperation();
                double result = calculator.calculate(number1, number2, operation);
                System.out.println("Result: " + result);
                System.out.println("Do you want to continue? (Y/N)");
                String inputChoice = scanner.next();
                if (inputChoice.equalsIgnoreCase("N")) {
                    System.out.println("Bye!");
                    break;
                } else if (!inputChoice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
    }
}
