package Uczelnia;

import java.io.Serializable;

public class PracownikUczelni extends Osoba implements Serializable {
    private int stazPracy;
    private int pensja;
    private int liczbaNadgodzin;
//    private String stanowisko;

    public PracownikUczelni(String imie, String nazwisko, String PESEL, int wiek, String plec, int stazPracy, int pensja, int liczbaNadgodzin) {
        super(imie, nazwisko, PESEL, wiek, plec);
        this.stazPracy = stazPracy;
        this.pensja = pensja;
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }
}
