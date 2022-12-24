package Uczelnia;

public class InputO {
    public static boolean isInt(String value){
        try
        {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    //Sprawdzanie poprawności
    public static boolean checkStanowisko(String value,String[] stanowiska){
        value.toLowerCase();
        for (String s : stanowiska) {
            if (s.equals(value)) return true;
        }
        return false;
    }
    public static boolean checkPESEL(String value){
        if (value.length() == 11){
            if (isInt(value)) return true;
        }
        return false;
    }

    public static boolean checkNrIndeksu(String value){
        if (value.length() == 6){
            if (isInt(value)) return true;
        }
        return false;
    }

    //TODO sprawdzanie NrIndeksu
}
