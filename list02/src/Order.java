import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    Client client;
    ArrayList<Item> orderedItems;

    public Order() {
        orderedItems=new ArrayList<Item>();
        orderedItems.add(orderNewItem());
        System.out.println(orderedItems.get(0).getStuckValue());

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    private static Item orderNewItem() {
        Item item = new Item();
        System.out.println("Type name of product that u want to order ");
        item.setName(new Scanner(System.in).next());
        System.out.println("Type quantity of product that u want to order ");
        item.setQuantity(new Scanner(System.in).nextInt());
        item.setStuckValue(item.LossStuckValue());
        System.out.println(" stuckValue of product that u want to order: " + item.getStuckValue());
        return item;
    }
}
