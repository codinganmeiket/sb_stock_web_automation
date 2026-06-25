package stockbit.pages;

import org.openqa.selenium.By;
import stockbit.base.Base;

public class LoginPage extends Base {
  private final By usernameField = By.cssSelector("[test-id='fieldUsername']");
  private final By passwordField = By.cssSelector("[test-id='fieldPassword']");
  private final By loginButton   = By.cssSelector("[test-id='btnLogin']");
  private final By loginError = By.id("loginError");

  public void enterUsername(String username) {
    typeOn(usernameField, username);
  }

  public void enterPassword(String password) {
    typeOn(passwordField, password);
  }

  public void clickLogin() {
    clickOn(loginButton);
  }

  public void loginWithCredentials(String username, String password) {
    enterUsername(username);
    enterPassword(password);
    clickLogin();
  }

  public void assertErrorMessage(String message) {
    By errorElement = By.id("loginError");
    assertText(errorElement, message);
  }

    public void assertLoginErrorIsVisible(){
    if (getDriver().findElements(loginError).isEmpty()){
      throw new AssertionError("Login Error is not visible");
    }
  }
}
