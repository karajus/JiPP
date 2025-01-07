package Projekt_na_zaliczenie;

class Person {
    private String name;
    private String surname;
    private int age;
    private Address address;

    // Konstruktor z parametrami
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = null; // Można ustawić null, jeśli nie ma adresu
    }

    // Konstruktor domyślny
    public Person() {
        this.name = "name";
        this.surname = "surname";
        this.age = 18;
        this.address = null; // Można też ustawić null dla address
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
        return name + " " + surname + " " + age + " lat.";
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
        if (this.age < 18) {
            System.out.println("Nie można zmienić nazwiska - osoba nieletnia");
        } else {
            this.surname = surname;
            System.out.println("Pomyślnie zmieniono nazwisko");
        }
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
