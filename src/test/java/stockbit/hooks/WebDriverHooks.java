package stockbit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import stockbit.utils.Utils;
import stockbit.webdriver.WebDriverInstance;

public class WebDriverHooks {

  @Before
  public void beforeTest() {
    WebDriverInstance.initialize();
  }

  @AfterStep
  public void test() {
    // For live coding test propose
    Utils.staticWait(1000);
  }

  @After
  public void afterTest() {
    WebDriverInstance.quit();
  }
}
