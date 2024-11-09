package Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilss {
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
    int inputObject(String message) {
        try {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return inputObject(message);
        }
    }
}
