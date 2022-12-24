package Uczelnia;

import java.io.Serializable;

public class PracownikAdministracyjny extends PracownikUczelni implements Serializable {
//    Referent Specjalista StarszySpecjalista
    public enum stanowiskoPracy {
        Referent,
        Specjalista,
        StarszySpecjalista;
    }
    private stanowiskoPracy stanowisko;
//TODO kolejność w konstruktorze (liczba nadgodzin w złym miejscu)
    public PracownikAdministracyjny(String imie, String nazwisko, String PESEL, int wiek, String plec, int stazPracy, int pensja, int liczbaNadgodzin, stanowiskoPracy stanowisko) {
        super(imie, nazwisko, PESEL, wiek, plec, stazPracy, pensja, liczbaNadgodzin);
        this.stanowisko = stanowisko;
    }

    public void wypiszDane(){
        System.out.println(imie+" "+nazwisko+" Stanowisko: "+stanowisko+" Staż pracy: "+getStazPracy()+" Pensja:"+getPensja());
    }

    public stanowiskoPracy getStanowisko() {
        return stanowisko;
    }
    public void setStanowisko(stanowiskoPracy stanowisko) {
        this.stanowisko = stanowisko;
    }

}
