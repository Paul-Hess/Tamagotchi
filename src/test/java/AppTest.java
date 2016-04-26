import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Tamagotchi");
  }
  @Test public void newTamagotchiCreationTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    assertThat(pageSource()).contains("Luca");
  }

  @Test public void newTamagotchiFoodLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    assertThat(pageSource()).contains("Food Level: 10");
  }

  @Test public void newTamagotchiSleepLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    assertThat(pageSource()).contains("Sleep Level: 10");
  }

  @Test public void newTamagotchiActivityLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    assertThat(pageSource()).contains("Activity Level: 10");
  }

  @Test public void newTamagotchiIncreaseFoodLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    submit("#feed");
    assertThat(pageSource()).contains("Food Level: 11");
  }

  @Test public void newTamagotchiIncreaseSleepLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    submit("#sleep");
    assertThat(pageSource()).contains("Sleep Level: 11");
  }

  @Test public void newTamagotchiIncreaseActivityLevelTest() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    submit("#activity");
    assertThat(pageSource()).contains("Activity Level: 11");
  }

  @Test public void newTamagotchiSimulateTimePassesOnClick() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    submit("#time");
    assertThat(pageSource()).contains("Food Level: 9");
    assertThat(pageSource()).contains("Sleep Level: 9");
    assertThat(pageSource()).contains("Activity Level: 9");
  }

  @Test public void newTamagotchiLetItDie() {
    goTo("http://localhost:4567/");
    fill("#name").with("Luca");
    submit("#nameBtn");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    submit("#time");
    assertThat(pageSource()).contains("Tamagotchi is dead, you asshole.");
  }

}
