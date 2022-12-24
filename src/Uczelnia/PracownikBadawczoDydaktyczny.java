package Uczelnia;

import java.io.Serializable;

public class PracownikBadawczoDydaktyczny extends PracownikUczelni implements Serializable {

//    Asystent Adiunktt ProfesorNadzwyczajny ProfesorZwyczajny Wykładowca
    public enum stanowiskoPracy {
        Asystent,
        Adiunktt,
        ProfesorNadzwyczajny,
        ProfesorZwyczajny,
        Wykładowca;
    }
    private int liczbaPublikacji;
    private stanowiskoPracy stanowisko;

    public PracownikBadawczoDydaktyczny(String imie, String nazwisko, String PESEL, int wiek, String plec, int stazPracy, int pensja, int liczbaPublikacji, stanowiskoPracy stanowisko, int liczbaNadgodzin) {
        super(imie, nazwisko, PESEL, wiek, plec, stazPracy, pensja, liczbaNadgodzin);
        this.liczbaPublikacji = liczbaPublikacji;
        this.stanowisko = stanowisko;
    }

    public void wypiszDane(){
        System.out.println(imie+" "+nazwisko+" Stanowisko: "+stanowisko+" Staż pracy: "+getStazPracy()+" Pensja:"+getPensja());
    }


    public int getLiczbaPublikacji() {
        return liczbaPublikacji;
    }
    public void setLiczbaPublikacji(int liczbaPublikacji) {
        this.liczbaPublikacji = liczbaPublikacji;
    }
    public stanowiskoPracy getStanowisko() {
        return stanowisko;
    }
    public void setStanowisko(stanowiskoPracy stanowisko) {
        this.stanowisko = stanowisko;
    }
}
