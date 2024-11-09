package Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class liczby1 {
    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj 1 liczbę: ");
            int inputNumber1 = input.nextInt();
            System.out.println("Podaj 2 liczbę: ");
            int inputNumber2 = input.nextInt();
            System.out.println("Podaj 3 liczbę: ");
            int inputNumber3 = input.nextInt();
            input.close();

            if (inputNumber1 < inputNumber2) {
                if (inputNumber2 < inputNumber3) {
                    System.out.println(inputNumber3 + ", " + inputNumber2 + ", " + inputNumber1);
                } else if (inputNumber3 < inputNumber1) {
                    System.out.println(inputNumber2 + ", " + inputNumber1 + ", " + inputNumber3);
                } else {
                    System.out.println(inputNumber2 + ", " + inputNumber3 + ", " + inputNumber1);
                }
            } else {
                if (inputNumber1 < inputNumber3) {
                    System.out.println(inputNumber3 + ", " + inputNumber1 + ", " + inputNumber2);
                } else if (inputNumber3 < inputNumber2) {
                    System.out.println(inputNumber1 + ", " + inputNumber2 + ", " + inputNumber3);
                } else {
                    System.out.println(inputNumber1 + ", " + inputNumber3 + ", " + inputNumber2);
                }

            }


        } catch (InputMismatchException e) {
            System.out.println("Proszę podac liczbę całkowitą");

        }

        //int max = max(max(a, b) c);
    }
}
