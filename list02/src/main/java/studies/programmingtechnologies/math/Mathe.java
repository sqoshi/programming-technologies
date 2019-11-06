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
      sum += item.getProductWholeValue(); //NOPMD
      out.print(" Cost After Next Product " + ": " + ANSI_MAGENTA + sum + ANSI_RESET);
    }
    return sum;
  }

  /**
   * computes cost of all orders on list.
   *
   * @param client person with orders in dtabase
   * @return sum of all orders
   */
  public static int computeAllOrdersCost(final Client client, final int index) {
    int part;
    part = computeOrderCost(client.getOrderArrayList().get(index).getItemArrayList()); //NOPMD
    out.println("\n\t\tTotal Cost: " + ANSI_RED + part + ANSI_RESET);
    return part;
  }
}
