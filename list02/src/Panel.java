import java.util.ArrayList;
import java.util.Scanner;

public class Panel {
    public static void main(final String... args) {
        Database database = new Database();
        checkClient(database);
    }


    private static void orderMenu(Client client) {
        printMenu();
        int number = new Scanner(System.in).nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    System.out.println("New order");
                    System.out.println("How many items you want to add: ");
                    int x = new Scanner(System.in).nextInt();
                    while (x > 0) {
                        client.orderArrayList.add(new Order(new ArrayList<>()));
                        x--;
                        client.getOrderArrayList().get(client.getOrderArrayList().size() - 1).getItemArrayList().add(Item.specifyItem());
                    }
                    break;
                case 2:
                    System.out.println("Print facture");
                    System.out.println(client.toString());
                    int p = 0;
                    for (int k = 0; k < client.getOrderArrayList().size(); ++k) {
                        p += Mathematic.computeOrderCost(client.getOrderArrayList().get(k).getItemArrayList());
                    }
                    System.out.println(p);
                    break;
                case 3:
                    return;
                default:
                    break;

            }
            printMenu();
            number = new Scanner(System.in).nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Make Order");
        System.out.println("2. Print Facture");
        System.out.println("3. Log Out");
    }

    private static void printLogSystem() {
        System.out.println("Are you a new user?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Exit");
    }

    private static void checkClient(Database database) {
        printLogSystem();
        Client client = new Client();
        int number = new Scanner(System.in).nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    client = register(database);
                    orderMenu(client);
                    break;
                case 2:
                    client = login(database);
                    orderMenu(client);
                    break;
                case 3:
                    return;
                default:
            }
            System.out.println(client.getPesel());
            printLogSystem();
            number = new Scanner(System.in).nextInt();

        }
    }

    private static Client login(Database database) {
        Client client = new Client();
        System.out.print("Input pesel: ");
        String pesel = new Scanner(System.in).next();
        int i = 0;
        while ((i < database.getClientArrayList().size())) {
            if (pesel.equals(database.getClientPesel(i))) {
                client = database.getClient(i);
                System.out.println("Correct pesel, Yo are logged");
            } else if (!client.equals(database.getClient(i))) {
                System.out.println("theres no pesel like this in database clients");
                break;
            }
            i++;
        }
        return client;


    }

    private static Client register(Database database) {
        Client client = new Client();
        System.out.print("FirstName: ");
        client.setFirstName(new Scanner(System.in).next());
        System.out.print("LastName: ");
        client.setLastName(new Scanner(System.in).next());
        System.out.print("pesel: ");
        client.setPesel(new Scanner(System.in).next());
        database.getClientArrayList().add(client);
        return client;
    }
}
