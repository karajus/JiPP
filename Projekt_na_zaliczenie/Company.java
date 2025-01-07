package Projekt_na_zaliczenie;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees;

    // Konstruktor klasy Company
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

    // Dodanie pracownika
    public void addEmployee(String name, String surname, int age) {

        Person person = new Person(name, surname, age);

        Employee employee = new Employee(person, null);

        employees.add(employee);
    }
}
