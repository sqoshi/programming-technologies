import java.util.Scanner;

public class Panel {
    public static void main(final String... args) {
        System.out.println("Welcome in our shop, please input what you want to do");
        printMenu();
        int number = new Scanner(System.in).nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    System.out.println("Making new order");
                    new Order();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:

            }
            printMenu();
            number = new Scanner(System.in).nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Make New Order");
        System.out.println("2. Print Facture");
        System.out.println("3. Exit");
    }

}
