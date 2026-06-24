package stockbit.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

import static stockbit.utils.Utils.getEnv;

public class Capabilities {

  /**
   * Returns a WebDriver instance based on the given browser name. The method configures the browser
   * with predefined settings and capabilities specific to Chrome, Firefox, Edge, or Safari. If an
   * unsupported or unrecognized browser name is provided, it defaults to configuring a Chrome WebDriver.
   *
   * @param browserName the name of the browser for which the WebDriver is to be configured.
   *                    Supported values are "chrome", "firefox", "edge", and "safari".
   *                    The method is case-insensitive.
   * @return a WebDriver instance with the configured options for the specified browser.
   *         Defaults to Chrome WebDriver if the specified browser is not supported.
   */
  public static WebDriver getBrowserOptions(String browserName) {
    return switch (browserName.toLowerCase()) {
      case "firefox" -> WebDriverManager.firefoxdriver().capabilities(firefoxOptions()).create();
      case "edge" -> WebDriverManager.edgedriver().capabilities(edgeOptions()).create();
      case "safari" -> WebDriverManager.safaridriver().create();
      default -> WebDriverManager.chromedriver().capabilities(chromeOptions()).create();
    };
  }

  /**
   * Configures and returns an instance of EdgeOptions with predefined settings
   * for launching a Microsoft Edge browser. The configuration includes enabling
   * InPrivate browsing mode, setting a custom user agent, and using a normal page load strategy.
   * If the application is configured to run in headless mode, additional arguments are added.
   * Performance logging capabilities are also enabled.
   *
   * @return an instance of EdgeOptions configured with the specified settings.
   */
  private static EdgeOptions edgeOptions() {
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("-inprivate");
    edgeOptions.addArguments("user-agent=" + getEnv("USER_AGENT"));
    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    if (isSetToHeadless()) {
      edgeOptions.addArguments("--headless=new");
    }
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    edgeOptions.setCapability("goog:loggingPrefs", logPrefs);

    return edgeOptions;
  }

  /**
   * Configures and returns an instance of FirefoxOptions with predefined settings
   * for launching a Firefox browser. The method applies settings such as private mode,
   * custom user agent, and standard page load strategy. Additional configurations
   * are applied if the application is set to run in headless mode.
   *
   * @return an instance of FirefoxOptions configured with the specified settings.
   */
  private static FirefoxOptions firefoxOptions() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("-private");
    firefoxOptions.addPreference("general.useragent.override", getEnv("USER_AGENT"));
    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    if (isSetToHeadless()) {
      firefoxOptions.addArguments("-headless");
    }

    return firefoxOptions;
  }

  /**
   * Configures and returns an instance of ChromeOptions with predefined settings
   * for launching a Chrome browser. Options include incognito mode, page load strategy,
   * and various arguments for resource management and debugging. Additional configurations
   * are applied based on whether the application is set to run in headless mode.
   *
   * @return an instance of ChromeOptions configured with the specified settings.
   */
  private static ChromeOptions chromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--remote-debugging-port=0");

    if (isSetToHeadless()) {
      options.addArguments("--headless=new");
      options.addArguments("--window-size=1920,1080");
    } else {
      options.addArguments("--start-maximized");
    }

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.SEVERE);
    options.setCapability("goog:loggingPrefs", logPrefs);
    options.addArguments("--disable-web-security");

    return options;
  }

  /**
   * Determines if the application is set to run in headless mode based on the environment variable "HEADLESS".
   *
   * @return true if the "HEADLESS" environment variable is set to "true", otherwise false.
   */
  public static boolean isSetToHeadless() {
    return Utils.getEnv("HEADLESS").equals("true");
  }
}
