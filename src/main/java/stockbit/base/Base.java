package stockbit.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stockbit.webdriver.WebDriverInstance;

public class Base {

  /**
   * Provides access to the singleton instance of the WebDriver.
   * This method retrieves the current active WebDriver instance that has been initialized
   * for browser interactions.
   *
   * @return the active WebDriver instance for interacting with the web browser
   */
  public WebDriver getDriver() {
    return WebDriverInstance.webDriver;
  }

  /**
   * Types the specified text into the web element located by the provided By locator.
   *
   * @param element the locator of the web element where the text will be entered
   * @param text the text to input into the located web element
   */
  public void typeOn(By element, String text) {
    getDriver().findElement(element).sendKeys(text);
  }

  /**
   * Clicks on a web element located by the specified {@code By} locator.
   *
   * @param element the locator of the web element to be clicked
   */
  public void clickOn(By element) {
    getDriver().findElement(element).click();
  }

  /**
   * Asserts that the text of the web element located by the given {@code By} locator matches the expected text.
   * If the actual text does not match the expected text, an {@code AssertionError} is thrown.
   *
   * @param element the locator of the web element whose text is to be asserted
   * @param text the expected text to compare against the web element's actual text
   * @throws AssertionError if the actual text is empty or does not match the expected text
   */
  public void assertText(By element, String text) {
    String actualText = getDriver().findElement(element).getText();

    if (actualText.isEmpty()) {
      throw new AssertionError("Element/Text not found");
    } else {
      if (!actualText.equals(text)) {
        throw new AssertionError(String.format("Expected: %s, Actual: %s", text, actualText));
      }
    }
  }

  // TODO: Your next logic for interaction with element locators
}
