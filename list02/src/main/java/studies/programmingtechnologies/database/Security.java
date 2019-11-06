/*
 * package containing datbase and databaase security checks.
 */

package studies.programmingtechnologies.database;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/**
 * Security Check for database.
 */
public class Security { //NOPMD
  /**
   * Polish pesel length.
   */
  private static final int lengthOfPesel = 11;//NOPMD

  /**
   * Checks if given string is an int.
   *
   * @param string given string
   * @return parsed integer
   * @throws NumberFormatException cause can be not an int.
   */

  public static int isStringInt(final String string) { //NOPMD
    try {
      final int moist = Integer.parseInt(string);
      return moist; //NOPMD
    } catch (NumberFormatException ex) {
      out.print("It's not a number, try again: ");
      return isStringInt(new Scanner(in).next());
    }
  }

  /**
   * check if pesel is correct lenth()
   * @param str pesel
   * @return correct pesel
   */
  public static String peselLengthCheck(final String str) {
    String s = str; //NOPMD
    Scanner scanner = new Scanner(in); //NOPMD
    while (s.length() != lengthOfPesel) { //NOPMD
      out.print("PESEL need to have 11 numbers, try again: ");
      s = scanner.next();
    }

    return s;
  }

  /**
   * check if pesel is out of letter -cahrs.
   * @param str pesel
   * @return pesel but checking the lenth for sure
   */
   public static String peselOutOfLetters(final String str) {
    String s = str;//NOPMD
    Scanner scanner = new Scanner(in); //NOPMD
    for (int i = 0; i < s.length(); ++i) {
      if (!Character.isDigit(s.charAt(i))) {
        out.print("Pesel contain letter, try again: ");
        s = scanner.next();
        i = 0; //NOPMD
      }
    }
    return peselLengthCheck(s);
  }

  /**
   * Check pesel avaibility.
   *
   * @param str      fiven psel
   * @param database arraylist of clients
   * @return good pesel
   */
  public static String checkPeselAvailability(final String str, final Database database) {
    Scanner scanner = new Scanner(in); //NOPMD
    for (int i = 0; i < database.getDatabaseSize(); ++i) {
      if (database.getClient(i).getPesel().equals(str)) { //NOPMD
        out.print("Account with this pesel exist in our database, try again: ");
      }
      return checkPesel(scanner.next()); //NOPMD
    }
    return str;
  }

  /**
   * full pesel check.
   *
   * @param str pesel
   * @return right psl
   */
  public static String checkPesel(final String str) {
    String s = str; //NOPMD
    s = peselLengthCheck(s);
    s = peselOutOfLetters(s);
    return s;
  }
}
