package studies.programmingtechnologies.order;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Random;
import java.util.Scanner;

import studies.programmingtechnologies.database.Security;

/**
 * class represent item in order in client orders.
 */
public class Item { //NOPMD
  /**
   * productname.
   */
  private String productName;

  /**
   * quantity of product.
   */
  private int productQuantity;
  /**
   * prodcust stuck value.
   */
  private int productStuckValue;
  /**
   * product cost per item stuck value * qunatity.
   */
  private int productWholeValue;

  public int getProductWholeValue() {
    return productWholeValue;
  }

  public void setProductWholeValue(final int productWholeValue) {
    this.productWholeValue = productWholeValue;
  }

  protected String getProductName() {
    return productName;
  }

  public void setProductName(final String productName) {
    this.productName = productName;
  }

  private int getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(final int productQuantity) {
    this.productQuantity = productQuantity;
  }

  protected int getProductStuckValue() {
    return productStuckValue;
  }

  public void setProductStuckValue(final int productStuckValue) {
    this.productStuckValue = productStuckValue;
  }

  /**
   * loss random stuck value.
   *
   * @return return random value 0-100
   */
  protected int lossStuckValue() {
    final Random random = new Random();
    return random.nextInt(100);
  }

  @Override
  public String toString() {
    return "\nProdcutName: " + getProductName() + ", "
            + "ProductQuantity: " + getProductQuantity() + ", "
            + "ProductStuckValue: " + getProductStuckValue() + ", "
            + "ProductWholeValue: " + getProductWholeValue();

  }

  /**
   * makes and item to order.
   *
   * @return ordered item.
   */
  public static Item specifyItem() {
    final Item item = new Item();
    out.print("Name:");
    item.setProductName(new Scanner(in).next());
    out.print("Qunatity:");
    item.setProductQuantity(Security.isStringInt(new Scanner(in).next()));
    item.setProductStuckValue(item.lossStuckValue());
    out.print("Product "
            + item.getProductName() + " Value per Stuck: " + item.getProductStuckValue() + "\n");
    item.setProductWholeValue(item.getProductStuckValue() * item.getProductQuantity());
    out.println("Product "
            + item.getProductName() + " Whole Value: " + item.getProductWholeValue() + " \n");

    return item;
  }
}
