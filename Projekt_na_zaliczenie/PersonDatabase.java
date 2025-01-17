package Projekt_na_zaliczenie;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabase {

    private List<Employee> employeeList; // Zmieniamy listę na Employee

    public PersonDatabase() {
        employeeList = new ArrayList<>();
        loadPeopleData();  // Automatyczne ładowanie danych osób
    }

    private void loadPeopleData() {
        // Tworzymy dane i przypisujemy do listy employeeList
        addEmployee("Jan", "Kowalski", 29, "Warszawa", "Szeroka", Department.SALES);
        addEmployee("Kazimierz", "Przykładowy", 16, "Kraków", "Zielona", Department.ADMINISTRATION);
        addEmployee("Artur", "Konieczny", 35, "Wrocław", "Pięciomorgowa", Department.FINANCE);
        addEmployee("Michał", "Nowak", 25, "Poznań", "Lipowa", Department.SALES);
        addEmployee("Piotr", "Mazur", 42, "Gdańsk", "Morska", Department.ADMINISTRATION);
        addEmployee("Tomasz", "Jankowski", 27, "Warszawa", "Mokotowska", Department.FINANCE);
        addEmployee("Katarzyna", "Zielona", 31, "Łódź", "Wiatraczna", Department.SALES);
        addEmployee("Agnieszka", "Kaczmarek", 40, "Szczecin", "Mściwoja", Department.ADMINISTRATION);
        addEmployee("Zofia", "Wiśniewska", 24, "Gdynia", "Kołobrzeska", Department.FINANCE);
        addEmployee("Dawid", "Jasiński", 37, "Wrocław", "Rynkowska", Department.SALES);
    }

public void addEmployee(String name, String surname, int age, String city, String street, Department department) {
    Address address = new Address(city, street);
    Person person = new Person(name, surname, age, address);
    person.setAddress(address);
    Employee employee = new Employee(person, department);
        employeeList.add(employee); // Dodajemy pracownika do listy
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
