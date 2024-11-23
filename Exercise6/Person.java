package Exercise6;

class Person {
    private String name;
    private String surname;
    private int age;
    private Address address;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Person(){
        this.name = "name";
        this.surname = "surname";
        this.age = 18;
    }
    public String getName() {
        return name;
    }
    public String getSurname() { return surname; }
    public int getAge(){ return age; };
    public String getFullName() {
        return name + " " + surname + " " + age + " lat.";
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addrdess) {
        this.address = addrdess;
    }

    public void setName(String name){this.name = name;}
    public void setSurname(String surname) {
        if (this.age < 18) {
            System.out.println("Nie mozna zmienić Nazwiska - osoba nieletnia");
        } else {
            this.surname = surname;
            System.out.println("Pomyślnie zmieniono Nazwisko");
        }
    }
    public void setAge(int age){this.age = age;}
}

