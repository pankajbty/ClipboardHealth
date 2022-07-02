package pages;

import drivers.DriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.logging.Level;

public class AmazonItemPage extends DriverMethods {

    public String getTextForAboutItem(){
        WebElement aboutItem = driver.findElement(By.xpath("//div[@id=\"feature-bullets\"]/h1"));
        return getText(aboutItem);
    }

    public void validateAboutItem() {
        LOGGER.log(Level.INFO, "Asserting the Value of the amazonItemPage Header :- About this item");
        Assert.assertEquals(getTextForAboutItem(), "About this item");
    }
}
