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

  @When("I enter username {string}")
  public void iEnterUsername(String envKey){
    // loginPage.enterUsername(Utils.getEnv(envKey));
    loginPage.enterUsername(Utils.getEnv(envKey).isEmpty()? envKey : Utils.getEnv(envKey));
  }

  @And("I enter password {string}")
  public void iEnterPassword(String envKey){
    // loginPage.enterPassword(Utils.getEnv(envKey));
    loginPage.enterPassword(Utils.getEnv(envKey).isEmpty()? envKey : Utils.getEnv(envKey));
  }

  @And("I click the login button")
  public void iClickTheLoginButton(){
    loginPage.clickLogin();
  }

  @Then("I should be redirected to the dashboard")
  public void iShouldBeRedirectedToTheDashboard(){
    dashboardPage.assertDashboardIsVisible();
  }

  @Then("I get login error message")
  public void iGetLoginErrorMessage(){
    loginPage.assertLoginErrorIsVisible();
  }
}
