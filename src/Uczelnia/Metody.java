package Uczelnia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Metody {
    //Wypisywanie wszystkich danych
    public static void wypiszPracownikow(List<Osoba> osoby){
        for (Osoba osoba : osoby) {
            if (osoba instanceof PracownikUczelni) {
                jakiPracownik(osoba);
            }
        }
    }
    public static void wypiszStudentow(List<Osoba> osoby){
        for (Osoba osoba : osoby) {
            if (osoba instanceof Student){
                ((Student) osoba).wypiszDane();
            }
        }
    }
    public static void wypiszKursy(List<Kurs> kursy){
        for (Kurs kurs : kursy) {
            if (kurs instanceof Kurs){
                kurs.wypiszDane();
            }
        }
    }

    //Wyszukiwanie danych
    public static int wyszukajStudenta(int kategoria, String zapytanie, ArrayList<Osoba> osoby){
//      1.Imię 2.Nazwisko 3.NrIndeksu 4.Rok studiow 5.Nazwa kursu
        for (Osoba osoba : osoby) {
            if (osoba instanceof Student){
                switch (kategoria){
                    case 1://Imię
                        if (zapytanie.equals(osoba.getImie())){
                            return osoby.indexOf(osoba);
                        }
                        break;
                    case 2://Nazwisko
                        if (zapytanie.equals(osoba.getNazwisko())){
                            return osoby.indexOf(osoba);
                        }
                        break;
                    case 3://NrIndeksu
                        if (InputO.isInt(zapytanie)) {
                            if (((Student) osoba).getNrIndeksu() == Integer.parseInt(zapytanie)){
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    case 4://Rok studiow
                        if (InputO.isInt(zapytanie)) {
                            if (((Student) osoba).getRokStudiow() == Integer.parseInt(zapytanie)) {
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    case 5://Kursy
                        for (Kurs kurs : ((Student) osoba).getKursy()) {
                            if (kurs.getNazwaKursu().equals(zapytanie)){
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + kategoria);
                }
            }
        }
        return -1;
    }
    public static int wyszukajPracownika(int kategoria, String zapytanie, ArrayList<Osoba> osoby){
//      1.Imię 2.Nazwisko 3.Stanowisko 4.Staż pracy 5.Liczba nadgodzin 6.Pensja
        for (Osoba osoba : osoby) {
            if (osoba instanceof PracownikUczelni){
                switch (kategoria){
                    case 1://Imię
                        if (zapytanie.equals(osoba.getImie())){
//                            jakiPracownik(osoba);
                            return osoby.indexOf(osoba);
                        }
                        break;
                    case 2://Nazwisko
                        if (zapytanie.equals(osoba.getNazwisko())){
//                            jakiPracownik(osoba);
                            return osoby.indexOf(osoba);
                        }
                        break;
                    case 3://Stanowisko
                        if (osoba instanceof PracownikBadawczoDydaktyczny){
                            if (zapytanie.equalsIgnoreCase(((PracownikBadawczoDydaktyczny) osoba).getStanowisko().toString())){
//                                ((PracownikBadawczoDydaktyczny) osoba).wypiszDane();
                                return osoby.indexOf(osoba);
                            }
                        }
                        if (osoba instanceof PracownikAdministracyjny){
                            if (zapytanie.equalsIgnoreCase(((PracownikAdministracyjny) osoba).getStanowisko().toString())){
//                                ((PracownikAdministracyjny) osoba).wypiszDane();
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    case 4://Staż pracy
                        if (InputO.isInt(zapytanie)) {
                            if (((PracownikUczelni) osoba).getStazPracy() == Integer.parseInt(zapytanie)){
//                                jakiPracownik(osoba);
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    case 5://Liczba nadgodzin
                        if (InputO.isInt(zapytanie)) {
                            if (((PracownikUczelni) osoba).getLiczbaNadgodzin() == Integer.parseInt(zapytanie)){
//                                jakiPracownik(osoba);
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                    case 6://Pensja
                        if (InputO.isInt(zapytanie)) {
                            if (((PracownikUczelni) osoba).getPensja() == Integer.parseInt(zapytanie)){
//                                jakiPracownik(osoba);
                                return osoby.indexOf(osoba);
                            }
                        }
                        break;
                }
            }
        }
        return -1;
    }
    public static int wyszukajKurs(int kategoria, String zapytanie, ArrayList<Kurs> kursy){
//      1.Nazwa kursu 2.Prowadzący 3.Punkty ECTS
        for (Kurs kurs : kursy) {
            switch (kategoria){
                case 1://Nazwa kursu
                    if (zapytanie.equals(kurs.getNazwaKursu())){
                        return kursy.indexOf(kurs);
                    }
                    break;
                case 2://Prowadzący
                    if (zapytanie.equals(kurs.getProwadzacy())){
                        return kursy.indexOf(kurs);
                    }
                    break;
                case 3://Punkty ECTS
                    if (InputO.isInt(zapytanie)) {
                        if (kurs.getPunktyECTS() == Integer.parseInt(zapytanie)) {
                            return kursy.indexOf(kurs);
                        }
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + kategoria);
            }
        }
        return -1;
    }

    //Usuwanie danych
    private static void usunPracownika(ArrayList<Osoba> osoby)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Po czym chcesz wyszukiwać :\n1.Imie\n2.Nazwisko\n3.Stanowisko\n4.Staż pracy");
        String kategoria = scan.nextLine();
        System.out.println("Wpisz słowo klucz:");
        String klucz = scan.nextLine();
        removeElement(osoby,kategoria,klucz,1);
    }
    private static void usunDane(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jakie dane chcesz usunąć:\n1.Pracownika\n2.Studenta\n3.Kursu");
        String inputUzytkownika = scan.nextLine();
        if (InputO.isInt(inputUzytkownika)){
            switch (Integer.parseInt(inputUzytkownika)){
                case 1:
                    usunPracownika(osoby);
                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }else {
            System.out.println("Błędne dane.");
        }
    }

    //Dodawanie danych
    public static void dodajDane(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wybierz dodawany element:\n1.Pracownik\n2.Student\n3.Kurs");
        String inputUzytkownika = scan.nextLine();

        switch (Integer.parseInt(inputUzytkownika)){
            case 1://Pracownik
                dodajPracownika(osoby,kursy);
                break;
            case 2://Student
                dodajStudenta(osoby,kursy);
                break;
            case 3://Kurs
                dodajKurs(kursy);
                break;
            default://Error
                System.out.println("Błędne dane.");
        }
    }
    public static void dodajPracownika(ArrayList<Osoba> osoby, ArrayList<Kurs> kursy){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dodawanie pracownika:\n1.Pracownik badawczko dydaktyczny\n2.Pracownik uczelni");
        String inputUzytkownika = scan.nextLine();
        String input;
        switch (Integer.parseInt(inputUzytkownika)){
            case 1://Pracownik badawczko dydaktyczny
                System.out.println("Wprowadź dane pracownika oddzielając je spacją:");
                System.out.println("imie nazwisko PESEL wiek plec staż_pracy pensje liczbe_publikacji stanowisko[Asystent Adiunktt ProfesorNadzwyczajny ProfesorZwyczajny Wykładowca]  liczbaNadgodzin");
                input = scan.nextLine();
                dodajPracownikDydaktyczny(input,osoby);
                break;
            case 2://Pracownik administracyjny
                System.out.println("Wprowadź dane pracownika oddzielając je spacją:");
                System.out.println("imie nazwisko PESEL wiek plec staż_pracy pensje liczbaNadgodzin stanowisko[Referent Specjalista StarszySpecjalista]");
                input = scan.nextLine();
                dodajPracownikAdministracyjny(input,osoby);
                break;
        }
    }
    public static void dodajStudenta(ArrayList<Osoba> osoby, ArrayList<Kurs> kursy){
        //TODO napraw dodawanie studenta
        ArrayList<Kurs> kursyStudenta = new ArrayList<Kurs>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź dane pracownika oddzielając je spacją:");
        System.out.println("imie nazwisko PESEL wiek plec nrIndeksu rokStudiow");

        String inputUzytkownika = scan.nextLine();
//      0.imie 1.nazwisko 2.PESEL 3.wiek 4.plec 5.nrIndeksu 6.rokStudiow 7.kursy
        String[] dane = inputUzytkownika.split(" ");
//      0.uczestnikERASMUS 1.studentIStopnia 2.studentIIStopnia 3.studiaStacjonarne 4.studianiestacjonarne
        boolean[] daneBool = new boolean[5];

        boolean dobreDane = true;
        while(dobreDane){
            System.out.println("Czy uczestniczył w programie ERASMUS(wpisz TAK lub NIE):");
            inputUzytkownika = scan.nextLine();
            if (inputUzytkownika.equals("TAK")) {
                daneBool[0] = true;
                dobreDane = false;
            } else if (inputUzytkownika.equals("NIE")) {
                daneBool[0] = false;
                dobreDane = false;
            } else System.out.println("Błędne dane");
        }

        System.out.println("Jakie studia:\n1.Studia pierwszego stopnia\n2.Studia drugiego stopnia");
        inputUzytkownika = scan.nextLine();
        if (InputO.isInt(inputUzytkownika)){
//          1.studentIStopnia 2.studentIIStopnia
            switch (Integer.parseInt(inputUzytkownika)){
                case 1:
                    daneBool[1] = true;
                    daneBool[2] = false;
                    break;
                case 2:
                    daneBool[1] = false;
                    daneBool[2] = true;
                    break;
                default:
                    System.out.println("Błędne dane");
            }
        }

        System.out.println("Jakie studia:\n1.Studia stacjonarne\n2.Studia niestacjonarne");
        inputUzytkownika = scan.nextLine();
        if (InputO.isInt(inputUzytkownika)){
//          1.Studia stacjonarne 2.Studia niestacjonarne
            switch (Integer.parseInt(inputUzytkownika)){
                case 1:
                    daneBool[3] = true;
                    daneBool[4] = false;
                    break;
                case 2:
                    daneBool[3] = false;
                    daneBool[4] = true;
                    break;
                default:
                    System.out.println("Błędne dane");
            }
        }

        System.out.println("Jakie kursy wpisz z podanych(oddzielając spacjami)):");
        for (Kurs kurs : kursy) {
            System.out.print(kurs.getNazwaKursu()+" ");
        }
        System.out.println();
        inputUzytkownika = scan.nextLine();
        String[] inputKursy = inputUzytkownika.split(" ");
        for (String s : inputKursy) {
            for (Kurs kurs : kursy) {
                if (s.equals(kurs.getNazwaKursu())){
                    System.out.println("Dodano kurs:"+s);
                    kursyStudenta.add(kurs);
                }
            }
        }

        if (dane.length != 7) {
            System.out.println("Nieprawidłowa ilość wpisanych danych");
        } else{
            if (true) {
//              0.imie 1.nazwisko 2.PESEL 3.wiek 4.plec 5.nrIndeksu 6.rokStudiow 7.kursy 8.uczestnikERASMUS 9.studentIStopnia 10.studentIIStopnia 11.studiaStacjonarne 12.studianiestacjonarne
                Student s = new Student(dane[0], dane[1], dane[2], Integer.parseInt(dane[3]), dane[4], Integer.parseInt(dane[5]), Integer.parseInt(dane[6]), kursyStudenta, daneBool[0], daneBool[1], daneBool[2], daneBool[3], daneBool[4]);
                osoby.add(s);
            } else System.out.println("Błędne dane");
        }
    }
    public static void dodajKurs(ArrayList<Kurs> kursy){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź dane pracownika oddzielając je spacją:");
        System.out.println("nazwa_kursu prowadzący punkty_ECTS");
        String inputUzytkownika = scan.nextLine();
        String[] dane = inputUzytkownika.split(" ");
        if (dane.length != 3) {
            System.out.println("Nieprawidłowa ilość wpisanych danych");
        } else{
            if (InputO.isInt(dane[2])) {
//              0.nazwa_kursu 1.prowadzący 2.punkty_ECTS
                Kurs k = new Kurs(dane[0], dane[1], Integer.parseInt(dane[2]));
                kursy.add(k);
            } else System.out.println("Błędne dane");
        }
    }
    public static void dodajPracownikDydaktyczny(String value,ArrayList<Osoba> osoby){
        String[] dane = value.split(" ");
        if (dane.length != 10) {
            System.out.println("Nieprawidłowa ilość wpisanych danych");
        } else{
            if (InputO.checkStanowisko(dane[8], stanowiskaDydaktyczne) && InputO.checkPESEL(dane[2])) {
//                0.imie 1.nazwisko 2.PESEL 3.wiek 4.plec 5.staż_pracy 6.pensje 7.liczbe_publikacji 8.stanowisko[Asystent Adiunktt ProfesorNadzwyczajny ProfesorZwyczajny Wykładowca]  9.liczbaNadgodzin
                PracownikBadawczoDydaktyczny p = new PracownikBadawczoDydaktyczny(dane[0], dane[1], dane[2], Integer.parseInt(dane[3]), dane[4], Integer.parseInt(dane[5]), Integer.parseInt(dane[6]), Integer.parseInt(dane[7]), PracownikBadawczoDydaktyczny.stanowiskoPracy.valueOf(dane[8]), Integer.parseInt(dane[9]));
                osoby.add(p);
            } else System.out.println("Błędne dane");
        }
    }
    public static void dodajPracownikAdministracyjny(String value,ArrayList<Osoba> osoby){
        String[] dane = value.split(" ");
        if (dane.length != 9) {
            System.out.println("Nieprawidłowa ilość wpisanych danych");
        } else{
            if (InputO.checkStanowisko(dane[8], stanowiskaAdministracyjne) && InputO.checkPESEL(dane[2])) {
//                0.imie 1.nazwisko 2.PESEL 3.wiek 4.plec 5.staż_pracy 6.pensje 7.liczbaNadgodzin 8.stanowisko[Referent Specjalista StarszySpecjalista]
                PracownikAdministracyjny p = new PracownikAdministracyjny(dane[0], dane[1], dane[2], Integer.parseInt(dane[3]), dane[4], Integer.parseInt(dane[5]), Integer.parseInt(dane[6]), Integer.parseInt(dane[7]), PracownikAdministracyjny.stanowiskoPracy.valueOf(dane[8]));
                osoby.add(p);
            } else if (InputO.checkStanowisko(dane[8], stanowiskaAdministracyjne) == false) {
                System.out.println("Błędne dane(stanowisko)");
            } else if (InputO.checkPESEL(dane[2]) == false) {
                System.out.println("Błędne dane(długość peselu)");
            }
        }
    }

    //Komunikacja z urzytkownikiem
    //TODO zabezpieczenie wpisywanych danych
    public static void sesjaUrzytkownika(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby){
        Scanner scan = new Scanner(System.in);
        boolean sesja = true;

        System.out.println("Baza danych uczelni.");

        while (sesja){
            System.out.println("Wpisz:\n1.Aby odczytać dane.\n2.Aby wpisać dane.\n3.Aby usunąć dane\n4.Aby zakończyć program");
            String inputUzytkownika = scan.nextLine();

            switch (Integer.parseInt(inputUzytkownika)){
                case 1://Output
                    wyszukajDane(kursy, osoby);
                    break;
                case 2://Input
                    dodajDane(kursy, osoby);
                    break;
                case 3://Remove
                    usunDane(kursy, osoby);
                    break;
                case 4://Zakończ
                    System.out.println("Koniec seji");
                    sesja = false;
                    break;
                default://Error
                    System.out.println("Błędne dane.");
            }
        }
    }
    public static void wyszukajDane(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby){
        Scanner scan = new Scanner(System.in);
        String klucz;

        System.out.println("Jakie dane chcesz znaleźć: Wpisz:\n1.Pracownika.\n2.Studenta.\n3.Kursu");
        String inputUzytkownika = scan.nextLine();
        switch (Integer.parseInt(inputUzytkownika)){
            case 1://Pracownicy
                System.out.println("Wybierz kategorię:\n1.Imię\n2.Nazwisko\n3.Stanowisko\n4.Staż pracy\n5.Liczba nadgodzin\n6.Pensja");
                inputUzytkownika = scan.nextLine();
                System.out.println("Wpisz słowo klucz:");
                klucz = scan.nextLine();
                jakiPracownik(osoby.get(wyszukajPracownika(Integer.parseInt(inputUzytkownika),klucz,osoby)));
                break;
            case 2://Studenci
                //1.Imię 2.Nazwisko 3.NrIndeksu 4.Rok studiow 5.Nazwa kursu
                System.out.println("Wybierz kategorię:\n1.Imię\n2.Nazwisko\n3.NrIndeksu\n4.Rok studiow\n5.Nazwa kursu");
                inputUzytkownika = scan.nextLine();
                System.out.println("Wpisz słowo klucz:");
                klucz = scan.nextLine();
                Osoba osoba = osoby.get(wyszukajStudenta(Integer.parseInt(inputUzytkownika),klucz,osoby));
                ((Student) osoba).wypiszDane();
                break;
            case 3://Kursy
                //1.Nazwa kursu 2.Prowadzący 3.Punkty ECTS
                System.out.println("Wybierz kategorię:\n1.Nazwa kursu\n2.Prowadzący\n3.Punkty ECTS");
                inputUzytkownika = scan.nextLine();
                System.out.println("Wpisz słowo klucz:");
                klucz = scan.nextLine();
                Kurs kurs = kursy.get(wyszukajKurs(Integer.parseInt(inputUzytkownika),klucz,kursy));
                kurs.wypiszDane();
                break;
            default://Error
                System.out.println("Błędne dane.");
        }
    }

    //Serializacja i deserializacja danych
    public static void serializuj(ArrayList<Osoba> osoby,ArrayList<Kurs> kursy, String fileName){
        Scanner scan = new Scanner(System.in);
        System.out.println("Czy chcesz zapisać dane:\n1.Tak\n2.Nie");
        String inputUzytkownika = scan.nextLine();

        switch (Integer.parseInt(inputUzytkownika)){
            case 1:
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    for (Osoba o:osoby) outputStream.writeObject(o);
                    for (Kurs kurs:kursy)outputStream.writeObject(kurs);
                    outputStream.writeObject(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Koniec programu.");
                break;
            case 2:
                System.out.println("Koniec programu.");
                break;
        }
    }
    public static void deserializuj(ArrayList<Osoba> osoby,ArrayList<Kurs> kursy, String fileName) {
        ArrayList<Object> objList = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            boolean check = true;
            while (check){
                Object obj = input.readObject();
                if (obj != null) objList.add(obj);
                else check = false;
            }
        }catch (FileNotFoundException | StreamCorruptedException e){
            e.printStackTrace();
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Object obj:objList) {
            if (obj instanceof Osoba) osoby.add((Osoba)obj);
            else if (obj instanceof Kurs) kursy.add((Kurs)obj);
        }
    }
    //Inne
    public static void jakiPracownik(Osoba osoba){
        if (osoba instanceof PracownikBadawczoDydaktyczny){
            ((PracownikBadawczoDydaktyczny) osoba).wypiszDane();
        }
        if (osoba instanceof PracownikAdministracyjny){
            ((PracownikAdministracyjny) osoba).wypiszDane();
        }
    }
    public static void removeElement(ArrayList<Osoba> osoby,String kategoria,String klucz,int typ){
//        Usówa z arraylisty element po indexie.(typ: 1.Pracownik 2.Student)
        boolean check = true;
        switch (typ){
            case 1:
                while(check){
                    int index = wyszukajPracownika(Integer.parseInt(kategoria),klucz,osoby);
                    if (index != -1){
                        System.out.println(index);
                        osoby.remove(osoby.get(index));
                    }else {
                        check = false;
                    }
                }
                break;
            case 2:
                while(check){
                    int index = wyszukajStudenta(Integer.parseInt(kategoria),klucz,osoby);
                    if (index != -1){
                        System.out.println(index);
                        osoby.remove(osoby.get(index));
                    }else {
                        check = false;
                    }
                }
                break;
//            while(check){
//                int index = wyszukajKurs(Integer.parseInt(kategoria),klucz,kurs);
//                if (index != -1){
//                    System.out.println(index);
//                    osoby.remove(osoby.get(index));
//                }else {
//                    check = false;
//                }
//            }
        }
    }

    //Zmienne globalne
    public static String[] stanowiskaDydaktyczne = {"Asystent", "Adiunktt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykładowca"};
    public static String[] stanowiskaAdministracyjne = {"Referent", "Specjalista", "StarszySpecjalista"};
}