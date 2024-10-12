import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        Scanner input = new Scanner(System.in);
        System.out.println("To jest program mówiacy czy liczba jest parzysta lub nieparzyta /n Wpisz liczbę: ");
        int inputNumber = input.nextInt();
        input.close();
        if (inputNumber % 2 == 0) {
            System.out.println("Liczba jest parzysta.");
        } else {
            System.out.println("Liczba jest nie parzysta.");
        }


















    }

}
