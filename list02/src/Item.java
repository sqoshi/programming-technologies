import java.util.Random;

public class Item {
    private int quantity;
    private int stuckValue;
    private String name;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int LossStuckValue()
    {
        Random random = new Random();
        return stuckValue=random.nextInt(100);
    }


    public void setStuckValue(int stuckValue) {
        this.stuckValue = stuckValue;
    }

    public int getStuckValue() {
        return stuckValue;
    }
}
