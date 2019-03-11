import java.util.HashMap;

public class RomanNumeral {
    // array containing all of the arabic values
    public final int[] arabic = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    // array containing all of the roman letters
    public final String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };


    public String toRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < arabic.length; i++) {
            while (num >= arabic[i]) {
                roman.append(romans[i]);
                num = num - arabic[i];
            }
        }
        return roman.toString();
    }

    public int toArabic(String roman) {
        for (int i = 0; i < romans.length; i++) {
            if (roman.startsWith(romans[i])) {
                return arabic[i] + toArabic(roman.replaceFirst(romans[i], ""));
            }
        }
        return 0;
    }

  public static void main(String[] args) {
    RomanNumeral r = new RomanNumeral();

    System.out.println(r.toArabic(r.toRoman(223)));
    System.out.println(r.toRoman(223));
  }
}
