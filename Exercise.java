import java.util.InputMismatchException;
import java.util.Scanner;


public class Exercise {
    public static void main(String[] args) {
//        try {
//            Scanner input = new Scanner(System.in);
//            System.out.println("To jest program służący do konwersji temperatury podanej w Celsjuszach na skalę Fahrenheita. \nPodaj stopnie w Celsjuszach: ");
//            double inputNumber = input.nextDouble();
//            input.close();
//            double stopnie = (1.8 * inputNumber + 32.0);
//            stopnie = Math.round(stopnie);
//            System.out.println("Oto stopnie Fahrenheita: " + stopnie);
//
//        }catch (InputMismatchException e) {
//            System.out.println("Proszę podac liczbę całkowitą");
//
//        }

        // pobierz 3 liczby i wypisz od największsej do najmnijeszej i wypisz najmnijeszą z nich
//        try {
//            Scanner input = new Scanner(System.in);
//            System.out.println("Podaj 1 liczbę: ");
//            int inputNumber1 = input.nextInt();
//            System.out.println("Podaj 2 liczbę: ");
//            int inputNumber2 = input.nextInt();
//            System.out.println("Podaj 3 liczbę: ");
//            int inputNumber3 = input.nextInt();
//            input.close();
//
//            if(inputNumber1 < inputNumber2) {
//                if (inputNumber2 < inputNumber3) {
//                    System.out.println(inputNumber3 + ", " + inputNumber2 + ", " + inputNumber1);
//                } else if (inputNumber3 < inputNumber1) {
//                    System.out.println(inputNumber2 + ", " + inputNumber1 + ", " + inputNumber3);
//                }else {
//                    System.out.println(inputNumber2 + ", " + inputNumber3 + ", " + inputNumber1);
//                }
//            }else {
//                if(inputNumber1 < inputNumber3){
//                    System.out.println(inputNumber3 + ", " + inputNumber1 + ", " + inputNumber2);
//                }else if (inputNumber3 < inputNumber2) {
//                    System.out.println(inputNumber1 + ", " + inputNumber2 + ", " + inputNumber3);
//                }else {
//                    System.out.println(inputNumber1 + ", " + inputNumber3 + ", " + inputNumber2);
//                }
//
//            }
//
//
//        }catch (InputMismatchException e) {
//            System.out.println("Proszę podac liczbę całkowitą");
//
//        }
//
//        //int max = max(max(a, b) c);
//        //sklep AGD,
//        Scanner input = new Scanner(System.in);
//
//        int cena = 0;
//        int rata = 0;
//
//        double oprocentowanie = 0;
//        while(true) {
//            System.out.println("podaj cene towaru");
//            cena = input.nextInt();
//            if ( 100 <= cena && cena <= 10000) {
//                break;
//            }else {
//                System.out.println("Wartość powinna mieścić się w przedziale 100 - 10000");
//            }
//        }
//        while(true) {
//            System.out.println("podaj liczbe rat");
//            rata = input.nextInt();
//            if ( 6 <= rata && rata <= 48) {
//                break;
//            }else {
//                System.out.println("Wartość rat powinna mieścić się w przedziale 6 - 48");
//            }
//        }
//
//
//        if ( 100 < cena && cena < 10000) {
//            if ( 6 < rata && rata < 12){
//                oprocentowanie = 0.025;
//            } else if (13 < rata && rata < 24) {
//                oprocentowanie = 0.05;
//            }else {
//                oprocentowanie = 0.1;
//            }
//        }
//        double calKoszt = cena * (1+oprocentowanie);
//        double ratamies = Math.round(calKoszt /rata);
//        System.out.println("Całkowity Koszt kredytu wyniesie: " + calKoszt);
//        System.out.println("rata miesieczna będzie wynosiła: " + ratamies);

// KALKULATOR
//        char operator;
//        double number1, number2, result;
//
//        Scanner input = new Scanner(System.in);
//        while(true) {
//            System.out.println("Choose an operator: +, -, *, or /");
//            operator = input.next().charAt(0);
//            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
//                break;
//            } else {
//                System.out.println("Invalid operator, try again!");
//            }
//        }
//
//        // ask users to enter numbers
//        System.out.println("Enter first number: ");
//        number1 = input.nextDouble();
//
//        System.out.println("Enter second number: ");
//        number2 = input.nextDouble();
//
//        switch (operator) {
//
//            // performs addition between numbers
//            case '+':
//                result = number1 + number2;
//                System.out.println(number1 + " + " + number2 + " = " + result);
//                break;
//
//            // performs subtraction between numbers
//            case '-':
//                result = number1 - number2;
//                System.out.println(number1 + " - " + number2 + " = " + result);
//                break;
//
//            // performs multiplication between numbers
//            case '*':
//                result = number1 * number2;
//                System.out.println(number1 + " * " + number2 + " = " + result);
//                break;
//
//            // performs division between numbers
//            case '/':
//                if (number2 == 0) {
//                    System.out.println("Zero devision error");
//                }else {
//                    result = number1 / number2;
//                    System.out.println(number1 + " / " + number2 + " = " + result);
//                }
//                break;
//
////            default:
////                System.out.println("Invalid operation!");
////                break;
//        }
//
//        input.close();

        //wczytać 2 liczby A < B, wyznaczyć sumę ciągu liczb A, A+1 ... do B. oblicz 3 razy używając pętli while, do-while, for

//        Scanner input = new Scanner(System.in);
//        System.out.println("Podaj 2 cyfry całkowite:  ");
//        int A = input.nextInt();
//        int B = input.nextInt();
//        input.close();
//
//        int sum = A;
////        if (A < B) {
////
////            for (int i = A; i < B+1; i++) {
////                sum += i;
////            }
////        } else {
////            System.out.println("A musi być mniejsze od B!");
////        }
////        System.out.println(sum);
////        while(A < B) {
////            sum += A + 1;
////            A++;
////        }
////        System.out.println(sum);
//        do {
//            sum += A + 1;  // Add A + 1 to sum
//            A++;           // Increment A
//        } while (A < B);   // Continue while A is still less than B
//
//        System.out.println(sum);


        //obliczamy podatek
//        - do 85.528 podatek wynosi 18% podstawy minus 556,02 pln
        // - od 85.528 podatek wyunosi 14,839,02 + 32 % nadwyżki
        Scanner input = new Scanner(System.in);

        // Pobieramy dochód użytkownika
        System.out.print("Podaj dochód: ");
        double dochod = input.nextDouble();

        // Zmienna do przechowywania wartości podatku
        double podatek = 0;

        // Obliczanie podatku na podstawie podanych stawek
        if (dochod <= 85_528) {
            // Stawka 18% do 85 528 PLN
            podatek = dochod * 0.18 - 556.02;
        } else {
            // Stawka 32% powyżej 85 528 PLN
            podatek = 14_389.02 + (dochod - 85_528) * 0.32;
        }

        // Wyświetlenie wyniku
        System.out.printf("Podatek do zapłaty: %.2f PLN\n", podatek);
        //(tax < 0 ? 0 : tax)

        // Zamykamy obiekt Scanner
        input.close();
    }
}



