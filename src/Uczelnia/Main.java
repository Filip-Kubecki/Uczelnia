package Uczelnia;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//      Odczyt danych
        ArrayList<Osoba> osoby  = new ArrayList<>();
        ArrayList<Kurs> kursy   = new ArrayList<>();
        Metody.deserializuj(osoby,kursy, "serializacja");

        //-------------------------------------------------------------------------------------------------------------
        Metody.wypiszPracownikow(osoby);
        //Operacje użytkownika
        Metody.sesjaUrzytkownika(kursy,osoby);

        Metody.wypiszPracownikow(osoby);

//      Zapis danych
        Metody.serializuj(osoby, kursy,"serializacja");
    }
}