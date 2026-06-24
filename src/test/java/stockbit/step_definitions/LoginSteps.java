package stockbit.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stockbit.pages.DashboardPage;
import stockbit.pages.LoginPage;
import stockbit.utils.Utils;

public class LoginSteps {

  LoginPage loginPage = new LoginPage();
  DashboardPage dashboardPage = new DashboardPage();

  @Given("I am on the login page")
  public void iAmOnTheLoginPage(){

  }

  @When("I enter username from env {string}")
  public void iEnterUsernameFromEnv(String envKey){
    loginPage.enterUsername(Utils.getEnv(envKey));
  }

  @And("I enter password from env {string}")
  public void iEnterPasswordFromEnv(String envKey){
    loginPage.enterPassword(Utils.getEnv(envKey));
  }

  @And("I click the login button")
  public void iClickTheLoginButton(){
    loginPage.clickLogin();
  }

  @Then("I should be redirected to the dashboard")
  public void iShouldBeRedirectedToTheDashboard(){
    dashboardPage.assertDashboardIsVisible();
  }
}
