package Exercise6;

class Address{
    private String city;
    private String street;

    public Address(String City, String Street){
        this.city = City;
        this.street = Street;
    }

    public Address(){
        this.city = "City";
        this.street = "Street";
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getFullAddress(){return city + " " + street;}
}
