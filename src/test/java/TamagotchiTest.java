import org.junit.*;
import static org.junit.Assert.*;


public class TamagotchiTest {

  @Test
  public void newTamagotchi_instatiatesCorrectly() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals(true, testTamagotchi instanceof Tamagotchi);
  }

  @Test
  public void getName_returnsNameCorrectly() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals("Luca", testTamagotchi.getName());
  }

  @Test
  public void getFoodLevel_instantiatesWithFoodLevel() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals(10, testTamagotchi.getFoodLevel());
  }

  @Test
  public void getFoodLevel_instantiatesWithSleepLevel() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals(10, testTamagotchi.getSleepLevel());
  }

  @Test
  public void getFoodLevel_instantiatesWithActivityLevel() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals(10, testTamagotchi.getActivityLevel());
  }

  @Test
  public void increaseLevel_increaseLevelsCorrectly() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    testTamagotchi.increaseLevel("food");
    testTamagotchi.increaseLevel("sleep");
    testTamagotchi.increaseLevel("activity");
    assertEquals(11, testTamagotchi.getFoodLevel());
    assertEquals(11, testTamagotchi.getSleepLevel());
    assertEquals(11, testTamagotchi.getActivityLevel());
  }

  @Test
  public void timePasses_decreasesHealthLevelsAsTimePasses() {
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    testTamagotchi.timePasses();
    assertEquals(9, testTamagotchi.getFoodLevel());
    assertEquals(9, testTamagotchi.getSleepLevel());
    assertEquals(9, testTamagotchi.getActivityLevel());
  }

  @Test
  public void checkHealthStatus_returnTrueIfAlive(){
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    assertEquals(true, testTamagotchi.checkHealthStatus());
  }

  @Test
  public void checkHealthStatus_returnFalseifDead(){
    Tamagotchi testTamagotchi = new Tamagotchi("Luca");
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    testTamagotchi.timePasses();
    assertEquals(false, testTamagotchi.checkHealthStatus());
  }


}
