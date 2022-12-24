package Uczelnia;
import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Osoba implements Serializable {
    private int nrIndeksu;
    private int rokStudiow;
    private ArrayList<Kurs> kursy;
    private boolean uczestnikERASMUS;
    private boolean studentIStopnia;
    private boolean studentIIStopnia;
    private boolean studiaStacjonarne;
    private boolean studianiestacjonarne;

    public Student(String imie, String nazwisko, String PESEL, int wiek, String plec, int nrIndeksu, int rokStudiow, ArrayList<Kurs> kursy, boolean uczestnikERASMUS, boolean studentIStopnia, boolean studentIIStopnia, boolean studiaStacjonarne, boolean studianiestacjonarne) {
        super(imie, nazwisko, PESEL, wiek, plec);
        this.nrIndeksu = nrIndeksu;
        this.rokStudiow = rokStudiow;
        this.kursy = kursy;
        this.uczestnikERASMUS = uczestnikERASMUS;
        this.studentIStopnia = studentIStopnia;
        this.studentIIStopnia = studentIIStopnia;
        this.studiaStacjonarne = studiaStacjonarne;
        this.studianiestacjonarne = studianiestacjonarne;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow) {
        this.rokStudiow = rokStudiow;
    }

    public ArrayList<Kurs> getKursy() {
        return kursy;
    }

    public void setKursy(ArrayList<Kurs> kursy) {
        this.kursy = kursy;
    }

    public boolean isUczestnikERASMUS() {
        return uczestnikERASMUS;
    }

    public void setUczestnikERASMUS(boolean uczestnikERASMUS) {
        this.uczestnikERASMUS = uczestnikERASMUS;
    }

    public boolean isStudentIStopnia() {
        return studentIStopnia;
    }

    public void setStudentIStopnia(boolean studentIStopnia) {
        this.studentIStopnia = studentIStopnia;
    }

    public boolean isStudentIIStopnia() {
        return studentIIStopnia;
    }

    public void setStudentIIStopnia(boolean studentIIStopnia) {
        this.studentIIStopnia = studentIIStopnia;
    }

    public boolean isStudiaStacjonarne() {
        return studiaStacjonarne;
    }

    public void setStudiaStacjonarne(boolean studiaStacjonarne) {
        this.studiaStacjonarne = studiaStacjonarne;
    }

    public boolean isStudianiestacjonarne() {
        return studianiestacjonarne;
    }

    public void setStudianiestacjonarne(boolean studianiestacjonarne) {
        this.studianiestacjonarne = studianiestacjonarne;
    }

    public void wypiszDane(){
        System.out.print(imie+" "+nazwisko+" nrIndeksu: "+nrIndeksu+" Rok studiów:"+rokStudiow+" ");
        ArrayList<Kurs> kursy = getKursy();
        for (Kurs kurs : kursy) {
            System.out.print(kurs.getNazwaKursu()+" ");
        }
        System.out.println();
    }
}
