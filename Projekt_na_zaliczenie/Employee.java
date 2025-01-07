package Projekt_na_zaliczenie;

public class Employee extends Person{

    private Department department;
    public Employee(Person person, Department department){
        super(person.getName(), person.getSurname(), person.getAge());
        this.department = department;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Person getPerson() {
        return this;
    }
}
