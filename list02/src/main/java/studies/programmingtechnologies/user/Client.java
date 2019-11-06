package studies.programmingtechnologies.user;

import java.util.ArrayList;

import studies.programmingtechnologies.order.Order;

/**
 * Client object works on arraylist of orders.
 */
public class Client { //NOPMD
  /**
   * color yellow.
   */
  public static final String ANSI_YELLOW = "\u001B[33m";
  /**
   * color reset.
   */
  public static final String ANSI_RESET = "\u001B[0m";
  /**
   * contain universal number for every polsih ppl.
   */
  private String pesel;
  /**
   * contain first name od client.
   */
  private String firstName;
  /**
   * contain last name of client.
   */
  private String lastName;
  /**
   * list of orders for client.
   */
  public ArrayList<Order> orderArrayList = new ArrayList<>(); //NOPMD


  public ArrayList<Order> getOrderArrayList() { //NOPMD
    return orderArrayList;
  }

  /**
   * modified toString metod.
   * @param index order inex
   * @return informations about the client order
   */
  public String toString(final int index) {
    return ANSI_YELLOW + "Client{"
            + "pesel='" + getPesel() + '\''
            + ", firstName='" + getFirstName() + '\''
            + ", lastName='" + getLastName() + '\''
            + ", orderArrayList="
            + ANSI_RESET + orderArrayList.get(index).toString() //NOPMD
            + '}';
  }


  public String getPesel() {
    return pesel;
  }

  public void setPesel(final String pesel) {
    this.pesel = pesel;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
}
