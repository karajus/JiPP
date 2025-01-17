package Projekt_na_zaliczenie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Company company = Company.initializeCompany();

        Scanner input = new Scanner(System.in);

        while (true) {
            Utilss.printMainOptions();
            int number = Utilss.getValidIntInput(input, 0, 5);
            input.nextLine(); // eliminacja błędu powtórzeń

            switch (number) {
                case 0:
                    Utilss.cancelingProgram();

                case 1:
                    Utilss.displayEmployeeTable(company.getEmployees());
                    break;

                case 2:
                    Company.addNewEmployee(company, input);
                    break;

                case 3:
                    Utilss.displayEmployeeTable(company.getEmployees());
                    Company.removeEmployee(company, input);
                    break;

                case 4:
                    Employee.updateEmployeeData(company, input);
                    break;

                case 5:
                    Department.filterAndDisplayByDepartment(company, input);
                    break;

                default:
                    Utilss.print("Wprowadzono niepoprawne dane.");
            }
        }
    }
}




