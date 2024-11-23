package Exercise6;

class Student extends Person{

    private int indexNumber;

    public Student(Person person, int indexNumber){
        super(person.getName(), person.getSurname(), person.getAge());
        this.indexNumber = indexNumber;
    }

    public Student(){
        this.indexNumber = 000000;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public int getIndexNumber() {
        return indexNumber;
    }
}
