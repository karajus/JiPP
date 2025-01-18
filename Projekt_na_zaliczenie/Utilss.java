package Projekt_na_zaliczenie;

import java.util.*;

public class Utilss {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printUpper(String message) {
        System.out.println(message.toUpperCase());
    }

    public static String getValidStringInput(Scanner input, String prompt) {
        String value;
        do {
            Utilss.print(prompt);
            value = input.nextLine();
            if (value.matches(".*\\d.*") || value.length() < 3) {
                Utilss.print("Wprowadź poprawne dane (minimum 3 litery, bez cyfr).");
            }
        } while (value.matches(".*\\d.*") || value.length() < 3);
        return capitalizeFirstLetter(value);
    }

    public static int getValidIntInput(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                Utilss.printUpper("Proszę podać liczbę całkowitą.");
                input.nextLine();
            }
        }
    }

    public static int getValidIntInput(Scanner input, int minValue, int maxValue) {
        while (true) {
            try {
                int choice = input.nextInt();
                if (choice >= minValue && choice <= maxValue) {
                    return choice;
                } else Utilss.print(STR."Proszę wybrać numer w zakresie od \{minValue} do \{maxValue}");
            } catch (InputMismatchException e) {
                Utilss.printUpper("Proszę podać liczbę całkowitą.");
                input.nextLine();
            }
        }
    }

    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void cancelingProgram(){
        Utilss.print("Do Zobaczenia!");
        System.exit(0);
    }

    public static void printMainOptions() {
        Utilss.print("""
                ========================================
                Operacje:
                0. Zakończ program
                1. Wyświetl listę pracowników
                2. Dodaj pracownika
                3. Zwolnij pracownika
                4. Zmień dane pracownika
                5. Wyświetl pracowników danego działu
                =========================================
                (Podaj numer operacji)""");
    }

    public static void printEmployeeUpdateOptions(){
        Utilss.print("""
                Którą wartość zmienić? (Podaj numer operacji)
                1. Zmień Imię
                2. Zmień Nazwisko
                3. Zmień Adres
                4. Zmień Department""");
    }

    public static void displayEmployeeTable(List<Employee> employees) {

        Utilss.print("Lista pracowników:");
        // Header labels
        String[] headers = {"ID", "IMIĘ", "NAZWISKO", "WIEK", "DZIAŁ"};

        // Sort employees alphabetically by surname
        employees.sort(Comparator.comparing(e -> e.getPerson().getSurname(), String.CASE_INSENSITIVE_ORDER));

        // Determine the maximum length for each column
        int[] columnWidths = new int[headers.length];
        columnWidths[0] = headers[0].length(); // ID
        columnWidths[1] = headers[1].length(); // Name
        columnWidths[2] = headers[2].length(); // Surname
        columnWidths[3] = headers[3].length(); // Age
        columnWidths[4] = headers[4].length(); // Department

        // Calculate maximum width for each column based on data
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            columnWidths[0] = Math.max(columnWidths[0], String.valueOf(i + 1).length()); // ID
            columnWidths[1] = Math.max(columnWidths[1], employee.getPerson().getName().length()); // Name
            columnWidths[2] = Math.max(columnWidths[2], employee.getPerson().getSurname().length()); // Surname
            columnWidths[3] = Math.max(columnWidths[3], (employee.getPerson().getAge() + " lat ").length()); // Age
            columnWidths[4] = Math.max(columnWidths[4], employee.getDepartment().getName().length()); // Department
        }

        // Dynamic table generation
        StringBuilder borderLine = new StringBuilder("+");
        for (int width : columnWidths) {
            borderLine.append("-".repeat(width + 2)).append("+"); // Flexible top and bottom border
        }

        String border = borderLine.toString();
        print(border);

        // Print header row with proper dynamic adjustments
        System.out.printf("| %-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %-" + columnWidths[3] + "s | %-" + columnWidths[4] + "s |\n",
        headers[0], headers[1], headers[2], headers[3], headers[4]);
        print(border);

        // Print rows with dynamic formatting adjustments
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("| %-" + columnWidths[0] + "d | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s | %-" + columnWidths[3] + "s | %-" + columnWidths[4] + "s |\n",
            i + 1,
            employee.getPerson().getName(),
            employee.getPerson().getSurname(),
            employee.getPerson().getAge() + (employee.getPerson().getAge() % 10 == 2 ? " lata" : " lat"),
            employee.getDepartment().getName());
        }
        print(border);
    }

}
