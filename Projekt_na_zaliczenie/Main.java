package Projekt_na_zaliczenie;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("IT-Firma");

        initializeEmployees(company);

        Utilss.print(("\nPanel Administratora firmy ").toUpperCase() + company.getName());

        Scanner input = new Scanner(System.in);

        while (true) {
            Utilss.print("""
                    ========================================
                    Operacje:
                    0. Zakończ program
                    1. Wyświetl listę pracowników
                    2. Dodaj pracownika
                    3. Zwolnij pracownika
                    4. Zmień dane pracownika
                    5. Wyświetl pracowników danego działu
                    =========================================""");

            int number = getValidIntInput(input);
            input.nextLine(); // Consume the newline character

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
                    addNewEmployee(company, input);
                    break;

                case 3:
                    removeEmployee(company, input);
                    break;

                case 4:
                    // Zmień dane pracownika
                    Utilss.print("Tabela pracowników:");
                    Utilss.print("0 - Nie zmieniam danych, wróć do menu głównego");
                    List<Employee> employeesToUpdate = company.getEmployees();
                    int longestNameLength = employeesToUpdate.stream()
                            .mapToInt(emp -> emp.getPerson().getFullName().length())
                            .max()
                            .orElse(0);
                    int longestAddressLength = employeesToUpdate.stream()
                            .mapToInt(emp -> emp.getPerson().getAddress().toString().length())
                            .max()
                            .orElse(0);
                    String format = "%-" + (longestNameLength + 5) + "s | Dział: %-15s | Adres: %-" + (longestAddressLength + 5) + "s";

                    for (int i = 0; i < employeesToUpdate.size(); i++) {
                        Employee emp = employeesToUpdate.get(i);
                        String address = emp.getPerson().getAddress().toString();
                        Utilss.print(String.format(format, (i + 1) + " - " + emp.getPerson().getFullName(), emp.getDepartment(), address));
                    }
                    Utilss.print("Podaj ID pracownika, którego chcesz zmienić dane: ");
                    int indexToUpdate = getValidIntInput(input) - 1;
//                    input.nextLine(); // Consume the newline character
                    if (indexToUpdate == -1) {
                        break; // Powrót do głównego menu
                    }

                    if (indexToUpdate >= 0 && indexToUpdate < employeesToUpdate.size()) {
                        Employee employeeToUpdate = employeesToUpdate.get(indexToUpdate);

                        Utilss.print("""
                                Którą wartość zmienić?
                                1. Zmień Imię
                                2. Zmień Nazwisko
                                3. Zmień Adres
                                4. Zmień Department""");
                        int choice = getValidIntInput(input);
                        input.nextLine(); // Consume the newline character

                        boolean dataChanged = false;
                        switch (choice) {
                            case 1:
                                String newName = getValidStringInput(input, "Wprowadź nowe imię:");
                                employeeToUpdate.getPerson().setName(newName);
                                dataChanged = true;
                                break;

                            case 2:
                                // Zmieniamy nazwisko, ale jeśli osoba jest nieletnia, nie wykonujemy tej operacji
                                if (employeeToUpdate.getPerson().getAge() < 18) {
                                    Utilss.printUpper("Nie można zmienić nazwiska - osoba nieletnia!");
                                    break;  // Zatrzymanie dalszej zmiany
                                }
                                String newSurname = getValidStringInput(input, "Wprowadź nowe nazwisko:");
                                employeeToUpdate.getPerson().setSurname(newSurname);
                                dataChanged = true;
                                break;

                            case 3:
                                String newCity = getValidStringInput(input, "Wprowadź nowe miasto:");
                                String newStreet = getValidStringInput(input, "Wprowadź nową ulicę:");
                                employeeToUpdate.getPerson().setAddress(new Address(newCity, newStreet));
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
                    } else {
                        Utilss.printUpper("Niepoprawne ID pracownika.");
                    }
                    break;

                case 5:
                    // Wyświetl pracowników z wybranego działu
                    filterAndDisplayByDepartment(company, input);

                    break;

                default:
                    Utilss.print("Wprowadzono niepoprawne dane, proszę podać liczbę całkowitą z zakresu od 0 do 5.");
            }
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
                } else {
                    Utilss.print("Proszę wybrać numer w zakresie od " + minValue + " do " + maxValue);
                }
            } catch (InputMismatchException e) {
                Utilss.printUpper("Proszę podać liczbę całkowitą.");
                input.nextLine();
            }
        }
    }

    public static int getValidAge(Scanner input) {
        int employeeAge;

        do {
            Utilss.print("Wprowadź wiek:");
            employeeAge = getValidIntInput(input);
            input.nextLine(); // Odczytaj znak nowej linii (consume newline character)

            if (employeeAge < 16) {
                Utilss.printUpper("Za młody by pracować!");
                return -1; // Zwracamy wartość `-1` jako znak powrotu do głównego menu
            } else if (employeeAge > 65) {
                Utilss.printUpper("Czas na emeryturę, nie zatrudniamy!");
                return -1; // Zwracamy wartość `-1`, aby zakończyć pętlę i wrócić
            }
        } while (employeeAge < 16 || employeeAge > 65);

        return employeeAge; // Zwraca poprawny wiek pracownika
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

    // Metoda do kapitalizacji pierwszej litery
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

        // Sprawdzamy, czy pracownik o tym imieniu, nazwisku i wieku już istnieje
        for (Employee existingEmployee : company.getEmployees()) {
            Person existingPerson = existingEmployee.getPerson();
            if (existingPerson.getName().equals(employeeName) &&
                    existingPerson.getSurname().equals(employeeSurname) &&
                    existingPerson.getAge() == employeeAge) {
                Utilss.printUpper("Pracownik o tych danych już istnieje!");
                return;  // Zakończ metodę bez dalszego dodawania pracownika
            }
        }

        // Pobieranie danych adresowych
        String city = Main.getValidStringInput(input, "Wprowadź miasto:");
        String street = Main.getValidStringInput(input, "Wprowadź ulicę:");

        // Pobieranie danych odnośnie działu
        Utilss.print("Wybierz dział: 1.SALES, 2.ADMINISTRATION, 3.FINANCE, 4.ENGINEERS");
        int deptChoice = Main.getValidIntInput(input, 1, Department.values().length);
        Department department = Department.values()[deptChoice - 1];

        // Tworzymy nowy obiekt Address
        Address employeeAddress = new Address(city, street);

        // Tworzymy nowego pracownika za pomocą klasy CreateNewEmployee
        Employee newEmployee = createEmployee(
                city, street, employeeName, employeeSurname, employeeAge, employeeAddress, department, company
        );
        if (newEmployee != null) {
            company.getEmployees().add(newEmployee);
            Utilss.print("Dodano nowego pracownika.");
        }
    }


    public static void removeEmployee(Company company, Scanner input) {
        Utilss.print("Lista pracowników:");
        List<Employee> employeesToRemove = company.getEmployees();
        for (int i = 0; i < employeesToRemove.size(); i++) {
            Employee emp = employeesToRemove.get(i);
            Utilss.print((i + 1) + " - " + emp.getPerson().getFullName());
        }
        Utilss.print("Wybierz ID pracownika, którego chcesz zwolnić: ");
        int indexToRemove = Main.getValidIntInput(input) - 1;
        if (indexToRemove >= 0 && indexToRemove < employeesToRemove.size()) {
            Employee employeeToRemove = employeesToRemove.get(indexToRemove);
            employeesToRemove.remove(indexToRemove);
            Utilss.print("Pomyślnie zwolniono pracownika: " + employeeToRemove.getPerson().getFullName());
        } else {
            Utilss.printUpper("Niepoprawne ID pracownika.");
        }
    }


    public static Employee createEmployee(String city, String street, String employeeName, String employeeSurname, int employeeAge, Address employeeAddress, Department department, Company company) {
        // Tworzymy obiekt Person z imieniem, nazwiskiem i wiekiem
        Person newPerson = new Person(employeeName, employeeSurname, employeeAge, employeeAddress);

        // Tworzymy obiekt Address
        Address newAddress = new Address(city, street);
        newPerson.setAddress(newAddress);  // Ustawiamy adres

        // Sprawdzamy, czy taki pracownik już istnieje (porównujemy imię, nazwisko i wiek)
        for (Employee existingEmployee : company.getEmployees()) {
            Person existingPerson = existingEmployee.getPerson();
            if (existingPerson.getName().equals(employeeName) &&
                    existingPerson.getSurname().equals(employeeSurname) &&
                    existingPerson.getAge() == employeeAge) {
                Utilss.printUpper("Pracownik już istnieje!");
                return null;  // Jeśli pracownik już istnieje, zwracamy null
            }
        }

        // Jeśli pracownik nie istnieje, tworzymy nowego pracownika z przypisanym działem
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


    public static void initializeEmployees(Company company) {
        PersonDatabase personDatabase = new PersonDatabase();
        List<Employee> employeesFromDatabase = personDatabase.getEmployeeList();
        for (Employee employee : employeesFromDatabase) {
            company.getEmployees().add(employee);
        }
    }
}




