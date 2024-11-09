package Exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class kalkrata2 {
    public static void main(String[] args) {

        //sklep AGD,
        Scanner input = new Scanner(System.in);
        int price = inputInt("Podaj cenę towaru: ");
        int rata = inputInt("Podaj ilość rat: ");

        if (isParametersValid(price, rata)) {
            error();
        }
        //alt + contr + m
        calculatedresults(price, rata);
    }

    private static boolean isParametersValid(int price, int rata) {
        return price < 100 || price > 10_000 || rata < 6 || rata > 48;
    }

    private static void calculatedresults(int price, int rata) {
        double calKoszt = price * (1 + getOprocentowanie(rata));
        double ratamies = Math.round(calKoszt / rata);
        System.out.println("Całkowity Koszt kredytu wyniesie: " + calKoszt);
        System.out.println("rata miesieczna będzie wynosiła: " + ratamies);
    }

    private static void error() {
        System.out.println("Wartość powinna mieścić się w przedziale 100 - 10000");
        System.out.println("Wartość rat powinna mieścić się w przedziale 6 - 48");
    }

    private static double getOprocentowanie(int rata) {
        double oprocentowanie;
        if (rata <= 12) {
            oprocentowanie = 0.025;
        } else if (rata <= 24) {
            oprocentowanie = 0.05;
        } else {
            oprocentowanie = 0.1;
        }
        return oprocentowanie;
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

}
