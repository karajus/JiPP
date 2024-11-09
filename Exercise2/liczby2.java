package Exercise2;

public class liczby2 {
    public static void main(String[] args) {
        int inputNumber1 = Utilss.input("Podaj 1 liczbę: ");
        int inputNumber2 = Utilss.input("Podaj 2 liczbę: ");
        int inputNumber3 = Utilss.input("Podaj 3 liczbę: ");

        numberCompresionFunction(inputNumber1, inputNumber2, inputNumber3);

    }

    private static void numberCompresionFunction(int inputNumber1, int inputNumber2, int inputNumber3) {
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

}


