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

        System.out.println("Panel Administratora firmy " + company.getName());

        boolean done = false;
        while (!done) {
            System.out.println("Wciśnij 1 by zakończyć, wciśnij 2 by wyświetlić pracowników");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number == 1) {
                exit(0);
            } else if (number == 2) {
                System.out.println(company.getEmployees());

            } else if (number ==3) {

                System.out.println("Wprowadź imie");
                System.out.println("Wprowadź nazwisko");
                String employeename = input.next();
                String employeesurname = input.next();
                employees.add(new Employee(new Person(employeename, employeesurname),null);

            }
            }else {
                System.out.println("błędny input");
            }


        }




    }
}



