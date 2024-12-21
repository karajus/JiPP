package Projekt_na_zaliczenie;

public enum Department {
    SALES("Sprzedaż"),
    FINANCE("Finanse"),
    ADMINISTRATION("ADMINISTRACJA");

    private final String name;
    private Department(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }

}