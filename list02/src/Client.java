import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private String pesel;
    private String firstName;
    private String lastName;
    ArrayList<Order> orderArrayList= new ArrayList<>();


    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "pesel='" + pesel + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orderArrayList=" + orderArrayList.toString() +
                '}';
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public void addOrder(Order order){
        orderArrayList.add(order);
    }
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
