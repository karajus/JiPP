package Projekt_na_zaliczenie;

import java.util.*;

public class Utilss {
    static String input(String message) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return input(message);
        }
    }
    static int inputInt(String message) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Przoszę podać liczbę całkowitą");
            return inputInt(message);
        }
    }
    static void print(String message) {
        System.out.println(message);
    }

    public static void displayEmployeeTable(List<Employee> employees) {
        // Header labels
        String[] headers = {"ID", "IMIĘ", "NAZWISKO", "DZIAŁ"};

        // Sort employees alphabetically by surname
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getPerson().getSurname().compareToIgnoreCase(e2.getPerson().getSurname());
            }
        });

        // Determine the maximum length for each column
        int[] columnWidths = new int[headers.length];
        columnWidths[0] = headers[0].length(); // ID
        columnWidths[1] = headers[1].length(); // Name
        columnWidths[2] = headers[2].length(); // Surname
        columnWidths[3] = headers[3].length(); // Department

        // Calculate maximum width for each column based on data
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            columnWidths[0] = Math.max(columnWidths[0], String.valueOf(i + 1).length()); // ID
            columnWidths[1] = Math.max(columnWidths[1], employee.getPerson().getName().length()); // Name
            columnWidths[2] = Math.max(columnWidths[2], employee.getPerson().getSurname().length()); // Surname
            columnWidths[3] = Math.max(columnWidths[3], employee.getDepartment().getName().length()); // Department
        }

        // Create table border dynamically
        StringBuilder border = new StringBuilder("+");
        for (int width : columnWidths) {
            border.append("-".repeat(width + 2)).append("+"); // Add padding of 2 spaces for readability
        }

        // Print the header
        System.out.println(border);
        System.out.printf("| %-"+columnWidths[0]+"s | %-"+columnWidths[1]+"s | %-"+columnWidths[2]+"s | %-"+columnWidths[3]+"s |\n",
                headers[0], headers[1], headers[2], headers[3]);
        System.out.println(border);

        // Print employee data
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("| %-"+columnWidths[0]+"d | %-"+columnWidths[1]+"s | %-"+columnWidths[2]+"s | %-"+columnWidths[3]+"s |\n",
                    i + 1,
                    employee.getPerson().getName(),
                    employee.getPerson().getSurname(),
                    employee.getDepartment().getName());
        }
        System.out.println(border);
    }

}
