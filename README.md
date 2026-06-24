# sb_stock_web_automation
Thank you Dika, for the base coding here: https://github.com/dikako/web-test-framework. In this repo I will continue coding my version.

# Selenium Cucumber Templates

## Project Structure
- `src/main/java/stockbit/base/Base.java` - Reusable method for interact with web element
- `src/main/java/stockbit/pages/` - Page Object
- `src/main/java/stockbit/utils/Capabilities.java` - Capabilities for Browser
- `src/main/java/stockbit/utils/Utils.java` - Utility method
- `src/main/java/stockbit/webdriver/WebDriverInstance.java` - WebDriver Instance
- `src/test/java/stockbit/hooks/WebDriverHooks.java` - Cucumber Hooks
- `src/test/java/stockbit/step_definitions/` - Step Definitions
- `src/test/resources/features/` - Feature Files


## Prerequisites
1. Java 17
2. IntelliJ IDEA (Recommended)
3. Plugin Cucumber for IntelliJ IDEA (Recommended)
4. Chrome Browser

## How to run
1. Clone this repository
2. Install all dependencies on `build.gradle`
3. Copy `.env.example` to `.env`
4. Run by click play on `.feature` file *(Recommended)*
5. Run using command `./gradlew cucumber -Dcucumber.filter.tags="@Buy"`

## Challenges & Hint
- Shadow DOM
- Drag and Drop
