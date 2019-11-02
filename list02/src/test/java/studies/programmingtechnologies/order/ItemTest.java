package studies.programmingtechnologies.order;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
  private Item item;
   ItemTest() {
    item = new Item();
    item.setProductName("TestItem");
    item.setProductQuantity(20);
    item.setProductStuckValue(110);
    item.setProductWholeValue(110 * 20);
  }


  @Test
  void getProductName() {
    Assert.assertEquals("TestItem",item.getProductName());
  }

  @Test
  void setProductName() {
    item.setProductName("Charlie");
    Assert.assertEquals("Charlie",item.getProductName());
  }


  @Test
  void lossStuckValue() {
    int x = item.lossStuckValue();
    Assert.assertNotEquals(item.getProductStuckValue(),x);
  }

}