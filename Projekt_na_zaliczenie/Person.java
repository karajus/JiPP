package Projekt_na_zaliczenie;

public class Person {
    private String name;
    private String surname;
    private int age;
    private Address address;

    // Konstruktor z parametrami
    public Person(String name, String surname, int age, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    // Gettery
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return name + " " + surname + " " + age + " lat";
    }
    @Override
    public String toString() {
        String displayAddress = (address == null) ? new Address().toString() : address.toString();
        return getFullName() + ", " + age + " lat, Adres: " + displayAddress;
    }

    public Address getAddress() {
        return address;
    }

    // Setter dla Address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Setter dla Name
    public void setName(String name) {
        this.name = name;
    }

    // Setter dla Surname z walidacją wieku
    public void setSurname(String surname) {
        this.surname = surname;
        System.out.println("Pomyślnie zmieniono nazwisko");
    }

    // Setter dla Age
    public void setAge(int age) {
        this.age = age;
    }
    // Metoda do wyświetlania pełnych danych osoby
    public String getFullInfo() {
        return "Imię: " + name + ", Nazwisko: " + surname + ", Wiek: " + age + ", Adres: " + address.getFullAddress();
    }
}
