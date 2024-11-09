package Exercise2;

public class Test {
    public static void main(String[] args) {
//        int firstNumver = Utilss.input("test");
//        Utilss utils = new Utilss();
//        int secoundNumber = utils.inputObject("podaj liczbe : ");
//
//    }

        Student firstStudent = new Student("Jan", "Kowalski");
        Student secoundStudent = new Student();

        System.out.println(firstStudent.getFullName());

        Samochód firstAuto = new Samochód("Audi", "model");
        System.out.println(firstAuto.marka);



        Punkt firstpunkt = new Punkt();

        System.out.println(firstStudent.getFullName());



    }
}
 class Student {
    private String name;
    private String surname;

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
     public Student(){
         this.name = "name";
         this.surname = "surname";
     }

     public String getName() {
         return name;
     }

     public String getSurname() {
         return surname;
     }
     public String getFullName() {
         return name + " " + surname;
     }

     // zmiana imienia
     public void setname(String name) {
        this.name = name;
     }

     public void setSurname(String surname) {
         this.surname = surname;
     }
 }
 class Samochód {
     public String marka;
     public String model;

     public Samochód(String marka, String model){
         this.marka = marka;
         this.model = model;
     }
 }

class Punkt {
    public int x;
    public int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public void Increasex(){
        this.x++;
    }
    public void Increasey(){
        this.y++;
    }
    public int Increasexo(int number){
        x += number;
        return x;
    }
    public int Increaseyo(int number){
        y += number;
        return y;
    }
    public int y() {
        return y;
    }

    public int x() {
        return x;
    }
    public String xy() {
        return x + " " + y;
    }
}