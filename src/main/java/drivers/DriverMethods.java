package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverMethods {
    public static WebDriver driver;
    public static RemoteWebDriver remoteDriver;
    public static WebDriverWait wdw;
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    // Opening browser here in headless mode
    public static void openBrowser(String browser, String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wdw = new WebDriverWait(driver, 20L);
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Opening browser in selenium grid
    public static void openRemoteBrowser(String url) throws MalformedURLException {
        DesiredCapabilities dr = DesiredCapabilities.chrome();
        dr.setBrowserName("chrome");
        remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
        remoteDriver.get(url);
        remoteDriver.manage().window().maximize();
    }

    public static void navigateToUrl(String url) {
        LOGGER.log(Level.INFO, "Navigating to the URL :- [" + url + "]");
        driver.navigate().to(url);
    }

    public static void scrollDown(int pixels){
        LOGGER.log(Level.INFO, "Scrolling down :- [" + pixels + "] pixels");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+ pixels +")", "");
    }

    public static void switchWindow(String window) {
        LOGGER.log(Level.INFO, "Switching Window handles to Window:- [" + window + "]");
        driver.switchTo().window(window);
    }

    public static Iterator<String> getHandles() {
        Set<String> li = driver.getWindowHandles();
        Iterator<String> it = li.iterator();
        return it;
    }

    public static void click(WebElement element) {
        wdw.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.log(Level.INFO, "Clicking on WebElement :- [" + element + "]");
        element.click();
    }

    public static String getText(WebElement element) {
        wdw.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.log(Level.INFO, "Getting text of WebElement :- [" + element + "]");
        return element.getText();
    }

    public static void selectDropdown(WebElement element, String value) {
        wdw.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.log(Level.INFO, "Selecting Dropdwon from WebElement :- [" + element + "]");
        Select sortOrder = new Select(element);
        sortOrder.selectByValue(value);
    }
}
