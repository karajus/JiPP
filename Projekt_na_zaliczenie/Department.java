package Projekt_na_zaliczenie;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public enum Department {
    SALES("Sprzedaż"),
    ADMINISTRATION("Administracja"),
    FINANCE("Finanse"),
    ENGINEERS("Inżynierowie");

    private final String name;
    private Department(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    public static Department getDepartmentSelection(Scanner input) {
        Utilss.print("Wybierz dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
        int deptChoice = Utilss.getValidIntInput(input, 1, Department.values().length);
        input.nextLine(); // Consume the newline character
        return Department.values()[deptChoice - 1];
    }

    public static void filterAndDisplayByDepartment(Company company, Scanner input) {
        Department selectedDepartment = getDepartmentSelection(input);

        List<Employee> filteredEmployees = company.getEmployees().stream()
                .filter(emp -> emp.getDepartment() == selectedDepartment)
                .sorted(Comparator.comparing(emp -> emp.getPerson().getFullName()))
                .collect(Collectors.toList());

        if (filteredEmployees.isEmpty()) {
            Utilss.printUpper("Brak pracowników w dziale " + selectedDepartment);
        } else {
            Utilss.print("Pracownicy w dziale " + selectedDepartment + ":");
            Utilss.displayEmployeeTable(filteredEmployees);
        }
    }

}
