import java.util.regex.Pattern;

public class InputValidator {

    // determines whether expression uses roman numerals only
    //
    public static boolean isRoman(String[] s) {
        String token1 = s[0];
        String token2 = s[2];
        Pattern pattern =
        Pattern.compile("^(?i:(?=[MDCLXVI])((M{0,3})((C[DM])|(D?C{0,3}))?((X[LC])|(L?XX{0,2})|L)?((I[VX])|(V?(II{0,2}))|V)?))$");
        if (pattern.matcher(token1).matches() && pattern.matcher(token2).matches()) {
            System.out.println("");
            return true;
        }
        return false;
    }

    // determines whether expression uses arabic numerals only
    public static boolean isArabic(String[] s) {
        String token1 = s[0];
        String token2 = s[2];
        Pattern pattern = Pattern.compile("^[\\u0621-\\u064A0-9 ]+$");
        if (pattern.matcher(token1).matches() && pattern.matcher(token2).matches()) {
            System.out.println("");
            return true;
        }
        return false;
    }
}
