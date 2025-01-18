package Projekt_na_zaliczenie;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Employee extends Person{

    private Department department;
    public Employee(Person person, Department department){
        super(person.getName(), person.getSurname(), person.getAge(), person.getAddress());
        this.department = department;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Person getPerson() {
        return this;
    }


    public static void displayEmployeeData(List<Employee> employees) {
        employees.sort(Comparator.comparing(emp -> emp.getPerson().getSurname()));

        Utilss.print("Tabela pracowników:");
        Utilss.print("0 - Nie zmieniam danych, wróć do menu głównego");

        int longestNameLength = employees.stream()
                .mapToInt(emp -> emp.getPerson().getFullName().length())
                .max()
                .orElse(0);

        int longestAddressLength = employees.stream()
                .mapToInt(emp -> emp.getPerson().getAddress().toString().length())
                .max()
                .orElse(0);

        String format = "%-" + (longestNameLength + 5) + "s | Dział: %-15s | Adres: %-" + (longestAddressLength + 5) + "s";

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            String address = emp.getPerson().getAddress().toString();
            Utilss.print(String.format(format, (i + 1) + " - " + emp.getPerson().getFullName(), emp.getDepartment(), address));
        }
    }

    public static void creatingEmployee(String city, String street, String employeeName, String employeeSurname, int employeeAge, Address employeeAddress, Department department, Company company) {
        Person newPerson = new Person(employeeName, employeeSurname, employeeAge, employeeAddress);
        Address newAddress = new Address(city, street);
        newPerson.setAddress(newAddress);

        for (Employee existingEmployee : company.getEmployees()) {
            Person existingPerson = existingEmployee.getPerson();
            if (existingPerson.getName().equals(employeeName) &&
                    existingPerson.getSurname().equals(employeeSurname) &&
                    existingPerson.getAge() == employeeAge) {
                Utilss.printUpper("Pracownik już istnieje!");
                return;
            }
        }
        Employee newEmployee = new Employee(newPerson, department);
        company.getEmployees().add(newEmployee);
        Utilss.print("Dodano nowego pracownika.");
    }

    public static void updateEmployeeData(Company company, Scanner input) {
        displayEmployeeData(company.getEmployees());

        Employee employeeToUpdate = employeeChoiceToUpdate(company, input);
        if (employeeToUpdate == null) {
            return;
        }

        Utilss.printEmployeeUpdateOptions();
        int choice = Utilss.getValidIntInput(input);
        input.nextLine(); //walidate duplication error

        var updatingEmployee = employeeToUpdate.getPerson();
        boolean dataChanged = false;

        switch (choice) {
            case 1:
                String newName = Utilss.getValidStringInput(input, "Wprowadź nowe imię:");
                updatingEmployee.setName(newName);
                dataChanged = true;
                break;

            case 2:
                if (updatingEmployee.getAge() < 18) {
                    Utilss.printUpper("Nie można zmienić nazwiska - osoba nieletnia!");
                    break;  // Zatrzymanie dalszej zmiany
                }
                String newSurname = Utilss.getValidStringInput(input, "Wprowadź nowe nazwisko:");
                updatingEmployee.setSurname(newSurname);
                dataChanged = true;
                break;

            case 3:
                String newCity = Utilss.getValidStringInput(input, "Wprowadź nowe miasto:");
                String newStreet = Utilss.getValidStringInput(input, "Wprowadź nową ulicę:");
                updatingEmployee.setAddress(new Address(newCity, newStreet));
                dataChanged = true;
                break;

            case 4:
                Department selectedDepartment = Department.getDepartmentSelection(input);
                employeeToUpdate.setDepartment(selectedDepartment);
                dataChanged = true;
                break;

            default:
                Utilss.printUpper("Nie zmieniono danych.");

        }
        if (dataChanged) {
            Utilss.print("Zmieniono dane pracownika.");
        }

    }

    public static Employee employeeChoiceToUpdate(Company company, Scanner input) {
        Utilss.print("Podaj ID pracownika, którego chcesz zmienić dane: ");
        int indexToUpdate = Utilss.getValidIntInput(input) - 1;

        if (indexToUpdate == -1) {
            return null;
        }

        if (indexToUpdate >= 0 && indexToUpdate < company.getEmployees().size()) {
            return company.getEmployees().get(indexToUpdate);
        } else {
            Utilss.printUpper("Niepoprawne ID pracownika.");
            return null;
        }
    }
}


