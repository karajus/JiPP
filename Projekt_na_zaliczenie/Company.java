package Projekt_na_zaliczenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String name;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Gettery i settery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static Company initializeCompany() {
        Company company = new Company("IT-Firma");
        initializeEmployees(company);
        Utilss.print(("\nPanel Administratora firmy ").toUpperCase() + company.getName());// Inicjalizacja pracowników (metoda istnieje w Company)
        return company;               // Zwrócenie obiektu Company
    }

    public static void initializeEmployees(Company company) {
        PersonDatabase personDatabase = new PersonDatabase();
        List<Employee> employeesFromDatabase = personDatabase.getEmployeeList();
        for (Employee employee : employeesFromDatabase) {
            company.getEmployees().add(employee);
        }
    }

    public static boolean isEmployeeExists(Company company, String employeeName, String employeeSurname, int employeeAge) {
        for (Employee existingEmployee : company.getEmployees()) {
            Person existingPerson = existingEmployee.getPerson();
            if (existingPerson.getName().equals(employeeName) &&
                    existingPerson.getSurname().equals(employeeSurname) &&
                    existingPerson.getAge() == employeeAge) {
                return true;
            }
        }
        return false;
    }

    public static void addNewEmployee(Company company, Scanner input) {
        String employeeName = Utilss.getValidStringInput(input, "Wprowadź imię:");
        String employeeSurname = Utilss.getValidStringInput(input, "Wprowadź nazwisko:");
        int employeeAge = Company.getValidAge(input);
        if (employeeAge == -1) {
            return;
        }

        if (isEmployeeExists(company, employeeName, employeeSurname, employeeAge)) {
            Utilss.printUpper("Pracownik o tych danych już istnieje!");
            return;
        }

        String city = Utilss.getValidStringInput(input, "Wprowadź miasto:");
        String street = Utilss.getValidStringInput(input, "Wprowadź ulicę:");
        Department department = Department.getDepartmentSelection(input);
        Address employeeAddress = new Address(city, street);
        Employee.creatingEmployee(city, street, employeeName, employeeSurname, employeeAge, employeeAddress, department, company);
    }

    public static int getValidAge(Scanner input) {
        int employeeAge;

        Utilss.print("Wprowadź wiek:");
        employeeAge = Utilss.getValidIntInput(input);
        input.nextLine();

        if (employeeAge < 16) {
            Utilss.printUpper("Za młody by pracować!");
            return -1;
        } else if (employeeAge > 65) {
            Utilss.printUpper("Czas na emeryturę, nie zatrudniamy!");
            return -1;
        }

        return employeeAge;
    }

    public static void removeEmployee(Company company, Scanner input) {

        Utilss.print("Wybierz ID pracownika, którego chcesz zwolnić: ");
        int indexToRemove = Utilss.getValidIntInput(input) - 1;
        if (indexToRemove >= 0 && indexToRemove < company.getEmployees().size()) {
            Employee employeeToRemove = company.getEmployees().get(indexToRemove);
            company.getEmployees().remove(indexToRemove);
            Utilss.print("Pomyślnie zwolniono pracownika: " + employeeToRemove.getPerson().getFullName());
        } else {
            Utilss.printUpper("Niepoprawne ID pracownika.");
        }
    }

}
