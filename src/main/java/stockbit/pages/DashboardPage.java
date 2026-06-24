package stockbit.pages;

import org.openqa.selenium.By;
import stockbit.base.Base;

public class DashboardPage extends Base {

  private final By dashboardIndicator = By.id("dashboardScreen");

  public void assertDashboardIsVisible(){
    if (getDriver().findElements(dashboardIndicator).isEmpty()){
      throw new AssertionError("Dashboard not visible after login");
    }
  }
}
