import java.util.ArrayList;

public class Order {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
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
        return ANSI_GREEN+itemArrayList.toString()+ANSI_RESET;
    }

}
