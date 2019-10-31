import java.util.ArrayList;

public class Order {
    ArrayList<Item> itemArrayList;

    public Order() {
     itemArrayList = new ArrayList<Item>();
    }

    private void addItem(Item item) {
    itemArrayList.add(item);
    }
}