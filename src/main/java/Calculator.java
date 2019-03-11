import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class Calculator {



  public static void main(String[] args) {


    System.out.println(
        "Hi there. The Calculator greets you. I \n"
            + "can compute addition, subtraction, multiplication \n"
            + "and division with two arabic digit or roman:\n"
            + "\"1 + 1\" or \"II + V\". You have to use \n"
            + "single space. Mixing of two types\n"
            + "in single expression isn't valid: \"1 + IV\" won't \n"
            + "be computed. Good luck, have fun.");
    System.out.println("Please enter an expression:");

    Scanner scanner = new Scanner(System.in);
    String[] tokens = scanner.nextLine().split(" ");

    int type = arabicOrRoman(tokens);
    RomanNumeral romanNumeral = new RomanNumeral();

    System.out.println(compute(type, tokens, romanNumeral));
  }


  @org.jetbrains.annotations.NotNull
  static String compute(int type, String[] tokens, RomanNumeral rn) {
    int result = 0;
    int operand1 = 0;
    int operand2 = 0;

    if (type == 0) {
      operand1 = rn.toArabic(tokens[0]);
      operand2 = rn.toArabic(tokens[2]);
    } else {
      operand1 = Integer.valueOf(tokens[0]);
      operand2 = Integer.valueOf(tokens[2]);
    }

    switch (tokens[1].charAt(0)) {
      case '+':
        result = operand1 + operand2;
        break;
      case '-':
        result = operand1 - operand2;
        break;
      case '*':
        result = operand1 * operand2;
        break;
      case '/':
        if (operand1 == 0 || operand2 == 0) {
          throw new IllegalArgumentException("Argument divisor is 0");
        }
        result = operand1 / operand2;
        break;
    }

    return String.valueOf(result);
  }

  /* Check which numerals used and return
   1 if Arabic
   0 if Roman
   and -1 if input is incorrect*/
  static int arabicOrRoman(String[] tokens) {
    if (InputValidator.isArabic(tokens)) {
      return 1;
    }
    if (InputValidator.isRoman(tokens)) {
      return 0;
    }

    return -1;
  }
}
