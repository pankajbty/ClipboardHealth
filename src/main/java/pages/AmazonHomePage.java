package pages;

import org.testng.Assert;
import drivers.DriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;

public class AmazonHomePage extends DriverMethods {

    public void homePageHamburgerMenuClick(){
        WebElement homePageHamburgerMenu = driver.findElement(By.id("nav-hamburger-menu"));
        click(homePageHamburgerMenu);
    }

    public String shopByDepartmentGetText(int index){
        List<WebElement> shopByDepartment = driver.findElements(By.cssSelector("ul.hmenu-visible div.hmenu-title"));
        return getText(shopByDepartment.get(index));
    }

    public void tvAppliancesElectronicsClick() {
        WebElement tvAppliancesElectronics = driver.findElement(By.linkText("TV, Appliances, Electronics"));
        click(tvAppliancesElectronics);
    }

    public void televisionsClick() {
        WebElement televisions = driver.findElement(By.linkText("Televisions"));
        click(televisions);
    }

    public void validateShopByDepartment(){
        LOGGER.log(Level.INFO, "Asserting the Value of the Department Header :- Shop By Department");
        Assert.assertEquals(shopByDepartmentGetText(2), "Shop By Department");
    }

}
