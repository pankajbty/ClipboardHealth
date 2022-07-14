package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoDriverMethods {
    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public static void openBrowser(String url){
        String browserType = ""; //read the value from env
        if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, 20);
    }

    public void click(WebElement element){
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String str){
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(str);
    }

}
