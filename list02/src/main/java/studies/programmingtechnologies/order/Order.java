package studies.programmingtechnologies.order;

import java.util.ArrayList;

/**
 * order contain items ordered.
 */
public class Order { //NOPMD
  /**
   * color green.
   */
  private static final String ANSI_GREEN = "\u001B[32m";
  /**
   * color reset.
   */
  private static final String ANSI_RESET = "\u001B[0m";
  /**
   * arraylist or items in order.
   */
  private ArrayList<Item> itemArrayList;//NOPMD

  /**
   * init item arraylist per order.
   *
   * @param itemArrayList contain items of order.
   */
  public Order(ArrayList<Item> itemArrayList) { //NOPMD
    this.itemArrayList = itemArrayList;

  }

  public ArrayList<Item> getItemArrayList() { //NOPMD
    return itemArrayList;
  }

  @Override
  public String toString() {
    return ANSI_GREEN + itemArrayList.toString() + ANSI_RESET;
  }

}
