/**
 * Package contain simple bank simulator.
 */
package main.java.packagebank;

import javax.swing.text.Utilities;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

/**
 * abstract Panel that shows after logging.
 */
public class Panel   extends Utilities {
    /**
     * Main method that our panel is on.
     *
     * @param acc account
     */
    public static void panel(final Account acc) {
        out.println("Welcome " + acc.getFirstName() + " "
                + acc.getName()
                + ". What do you want to do with your account?");
        out.println("1. Check Saldo");
        out.println("2. Cash In");
        out.println("3. Cash Out");
        out.println("4. Log Out");
        final Scanner scanner = new Scanner(in); //NOPMD
        final Scanner scanner1 = new Scanner(in); //NOPMD
        int number = scanner.nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    out.println();
                    out.print("Saldo: " + acc.getMoney());
                    out.println();
                    break;
                case 2:
                    out.println();
                    out.print("Value:");
                    final int value = scanner1.nextInt();
                    acc.cashIn(value);
                    out.println();
                    break;
                case 3:
                    out.println();
                    out.print("Value:");
                    final int val = scanner1.nextInt();
                    if (val > acc.getMoney()) {
                        out.println("You can not cash out more money "
                                + "then you have on account."
                                + " Your Saldo: " + acc.getMoney());
                        break;
                    } else if (val <= acc.getMoney()) {
                        acc.cashOut(val);
                    }
                    out.println();
                    break;
                case 4:
                    return;
                default:
            }

            out.println();
            out.println("1. Check Saldo");
            out.println("2. Cash In");
            out.println("3. Cash Out");
            out.println("4. Log Out");
            number = scanner.nextInt();
            out.println();
        }
        scanner.close();
        scanner1.close();
    }
}
