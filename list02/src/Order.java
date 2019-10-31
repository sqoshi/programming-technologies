import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    ArrayList<Item> itemArrayList = new ArrayList<>();

    public Order(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;

    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public String toString() {
        return itemArrayList.toString();
    }
}