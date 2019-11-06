/*
 * package containing datbase and databaase security checks.
 */

package studies.programmingtechnologies.database;

import java.util.ArrayList;

import studies.programmingtechnologies.user.Client;

/**
 * Pseudo- Database with all registered clients.
 */
public class Database {
  /**
   * arraylist that contais clients.
   */
  private ArrayList<Client> clientArrayList; //NOPMD

  /**
   * Initate database with client arraylist.
   */
  public Database() {
    clientArrayList = new ArrayList<>();
  }

  /**
   * metho.
   *
   * @return arrayliste containning all clients.
   */
  public ArrayList<Client> getClientArrayList() { //NOPMD
    return clientArrayList;
  }

  /**
   * gets i client's pesel from clientaraylist.
   *
   * @param index index of person
   * @return client
   */
  public String getClientPesel(final int index) {
    return clientArrayList.get(index).getPesel(); //NOPMD
  }

  /**
   * gets i client from clientaraylist.
   *
   * @param index index of person
   * @return client
   */
  public Client getClient(final int index) {
    return clientArrayList.get(index);
  }

  /**
   * return size of database.
   *
   * @return size
   */
  public int getDatabaseSize() {
    return clientArrayList.size();
  }
}
