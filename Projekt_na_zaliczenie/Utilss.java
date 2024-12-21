package Projekt_na_zaliczenie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilss {
    static String input(String message) {
        try {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return input(message);
        }
    }
    static int inputInt(String message) {
        try {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return inputInt(message);
        }
    }
    static void print(String message) {
        System.out.println(message);
    }
}
