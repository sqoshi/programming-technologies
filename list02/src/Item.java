import java.util.Random;

public class Item {
    String productName;
    int productQuantity;
    int productStuckValue;

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
    public int LossStuckValue(){
        Random random = new Random();
                return random.nextInt(100);
    }

    @Override
    public String toString() {
        return "\nProdcutName: "+getProductName()+", "
                + "ProductQuantity: "+ getProductQuantity()+", "
                +"ProductStuckValue: "+getProductStuckValue();
    }
}
