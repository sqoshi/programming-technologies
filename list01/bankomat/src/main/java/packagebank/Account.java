/**
 * Package contain simple bank simulator.
 */
package main.java.packagebank;

/**
 * Class that contain information's about concrete account.
 */
class Account { //NOPMD
    /**
     * Int value that has unique PIN number to login to account.
     */
    private int pin;
    /**
     * Contains saldo of account.
     */
    private int money; //NOPMD
    /**
     * First Name of user.
     */
    private String firstName;
    /**
     * Name of user.
     */
    private String name;
    /**
     * Unique number for every polish person.
     */
    private String pesel;

    /**
     * returning Saldo of account.
     *
     * @return money
     */

    public int getMoney() {
        return money;
    }

    /**
     * Increase money about cash value.
     *
     * @param cash value that we are inc.
     */
    public void cashIn(final int cash) {
        this.money = this.money + cash;
    }

    /**
     * Decrease money about cash value.
     *
     * @param cash value we are decrea.
     */

    public void cashOut(final int cash) {
        this.money = this.money - cash;
    }

    /**
     * @return PESEL
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * sets PESEL to PESEL.
     *
     * @param peel x
     */
    public void setPesel(final String peel) {
        this.pesel = peel;
    }

    /**
     * @return FirstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets firstName to firstName.
     *
     * @param newFirstName first name
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name to name.
     *
     * @param newName last name
     */
    public void setName(final String newName) {
        this.name = newName;
    }


    /**
     * @return PIN
     */
    public int getPin() {
        return pin;
    }

    /**
     * sets PIN to value PIN.
     *
     * @param newPin our pin for logging
     */
    public void setPin(final int newPin) {
        this.pin = newPin;
    }
}
