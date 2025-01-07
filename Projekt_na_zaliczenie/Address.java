package Projekt_na_zaliczenie;

class Address {
    private String city;
    private String street;

    // Konstruktor z parametrami
    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    // Konstruktor domyślny
    public Address() {
        this.city = "City";
        this.street = "Street";
    }

    // Gettery
    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    // Settery
    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Metoda zwracająca pełny adres
    public String getFullAddress() {
        return city + ", " + street;
    }
}
