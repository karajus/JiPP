package Projekt_na_zaliczenie;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("IT-Firma");

        initializeEmployees(company);

        Utilss.print(("\nPanel Administratora firmy ").toUpperCase() + company.getName());

        Scanner input = new Scanner(System.in);

        while (true) {
            Utilss.printMainOptions();

            int number = getValidIntInput(input);
            input.nextLine(); // eliminacja błędu powtórzeń

            switch (number) {
                case 0:
                    Utilss.cancelingProgram();

                case 1:
                    Utilss.displayEmployeeTable(company.getEmployees());
                    break;

                case 2:
                    addNewEmployee(company, input);
                    break;

                case 3:
                    Utilss.displayEmployeeTable(company.getEmployees());
                    removeEmployee(company, input);
                    break;

                case 4:
                    updateEmployeeData(company, input);
                    break;

                case 5:
                    filterAndDisplayByDepartment(company, input);
                    break;

                default:
                    Utilss.print("Wprowadzono niepoprawne dane, proszę podać liczbę całkowitą z zakresu od 0 do 5.");
            }
        }
    }

    public static void updateEmployeeData(Company company, Scanner input) {
        displayEmployeeData(company.getEmployees());

        Employee employeeToUpdate = employeeChoiceToUpdate(company, input);
        if (employeeToUpdate == null) {
            return;
        }

        Utilss.printEmployeeUpdateOptions();
        int choice = getValidIntInput(input);
        input.nextLine(); //walidate duplication error

        var updatingEmployee = employeeToUpdate.getPerson();
        boolean dataChanged = false;

        switch (choice) {
            case 1:
                String newName = getValidStringInput(input, "Wprowadź nowe imię:");
                updatingEmployee.setName(newName);
                dataChanged = true;
                break;

            case 2:
                // Zmieniamy nazwisko, ale jeśli osoba jest nieletnia, nie wykonujemy tej operacji
                if (updatingEmployee.getAge() < 18) {
                    Utilss.printUpper("Nie można zmienić nazwiska - osoba nieletnia!");
                    break;  // Zatrzymanie dalszej zmiany
                }
                String newSurname = getValidStringInput(input, "Wprowadź nowe nazwisko:");
                updatingEmployee.setSurname(newSurname);
                dataChanged = true;
                break;

            case 3:
                String newCity = getValidStringInput(input, "Wprowadź nowe miasto:");
                String newStreet = getValidStringInput(input, "Wprowadź nową ulicę:");
                updatingEmployee.setAddress(new Address(newCity, newStreet));
                dataChanged = true;
                break;

            case 4:
                Department selectedDepartment = getDepartmentSelection(input);
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
        int indexToUpdate = getValidIntInput(input) - 1;

        if (indexToUpdate == -1) {
            return null; // Powrót do głównego menu
        }

        if (indexToUpdate >= 0 && indexToUpdate < company.getEmployees().size()) {
            return company.getEmployees().get(indexToUpdate);
        } else {
            Utilss.printUpper("Niepoprawne ID pracownika.");
            return null;
        }
    }

    public static Department getDepartmentSelection(Scanner input) {
        Utilss.print("Wybierz dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
        int deptChoice = getValidIntInput(input, 1, Department.values().length);
        input.nextLine(); // Consume the newline character
        return Department.values()[deptChoice - 1];
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

    public static int getValidAge(Scanner input) {
        int employeeAge;

        Utilss.print("Wprowadź wiek:");
        employeeAge = getValidIntInput(input);
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


    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }


    public static void addNewEmployee(Company company, Scanner input) {
        // Pobieranie danych osobowych
        String employeeName = Main.getValidStringInput(input, "Wprowadź imię:");
        String employeeSurname = Main.getValidStringInput(input, "Wprowadź nazwisko:");
        int employeeAge = Main.getValidAge(input);
        if (employeeAge == -1) {
            return;
        }

        if (isEmployeeExists(company, employeeName, employeeSurname, employeeAge)) {
            Utilss.printUpper("Pracownik o tych danych już istnieje!");
            return;
        }

        String city = Main.getValidStringInput(input, "Wprowadź miasto:");
        String street = Main.getValidStringInput(input, "Wprowadź ulicę:");
        Department department = Main.getDepartmentSelection(input);
        Address employeeAddress = new Address(city, street);
        creatingEmployee(city, street, employeeName, employeeSurname, employeeAge, employeeAddress, department, company);
    }


    public static Employee createEmployee(String city, String street, String employeeName, String employeeSurname, int employeeAge, Address employeeAddress, Department department, Company company) {
        Person newPerson = new Person(employeeName, employeeSurname, employeeAge, employeeAddress);
        Address newAddress = new Address(city, street);
        newPerson.setAddress(newAddress);

        for (Employee existingEmployee : company.getEmployees()) {
            Person existingPerson = existingEmployee.getPerson();
            if (existingPerson.getName().equals(employeeName) &&
                    existingPerson.getSurname().equals(employeeSurname) &&
                    existingPerson.getAge() == employeeAge) {
                Utilss.printUpper("Pracownik już istnieje!");
                return null;  /
            }
        }
        return new Employee(newPerson, department);
    }


    public static void filterAndDisplayByDepartment(Company company, Scanner input) {
        Department selectedDepartment = Main.getDepartmentSelection(input);

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
    public static void creatingEmployee(String city, String street, String employeeName, String employeeSurname, int employeeAge, Address employeeAddress, Department department, Company company) {
        Employee newEmployee = createEmployee(
                city, street, employeeName, employeeSurname, employeeAge, employeeAddress, department, company
        );
        if (newEmployee != null) {
            company.getEmployees().add(newEmployee);
            Utilss.print("Dodano nowego pracownika.");
        }
    }
    public static void removeEmployee(Company company, Scanner input) {

        Utilss.print("Wybierz ID pracownika, którego chcesz zwolnić: ");
        int indexToRemove = Main.getValidIntInput(input) - 1;
        if (indexToRemove >= 0 && indexToRemove < company.getEmployees().size()) {
            Employee employeeToRemove = company.getEmployees().get(indexToRemove);
            company.getEmployees().remove(indexToRemove);
            Utilss.print("Pomyślnie zwolniono pracownika: " + employeeToRemove.getPerson().getFullName());
        } else {
            Utilss.printUpper("Niepoprawne ID pracownika.");
        }
    }
}




