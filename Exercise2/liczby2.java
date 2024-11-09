package Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class liczby2 {
    public static void main(String[] args) {
            int inputNumber1 = input("Podaj 1 liczbę: ");
        int inputNumber2 = input("Podaj 2 liczbę: ");
        int inputNumber3 = input("Podaj 3 liczbę: ");

        if(inputNumber1 < inputNumber2) {
                if (inputNumber2 < inputNumber3) {
                    System.out.println(inputNumber3 + ", " + inputNumber2 + ", " + inputNumber1);
                } else if (inputNumber3 < inputNumber1) {
                    System.out.println(inputNumber2 + ", " + inputNumber1 + ", " + inputNumber3);
                }else {
                    System.out.println(inputNumber2 + ", " + inputNumber3 + ", " + inputNumber1);
                }
            }else {
            if (inputNumber1 < inputNumber3) {
                System.out.println(inputNumber3 + ", " + inputNumber1 + ", " + inputNumber2);
            } else if (inputNumber3 < inputNumber2) {
                System.out.println(inputNumber1 + ", " + inputNumber2 + ", " + inputNumber3);
            } else {
                System.out.println(inputNumber1 + ", " + inputNumber3 + ", " + inputNumber2);
            }
        }

}


static int input(String message) {
    try {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Przoszę podać liczbę całkowitą");
        return input(message);
    }

}
}


