package studies.programmingtechnologies.math;

import static java.lang.System.out;

import java.util.ArrayList;

import studies.programmingtechnologies.order.Item;
import studies.programmingtechnologies.user.Client;

/**
 * additive clans containg math operations.
 */
public class Mathe { //NOPMD
  /**
   * color red.
   */
  private static final String ANSI_RED = "\u001b[31m";
  /**
   * color magenta.
   */
  private static final String ANSI_MAGENTA = "\u001b[35m";
  /**
   * color reset.
   */
  private static final String ANSI_RESET = "\u001b[0m";

  /**
   * computes order cost.
   *
   * @param arrayList fiven order
   * @return cost of order
   */
  public static int computeOrderCost(ArrayList<Item> arrayList) { //NOPMD
    int sum = 0; //NOPMD
    for (final Item item : arrayList) {
      sum = item.getProductWholeValue(); //NOPMD
    }
    return sum;
  }

  /**
   * computes cost of all orders on list.
   *
   * @param client person with orders in dtabase
   * @return sum of all orders
   */
  public static int computeAllOrdersCost(final Client client) {
    int part = 0;
    for (int k = 0; k < client.getOrderArrayList().size(); ++k) { //NOPMD
      part += Mathe.computeOrderCost(client.getOrderArrayList().get(k).getItemArrayList()); //NOPMD
      out.print(" Cost After Next Product " + k + ": " + ANSI_MAGENTA + part + ANSI_RESET);
    }
    out.println("\n\t\tTotal Cost: " + ANSI_RED + part + ANSI_RESET);
    return part;
  }
}
