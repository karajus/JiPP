import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //pecix
//        System.out.println("Hello World");
//        int number = 5;
//        System.out.println(number);
//        number = 3;
//        number += 10;
//        System.out.println(number);
//        number -= 10;
//        System.out.println(number);
//        number *= 10;
//        System.out.println(number);
//        number /= 10;
//        System.out.println(number);
//
//        int firstNumber = 15;
//        int secondNumber = 7;
//        int sum = firstNumber + secondNumber;
//        System.out.println(sum);
//        int minus = firstNumber - secondNumber;
//        System.out.println(minus);
//        int modulo = firstNumber % secondNumber;
//        System.out.println(modulo);
//        int dzielenie = firstNumber / secondNumber;
//        System.out.println(dzielenie);
//
//        float myfloatNumber = 12.0005f;
//        double mydouble = 12.000000005d;
//        float myfirstNumber = 16;
//        System.out.println(mydouble / myfloatNumber);
//        System.out.println(mydouble % myfloatNumber);
//
//        boolean bool1 = true;
//        boolean bool2 = false;
//        System.out.print(!(bool1 || bool2));
//        System.out.print(!(bool1 && bool2));
//        System.out.print(bool1 || bool2);
//        System.out.print(bool1 || bool2);
//
//        int imputNumber = 5;
//        int imputNumber2 = 7;
//        if (imputNumber > imputNumber2) {
//            System.out.println("Liczba " + imputNumber + " jest większa niż " + imputNumber2);
//        } else if (imputNumber == imputNumber2) {
//            System.out.println("Liczba " + imputNumber + " jest równa niż " + imputNumber2);
//        } else {
//            System.out.println("Liczba " + imputNumber + " jest mniejsza niż " + imputNumber2);
//        }
//
//        //switch() {
//        //    case
//        //}
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + ", ");
//        }

//

//        Scanner input = new Scanner(System.in);
//        System.out.println("To jest program mówiacy czy liczba jest parzysta lub nieparzyta /n Wpisz liczbę: ");
//        int inputNumber = input.nextInt();
//        input.close();
//        if (inputNumber % 2 == 0) {
//            System.out.println("Liczba jest parzysta.");
//        } else {
//            System.out.println("Liczba jest nie parzysta.");
//
//        }


//        //STAŁA WIEKĄ LITERĄ
//        final  int CONDITION_NUMBER= 10;
//        Scanner input = new Scanner(System.in);
//        System.out.println("To jest program mówiacy czy liczba jest większa od 10.\nWpisz liczbę: ");
//        int inputNumber = input.nextInt();
//        input.close();
//        if (inputNumber > CONDITION_NUMBER) {
//            System.out.println("Liczba jest większa od" + CONDITION_NUMBER + ".");
//        } else if (inputNumber == CONDITION_NUMBER)
//            System.out.println("Liczba jest równa 10" + CONDITION_NUMBER + ".");
//
//        else {
//            System.out.println("Liczba jest mniejsza od 10.");
//
//        }
        //Arrays.stream(args).forEach(System..)


        boolean count = false;
        while (!count){
            //STAŁA WIEKĄ LITERĄ
            //final  int CONDITION_NUMBER= 10;
            Scanner input = new Scanner(System.in);
            System.out.println("Wpisz liczbę: ");

            try {
                int inputNumber = input.nextInt();
                input.close();
                if (inputNumber < 1){
                    throw new InputMismatchException();

                }else {

                    for (int j = 1; j <= inputNumber; j++) {
                        for (int i = 1; i <= inputNumber; i++) {
                            if (i == inputNumber) {
                                System.out.print(i + "\n");
                            } else {
                                System.out.print(i + ", ");
                            }
                        }
                    }
                    count = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Proszę podac liczbę całkowitą");


            }
        }

















    }

}
