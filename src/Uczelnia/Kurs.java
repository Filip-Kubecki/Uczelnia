package Uczelnia;

import java.io.Serializable;

public class Kurs implements Serializable {
    private String nazwaKursu;
    private String prowadzacy;//Imie i nazwisko
    private int punktyECTS;

    public Kurs(String nazwaKursu, String prowadzacy, int punktyECTS) {
        this.nazwaKursu = nazwaKursu;
        this.prowadzacy = prowadzacy;
        this.punktyECTS = punktyECTS;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getPunktyECTS() {
        return punktyECTS;
    }

    public void setPunktyECTS(int punktyECTS) {
        this.punktyECTS = punktyECTS;
    }

    public void wypiszDane(){
        System.out.println(nazwaKursu+" Prowadzący: "+prowadzacy+" ECTS: "+punktyECTS);
    }
}
