package Exercise6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){
        //zasady programowania - abstrakcja, hermetyzacja, polimorfis, dziedziczenie
        //clasy z dużej litery

        Person firstPerson = new Person("Jan", "Kowalski", 19);
        Person secondPerson = new Person("Kazimierz", "Przykładowy", 16);
        System.out.println(firstPerson.getFullName());
        secondPerson.setName("Artur");
        System.out.println(secondPerson.getFullName());
        secondPerson.setSurname("Konieczny");
        System.out.println(secondPerson.getFullName());

        Address address = new Address("Warszawa", "szeroka");
        firstPerson.setAddress(address);
        System.out.println(firstPerson.getAddress().getCity());

        Student firstStudent = new Student(firstPerson, 123456);
        System.out.println(firstStudent.getFullName());
        System.out.println(firstStudent.getIndexNumber());
        //dziedziczenie niejawne z klasy Object
        System.out.println(firstStudent);               //metoda public String toString

        Employee firstEmployee = new Employee(firstPerson, Department.SALES);
        System.out.println(firstEmployee.getDepartment().getName());
        Employee secondEmployee = new Employee(secondPerson, Department.ADMINISTRATION);
        Person thirdPerson = new Person("Michal", "Kowal", 55);
        Employee thirdEmployee = new Employee(thirdPerson, Department.FINANCE);

        List<Employee> employees = new ArrayList<>();                         //ala baza danych
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        System.out.println(employees);
        System.out.println(employees.size());
        System.out.println(employees.contains(firstEmployee));
        System.out.println(employees.get(1));

        Company company = new Company("Firma", address);
        company.setEmployees(employees);
        System.out.println(company.getEmployees());

        System.out.println("Panel Administratora firmy " + company.getName().toUpperCase());

        while (true) {
            System.out.println("Operacje: \n" +
                    "0. Zakończyńcz program, \n" +
                    "1. Wyświetl listę pracowników, \n" +
                    "2. Dodaj pracownika, \n" +
                    "3. Usuń pracownika \n" +
                    "4. Zmień dane pracownika");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            switch (number) {
                case 0:
                    exit(0);
                case 1:
                    Utilss.printanswer(company.getEmployees().toString());
                    break;

                case 2:

                    Utilss.printanswer("Wprowadź imie");
                    Utilss.printanswer("Wprowadź nazwisko");
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
                    Utilss.printanswer("Pomylnie zwolniono pracownika : %s %s".formatted(employee.getName(), employee.getSurname()));
                    break;
                case 4:
                    //update

                default:
                    System.out.println("Błędny input");
            }


        }




    }
}



