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
        String ageSuffix = (age % 10 == 2 && age % 100 != 12) ? "lata" : "lat";
        return name + " " + surname + " " + age + " " + ageSuffix;
    }

    public Address getAddress() {
        return address;
    }

    //Settery
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        System.out.println("Pomyślnie zmieniono nazwisko");
    }

    public void setAge(int age) {
        this.age = age;
    }

}
