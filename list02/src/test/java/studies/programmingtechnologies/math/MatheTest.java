package studies.programmingtechnologies.math;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import studies.programmingtechnologies.order.Item;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatheTest {
  private ArrayList<Item> items;

  private MatheTest() {
    items = new ArrayList<>();
    Item item1 = new Item();
    item1.setProductName("TestItem");
    item1.setProductQuantity(20);
    item1.setProductStuckValue(110);
    item1.setProductWholeValue(110 * 20);
    Item item2 = new Item();
    item2.setProductName("TestItem");
    item2.setProductQuantity(20);
    item2.setProductStuckValue(110);
    item2.setProductWholeValue(110 * 20);
    items.add(item1);
    items.add(item2);
  }


  @Test
  void computeAllOrderCost() {
    int x = Mathe.computeOrderCost(items);
    Assert.assertEquals(4400, x);
  }
}
