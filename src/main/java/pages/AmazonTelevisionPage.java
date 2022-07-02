package pages;

import drivers.DriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonTelevisionPage extends DriverMethods {

    public void selectBrandClick(String brandName) {
        WebElement brand = driver.findElement(By.linkText(brandName));
        click(brand);
    }

    public void selectDropdownValue(String value) {
        WebElement sort = driver.findElement(By.id("s-result-sort-select"));
        selectDropdown(sort, value);
    }

    public void secondHighestItemClick(){
        List<WebElement> items = driver.findElements(By.cssSelector("div.s-product-image-container"));
        click(items.get(1));
    }
}
