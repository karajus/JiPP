package Projekt_na_zaliczenie;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        // Baza osób
        PersonDatabase personDatabase = new PersonDatabase();
        List<Employee> employeesFromDatabase = personDatabase.getEmployeeList();

        // Nazwa Firmy

        Company company = new Company("IT-Firma");

        // Dodajemy pracowników z bazy danych do firmy
        for (Employee employee : employeesFromDatabase) {
            company.getEmployees().add(employee);
        }

        // Panel Administratora firmy
        Utilss.print(("\nPanel Administratora firmy ").toUpperCase() + company.getName());

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("========================================\n" +
                    "Operacje: \n" +
                    "0. Zakończ program \n" +
                    "1. Wyświetl listę pracowników \n" +
                    "2. Dodaj pracownika \n" +
                    "3. Usuń pracownika \n" +
                    "4. Zmień dane pracownika \n" +
                    "5. Wyświetl pracowników danego działu\n" +
                    "========================================\n");

            int number = getValidIntInput(input);

            switch (number) {
                case 0:
                    Utilss.print("Do Zobaczenia!");
                    exit(0);

                case 1:
                    // Wyświetl listę pracowników
                    Utilss.print("Lista pracowników:");
                    Utilss.displayEmployeeTable(company.getEmployees());

                    break;

                case 2:
                    // Dodaj nowego pracownika
                    String employeeName = getValidStringInput(input, "Wprowadź imię:");
                    String employeeSurname = getValidStringInput(input, "Wprowadź nazwisko:");

                    int employeeAge;
                    do {
                        Utilss.print("Wprowadź wiek:");
                        employeeAge = getValidIntInput(input);
                        if (employeeAge < 16) {
                            Utilss.print("Za młody by pracować");
                            break; // Powrót do głównego menu
                        } else if (employeeAge > 65) {
                            Utilss.print("Czas na emeryturę, nie zatrudniamy");
                            break; // Powrót do głównego menu
                        }
                    } while (employeeAge < 16 || employeeAge > 65);

                    if (employeeAge < 16 || employeeAge > 65) {
                        break; // Powrót do głównego menu
                    }

                    String city = getValidStringInput(input, "Wprowadź miasto:");
                    String street = getValidStringInput(input, "Wprowadź ulicę:");

                    Utilss.print("Wybierz dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
                    int deptChoice = getValidIntInput(input, 1, Department.values().length);
                    Department department = Department.values()[deptChoice - 1];

                    // Tworzymy nowego pracownika
                    Address newAddress = new Address(city, street);
                    Person newPerson = new Person(employeeName, employeeSurname, employeeAge);
                    newPerson.setAddress(newAddress);
                    Employee newEmployee = new Employee(newPerson, department);

                    // Dodajemy nowego pracownika do listy
                    if (company.getEmployees().contains(newEmployee)) {
                        Utilss.print("Pracownik już istnieje!");
                    } else {
                        company.getEmployees().add(newEmployee);
                        Utilss.print("Dodano nowego pracownika.");
                    }
                    break;

                case 3:
                    // Usuń pracownika
                    Utilss.print("Lista pracowników:");
                    List<Employee> employeesToRemove = company.getEmployees();
                    for (int i = 0; i < employeesToRemove.size(); i++) {
                        Employee emp = employeesToRemove.get(i);
                        System.out.println((i + 1) + " - " + emp.getPerson().getFullName());
                    }

                    int indexToRemove = getValidIntInput(input) - 1;
                    if (indexToRemove >= 0 && indexToRemove < employeesToRemove.size()) {
                        Employee employeeToRemove = employeesToRemove.get(indexToRemove);
                        employeesToRemove.remove(indexToRemove);
                        Utilss.print("Pomyślnie zwolniono pracownika: " + employeeToRemove.getPerson().getFullName());
                    } else {
                        Utilss.print("Niepoprawne ID pracownika.");
                    }
                    break;

                case 4:
                    // Zmień dane pracownika
                    Utilss.print("Lista pracowników:");
                    System.out.println("0 - Nie zmieniam danych, wróć do menu głównego");
                    List<Employee> employeesToUpdate = company.getEmployees();
                    for (int i = 0; i < employeesToUpdate.size(); i++) {
                        Employee emp = employeesToUpdate.get(i);
                        System.out.println((i + 1) + " - " + emp.getPerson() + ", Dział: " + emp.getDepartment());
                    }


                    int indexToUpdate = getValidIntInput(input) - 1;
                    if (indexToUpdate == -1) {
                        break; // Powrót do głównego menu
                    }

                    if (indexToUpdate >= 0 && indexToUpdate < employeesToUpdate.size()) {
                        Employee employeeToUpdate = employeesToUpdate.get(indexToUpdate);

                        Utilss.print("Którą wartość zmienić?\n" +
                                "1. Zmień Imię\n" +
                                "2. Zmień Nazwisko\n" +
                                "3. Zmień Adres\n" +
                                "4. Zmień Department");
                        int choice = getValidIntInput(input);

                        switch (choice) {

                            case 1:
                                String newName = getValidStringInput(input, "Wprowadź nowe imię:");
                                employeeToUpdate.getPerson().setName(newName);
                                break;

                            case 2:
                                String newSurname = getValidStringInput(input, "Wprowadź nowe nazwisko:");
                                employeeToUpdate.getPerson().setSurname(newSurname);
                                break;

                            case 3:
                                String newCity = getValidStringInput(input, "Wprowadź nowe miasto:");
                                String newStreet = getValidStringInput(input, "Wprowadź nową ulicę:");
                                employeeToUpdate.getPerson().setAddress(new Address(newCity, newStreet));
                                break;

                            case 4:
                                Utilss.print("Wybierz nowy dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
                                int newDeptChoice = getValidIntInput(input, 1, Department.values().length);
                                Department newDept = Department.values()[newDeptChoice - 1];
                                employeeToUpdate.setDepartment(newDept);
                                break;

                            default:
                                Utilss.print("Nie zmieniono danych.");
                        }
                        Utilss.print("Zmieniono dane pracownika.");
                    } else {
                        Utilss.print("Niepoprawne ID pracownika.");
                    }
                    break;

                case 5:
                    // Wyświetl pracowników z wybranego działu
                    Utilss.print("Wybierz dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
                    int deptChoice2 = getValidIntInput(input, 1, Department.values().length);
                    Department selectedDepartment = Department.values()[deptChoice2 - 1];


                    List<Employee> filteredEmployees = company.getEmployees().stream()
                            .filter(emp -> emp.getDepartment() == selectedDepartment)
                            .sorted(Comparator.comparing(emp -> emp.getPerson().getFullName()))
                            .collect(Collectors.toList());

                    if (filteredEmployees.isEmpty()) {
                        Utilss.print("brak pracowników w dziale ".toUpperCase() + selectedDepartment);
                    } else {
                        Utilss.print("Pracownicy w dziale " + selectedDepartment + ":");
                        Utilss.displayEmployeeTable(filteredEmployees);
                    }

                    break;

                default:
                    System.out.println("Błędny input");
            }
        }
    }

    private static int getValidIntInput(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Proszę podać liczbę całkowitą.");
                input.nextLine();
            }
        }
    }

    private static int getValidIntInput(Scanner input, int minValue, int maxValue) {
        while (true) {
            try {
                int choice = input.nextInt();
                if (choice >= minValue && choice <= maxValue) {
                    return choice;
                } else {
                    System.out.println("Proszę wybrać numer w zakresie od " + minValue + " do " + maxValue);
                }
            } catch (InputMismatchException e) {
                System.out.println("Proszę podać liczbę całkowitą.");
                input.nextLine();
            }
        }
    }

    // Metoda do walidacji stringów
    private static String getValidStringInput(Scanner input, String prompt) {
        String value;
        do {
            Utilss.print(prompt);
            value = input.nextLine();
            if (value.isEmpty() || value.matches(".*\\d.*") || value.length() < 3) {
                Utilss.print("Wprowadź poprawne dane (minimum 3 litery, bez cyfr)");
            }
        } while (value.isEmpty() || value.matches(".*\\d.*") || value.length() < 3);
        return capitalizeFirstLetter(value);
    }

    // Metoda do kapitalizacji pierwszej litery
    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
