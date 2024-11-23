package Exercise6;

import java.util.List;

public class Company {
    private String name;
    private Address address;
    private List<Employee> employees;

    public Company(String name, Address address){
        this.name = name;
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees () {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
