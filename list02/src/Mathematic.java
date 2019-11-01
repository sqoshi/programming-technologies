import java.util.ArrayList;

public class Mathematic {
    public static int computeOrderCost(ArrayList<Item> arrayList) {
        int sum=0;
        for (int i = 0; i < arrayList.size(); ++i) {
            sum = arrayList.get(i).getProductWholeValue();
        }
        return sum;
    }
}
