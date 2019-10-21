package main.java.packagebank;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Abstrct cash automat.
 */
public class Bank extends Utilities { //NOPMD
    /**
     * Main method that contains loop that program exist on.
     *
     * @param args this is nothing
     */
    public static void main(final String... args) { //NOPMD
        ArrayList<Account> accountArrayList;
        accountArrayList = new ArrayList<>(); //NOPMD
        out.println("Welcome in our bank!");
        out.println("If you are already our client type 1,"
                + " to register type 2, to exit 0");
        final Scanner scanner = new Scanner(in); //NOPMD
        int number = scanner.nextInt();


        while (number != 0) {
            switch (number) {
                case 1:
                    out.println("Put card inside and type ur PIN");
                    final int pin = scanner.nextInt(); //NOPMD
                    for (final Account acc : accountArrayList
                    ) {
                        if (acc.getPin() != pin) {
                            out.println("Bad PIN");
                        }
                        if (acc.getPin() == pin) {

                            Panel.panel(acc);
                        }

                    }

                    break;
                case 2:
                    accountArrayList.add(registration());
                    break;
                case '3':
                    for (final Account acc
                            : accountArrayList) {
                        out.println("[PESEL: " + acc.getPesel() + "   PIN: "
                                + acc.getPin() + "   Saldo: "
                                + acc.getMoney() + "]");
                    }
                    break;
                default:
            }
            out.println();
            out.println("If you are already our client type 1,"
                    + " to register type 2, to exit 0");
            number = scanner.nextInt();
        }
        scanner.close();
    }

    private static /* package */Account registration() {
        int peselLength = 11; //NOPMD
        String thePesel;
        final Scanner scanner = new Scanner(in); //NOPMD
        out.println("\tWelcome in registry panel");
        Account acc = new Account(); //NOPMD

        out.print("FirstName: ");
        acc.setFirstName(scanner.next());
        out.print("Name: ");
        acc.setName(scanner.next());
        out.print("PESEL: ");
        thePesel = scanner.next();
        while (thePesel.length() != peselLength) { //NOPMD
            out.println("PESEL need to have 11 signs: try again");
            thePesel = scanner.next();
        }
        acc.setPesel(thePesel);
        acc.setPin(generatePIN());
        out.println("There is PIN to log into you new account: "
                + acc.getPin() + ". Do not forget it!");
        return acc;
    }


    private static /* package */int generatePIN() {
        int bound = 10000; //NOPMD
        final Random rand = new Random();
        return rand.nextInt(bound); //NOPMD
    }


}
