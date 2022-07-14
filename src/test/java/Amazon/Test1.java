package Amazon;

import drivers.DemoDriverMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.demo_blaze_home.HomePage;

public class Test1 {

    HomePage homePage = new HomePage();
    DemoDriverMethods driverMethods = new DemoDriverMethods();

    @BeforeTest
    public void setupBrowser(){
        driverMethods.openBrowser("https://www.demoblaze.com/");
    }

    @Test
    public void signUpTest() {
        driverMethods.click(homePage.signUp());
        driverMethods.sendKeys(homePage.username(), "test237632");
        driverMethods.sendKeys(homePage.password(), "test6723");
        driverMethods.click(homePage.signUpButton());
    }
}




//https://www.demoblaze.com/
//        1. Execution of Test1 script on diff browsers
//        2. writ test script for signup functionality
//        3. Multiple users signup using same script
//        4. Parallel Execution of Test1 scripts
