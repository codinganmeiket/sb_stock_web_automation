package stockbit.webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import stockbit.utils.Capabilities;
import stockbit.utils.Utils;

import java.time.Duration;

import static stockbit.utils.Capabilities.isSetToHeadless;

public class WebDriverInstance {

  public static WebDriver webDriver;

  /**
   * Initializes the WebDriver instance with appropriate browser configurations.
   * <ul>
   * - Retrieves the browser name from the environment variable "BROWSER" and resolves it to one of the supported options: Chrome, Firefox, or Edge.
   * - Sets up the WebDriver instance based on the resolved browser name using pre-defined browser capabilities.
   * - Adjusts the browser window configuration based on the "HEADLESS" environment variable:
   *   - If headless mode is enabled, the browser window size is set to 1920x1080.
   *   - Otherwise, the browser window is maximized.
   * - Configures browser timeouts:
   *   - Page load timeout is set to 15 seconds.
   *   - Implicit wait timeout is set to 15 seconds.
   * - Loads the base URL "https://your-web-to-test.com" into the browser.
   *
   * @throws RuntimeException if an unsupported browser name is provided via the "BROWSER" environment variable.
   */
  public static void initialize() {
    String browser = getBrowserName().toLowerCase();
    switch (browser) {
      case "chrome", "firefox", "edge" -> webDriver = Capabilities.getBrowserOptions(browser);
      default -> throw new RuntimeException("Invalid set browser name: " + browser);
    }

    if (isSetToHeadless()) {
      webDriver.manage().window().setSize(new Dimension(1920, 1080));
    } else {
      webDriver.manage().window().maximize();
    }

    webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    webDriver.get("https://web-test-challenges.dikacore.dev/");
  }

  /**
   * Terminates the currently active WebDriver session and closes all associated browser windows.
   * <p>
   * This method ensures the proper cleanup of resources allocated to the WebDriver instance.
   * It is recommended to call this method in the context of a test teardown process to avoid
   * potential resource leaks and ensure that all browser sessions are fully closed.
   */
  public static void quit() {
    webDriver.quit();
  }

  /**
   * Retrieves the browser name from the "BROWSER" environment variable.
   * If the environment variable is not set or is empty, returns "chrome" as the default.
   *
   * @return the name of the browser specified in the "BROWSER" environment variable, or "chrome" if not specified
   */
  private static String getBrowserName() {
    String browser = Utils.getEnv("BROWSER");
    return browser.isEmpty() ? "chrome" : browser;
  }
}
