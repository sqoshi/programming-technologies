package studies.programmingtechnologies;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

import studies.programmingtechnologies.database.Database;
import studies.programmingtechnologies.database.Security;
import studies.programmingtechnologies.math.Mathe;
import studies.programmingtechnologies.order.Item;
import studies.programmingtechnologies.order.Order;
import studies.programmingtechnologies.user.Client;

/**
 * App panel containt login registration, making order.
 * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System.
 */
public class Panel { //NOPMD
  /**
   * creating new client database and checkingClient .
   *
   * @param args not needed
   */
  public static void main(final String... args) {
    final Database database = new Database();
    startProgram(database);
  }

  private static void printMenu() {
    out.println("---------------------------------------------------------");
    out.println("1. Make Order");
    out.println("2. Print Facture Information");
    out.println("3. Log Out");
  }

  private static void printLogSystem() {
    out.println("Are you a new user?");
    out.println("1. Yes");
    out.println("2. No");
    out.println("3. Exit");
  }

  private static void startProgram(final Database database) {
    printLogSystem(); //NOPMD
    Client client = new Client(); //NOPMD
    int number = new Scanner(in).nextInt();
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
      out.println(client.getPesel());
      printLogSystem();
      number = new Scanner(in).nextInt(); //NOPMD

    }
  }

  private static Client login(Database database) { //NOPMD
    Client client = new Client(); //NOPMD
    Scanner scanner = new Scanner(in); //NOPMD
    out.print("Input pesel: ");
    String pesel = scanner.next(); //NOPMD
    pesel = Security.checkPesel(pesel); //NOPMD
    for (int i = 0; i < database.getClientArrayList().size(); ++i) { //NOPMD
      if (pesel.equals(database.getClientPesel(i))) { //NOPMD
        client = database.getClient(i);
        out.println("Correct pesel, Yo are logged");
        return client; //NOPMD
      } else if (!client.getPesel().equals(database.getClient(i).getPesel())) { //NOPMD
        out.println("theres no pesel like this in database clients, yo uare moved to registration");
        register(database);
      }
    }
    return client;
  }

  private static Client register(final Database database) {
    final Client client = new Client();
    out.print("FirstName: ");
    client.setFirstName(new Scanner(in).next());
    out.print("LastName: ");
    client.setLastName(new Scanner(in).next());
    out.print("pesel: ");
    client.setPesel(
            Security.checkPeselAvailability(
                    Security.checkPesel(new Scanner(in).next()), database));
    database.getClientArrayList().add(client); //NOPMD
    return client;
  }

  private static void orderMenu(final Client client) {
    printMenu();
    int number = new Scanner(in).nextInt();
    while (number != 0) {
      switch (number) {
        case 1:
          out.println("New order");
          out.println("How many items you want to add: ");
          int x = Security.isStringInt(new Scanner(in).next()); //NOPMD
          final Order order = new Order(new ArrayList<Item>()); //NOPMD
          client.orderArrayList.add(order);//NOPMD
          while (x > 0) {
            x--;
            client.getOrderArrayList().get(//NOPMD it's ok
                    client.getOrderArrayList().size() - 1) //NOPMD
                    .getItemArrayList().add(Item.specifyItem());
          }
          break;
        case 2:
          out.println("Print facture Information");
          if (client.getOrderArrayList().size() == 0) { //NOPMD
            out.println("No orders");
            break;
          }
          out.print("Select facture: ");
          int m = 0;//NOPMD
          while (m < client.getOrderArrayList().size()) { //NOPMD
            out.print(m + " ");
            m++;
          }
          int index = new Scanner(in).nextInt(); //NOPMD
          if (index >= client.getOrderArrayList().size()) { //NOPMD
            out.println("There no facture like that ");
            break;
          }
          out.println(client.toString(index));
          Mathe.computeAllOrdersCost(client, index);
          break;
        case 3:
          return;
        default:
          break;

      }
      printMenu();
      number = new Scanner(in).nextInt(); //NOPMD
    }
  }
}
