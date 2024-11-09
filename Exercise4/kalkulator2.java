package Exercise4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class kalkulator2 {
    public static void main(String[] args) {
        char operator;
        double number1, number2, result;

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operator: +, -, *, or /");
            operator = input.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                break;
            } else {
                System.out.println("Invalid operator, try again!");
            }
        }

        // ask users to enter numbers

        number1 = input("Enter first number: ");
        number2 = input("Enter second number: ");

        switch (operator) {

            // performs addition between numbers
            case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            // performs subtraction between numbers
            case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            // performs multiplication between numbers
            case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            // performs division between numbers
            case '/':
                if (number2 == 0) {
                    System.out.println("Zero devision error");
                } else {
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                }
                break;

        }
    }


    static double input(String message) {
        try {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return input(message);
        }

    }

}
