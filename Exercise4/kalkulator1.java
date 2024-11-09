
package Exercise4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class kalkulator1 {
    public static void main(String[] args) {
        char operator;
        double number1, number2, result;

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Choose an operator: +, -, *, or /");
            operator = input.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                break;
            } else {
                System.out.println("Invalid operator, try again!");
            }
        }

        // ask users to enter numbers
        System.out.println("Enter first number: ");
        number1 = input.nextDouble();

        System.out.println("Enter second number: ");
        number2 = input.nextDouble();

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
                }else {
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                }
                break;

//            default:
//                System.out.println("Invalid operation!");
//                break;
        }

        input.close();
    }
}
