package pages.demo_blaze_home;

import drivers.DemoDriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends DemoDriverMethods {

    public WebElement signUp(){
        return driver.findElement(By.id("signin2"));
    }

    public WebElement username(){
        return driver.findElement(By.id("sign-username"));
    }

    public WebElement password(){
        return driver.findElement(By.id("sign-password"));
    }

    public WebElement signUpButton(){
        return driver.findElement(By.xpath("//div[@id=\"signInModal\"]//button[@class=\"btn btn-primary\"]"));
    }

    public void validate() {
        
    }

}
