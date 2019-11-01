import java.util.Random;
import java.util.Scanner;

public class Item {
    private String productName;
    private int productQuantity;
    private int productStuckValue;
    private int productWholeValue;

    public int getProductWholeValue() {
        return productWholeValue;
    }

    public void setProductWholeValue(int productWholeValue) {
        this.productWholeValue = productWholeValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductStuckValue() {
        return productStuckValue;
    }

    public void setProductStuckValue(int productStuckValue) {
        this.productStuckValue = productStuckValue;
    }

    public int LossStuckValue() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public String toString() {
        return "\nProdcutName: " + getProductName() + ", "
                + "ProductQuantity: " + getProductQuantity() + ", "
                + "ProductStuckValue: " + getProductStuckValue() + ", "
                + "ProductWholeValue: " + getProductWholeValue();

    }
    static Item specifyItem() {
        Item item = new Item();
        System.out.print("Name:");
        item.setProductName(new Scanner(System.in).next());
        System.out.print("Qunatity:");
        item.setProductQuantity(new Scanner(System.in).nextInt());
        item.setProductStuckValue(item.LossStuckValue());
        System.out.print("Product " + item.getProductName() + " Value per Stuck: " + item.getProductStuckValue() + "\n");
        item.setProductWholeValue(item.getProductStuckValue() * item.getProductQuantity());
        System.out.println("Product " + item.getProductName() + "Whole Value: " + item.getProductWholeValue() + " \n");

        return item;
    }
}
