package Amazon;

import drivers.DriverMethods;
import pages.AmazonHomePage;
import pages.AmazonItemPage;
import pages.AmazonTelevisionPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.logging.Level;

public class AmazonTests extends DriverMethods{

    static AmazonHomePage amazonHomePage = new AmazonHomePage();
    static AmazonTelevisionPage amazonTelevisionPage = new AmazonTelevisionPage();
    static AmazonItemPage amazonItemPage = new AmazonItemPage();

    @BeforeTest
    public void setUp() {
        LOGGER.log(Level.INFO, "Launching Browser");
        openBrowser("https://www.amazon.in/");
    }

    @Test
    public void veridyAboutItemTest() {
        amazonHomePage.homePageHamburgerMenuClick();
        amazonHomePage.validateShopByDepartment();
        amazonHomePage.tvAppliancesElectronicsClick();
        amazonHomePage.televisionsClick();
        scrollDown(2500);
        amazonTelevisionPage.selectBrandClick("Samsung");
        amazonTelevisionPage.selectDropdownValue("price-desc-rank");
        amazonTelevisionPage.secondHighestItemClick();
        Iterator<String> it = getHandles();
        String parent = it.next();
        String newWindow = it.next();
        switchWindow(newWindow);
        scrollDown(700);
        amazonItemPage.validateAboutItem();
        switchWindow(parent);
    }

    @Test
    public void veridyAboutItemTestToShowParallelRun() {
        amazonHomePage.homePageHamburgerMenuClick();
        amazonHomePage.validateShopByDepartment();
    }

    @AfterTest
    public void tearDown() {
        LOGGER.log(Level.INFO, "Quiting Browser");
        driver.quit();
    }
}
