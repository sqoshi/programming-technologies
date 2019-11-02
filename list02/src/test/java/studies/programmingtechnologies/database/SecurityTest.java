package studies.programmingtechnologies.database;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import studies.programmingtechnologies.user.Client;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {

  @Test
  void isStringInt() {
    Assert.assertEquals(123, Security.isStringInt("123"));
  }

  @Test
  void checkPeselAvailability() {
    Database database = new Database();
    Client c1 = new Client();
    c1.setFirstName("Piotr");
    c1.setLastName("Popis");
    c1.setPesel("11111111111");
    Assert.assertEquals("12345678999", Security.checkPeselAvailability("12345678999", database));
  }


  @Test
  void peselLengthCheck() {
    Assert.assertEquals(11, Security.peselLengthCheck("1111111111p").length());
  }

  @Test
  void peselOutOfLetters() {
    Assert.assertNotEquals("11111111111", Security.peselOutOfLetters("22222222222"));
  }
}