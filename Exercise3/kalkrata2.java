package Exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class kalkrata2 {
    public static void main(String[] args) {

        //sklep AGD,
        Scanner input = new Scanner(System.in);
        int cena = 0;
        int rata = 0;

        double oprocentowanie = 0;
        while (true) {
            cena = inputInt("podaj cene towaru");
            if (100 <= cena && cena <= 10000) {
                break;
            } else {
                System.out.println("Wartość powinna mieścić się w przedziale 100 - 10000");
            }
        }
        while (true) {
            rata = inputInt("podaj liczbe rat");
            if (6 <= rata && rata <= 48) {
                break;
            } else {
                System.out.println("Wartość rat powinna mieścić się w przedziale 6 - 48");
            }
        }


        if (100 < cena && cena < 10000) {
            if (6 < rata && rata < 12) {
                oprocentowanie = 0.025;
            } else if (13 < rata && rata < 24) {
                oprocentowanie = 0.05;
            } else {
                oprocentowanie = 0.1;
            }
        }
        double calKoszt = cena * (1 + oprocentowanie);
        double ratamies = Math.round(calKoszt / rata);
        System.out.println("Całkowity Koszt kredytu wyniesie: " + calKoszt);
        System.out.println("rata miesieczna będzie wynosiła: " + ratamies);

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
