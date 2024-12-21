package Projekt_na_zaliczenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){

        Person firstPerson = new Person("Jan", "Kowalski", 19);
        Person secondPerson = new Person("Kazimierz", "Przykładowy", 16);
        secondPerson.setName("Artur");
        secondPerson.setSurname("Konieczny");

        Address address = new Address("Warszawa", "szeroka");
        firstPerson.setAddress(address);

        Employee firstEmployee = new Employee(firstPerson, Department.SALES);
        Employee secondEmployee = new Employee(secondPerson, Department.ADMINISTRATION);
        Person thirdPerson = new Person("Michal", "Kowal", 55);
        Employee thirdEmployee = new Employee(thirdPerson, Department.FINANCE);

        List<Employee> employees = new ArrayList<>();
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);

        Company company = new Company("Firma", address);
        company.setEmployees(employees);

        Utilss.print(("Panel Administratora firmy " + company.getName()).toUpperCase());

        while (true) {
            System.out.print("\nOperacje: \n" +
                    "0. Zakończyńcz program \n" +
                    "1. Wyświetl listę pracowników \n" +
                    "2. Dodaj pracownika \n" +
                    "3. Usuń pracownika \n" +
                    "4. Zmień dane pracownika");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            switch (number) {
                case 0:
                    Utilss.print("Do Zobaczenia!");
                    exit(0);
                case 1:
                    Utilss.print(company.getEmployees().toString());
                    break;

                case 2:

                    Utilss.print("Wprowadź imie");
                    Utilss.print("Wprowadź nazwisko");
                    String employeename = input.next();
                    String employeesurname = input.next();
                    //employees.add(new Employee(new Person(employeename, employeesurname),null);
                    break;

                case 3:
                    // usuwanie , czy napewno chcesz usunąć? potwierdzenie wszystkich oparacji
                    List<Employee> employess = company.getEmployees();
                    for (int i = 0; i < employess.size(); i++) {
                        System.out.println(i + " - " + employess.get(i).getFullName());

                    }
                    // id unikalne i niezmienne
                    int index = Utilss.inputInt("Podaj id pracownika: ");
                    Employee employee = employess.get(index);
                    employess.remove(index);
                    Utilss.print("Pomylnie zwolniono pracownika : %s %s".formatted(employee.getName(), employee.getSurname()));
                    break;
                case 4:
                    //update
                    List<Employee> employess2 = company.getEmployees();
                    for (int i = 0; i < employess2.size(); i++) {
                        System.out.println(i + " - " + employess2.get(i).getFullName());

                    }
                    // id unikalne i niezmienne
                    int index2 = Utilss.inputInt("Podaj id pracownika: ");
                    int remove = Utilss.inputInt("Którą warość zmienić?\n" +
                            "0. Nic nie zmieniam \n" +
                            "1. Zmień Imię\n" +
                            "2. Zmień Nazwisko\n" +
                            "3. Zmień Adres\n" +
                            "4. Zmień Department");

                    Utilss.print("Zmieniono dane użytkownika");
                    break;

                default:
                    System.out.println("Błędny input");
            }


        }




    }
}



