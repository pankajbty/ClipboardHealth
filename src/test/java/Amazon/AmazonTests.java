//package Amazon;
//
//import drivers.DriverMethods;
//import org.testng.annotations.*;
//import pages.AmazonHomePage;
//import pages.AmazonItemPage;
//import pages.AmazonTelevisionPage;
//
//import java.net.MalformedURLException;
//import java.util.Iterator;
//import java.util.logging.Level;
//
//public class AmazonTests extends DriverMethods{
//
//    static AmazonHomePage amazonHomePage = new AmazonHomePage();
//    static AmazonTelevisionPage amazonTelevisionPage = new AmazonTelevisionPage();
//    static AmazonItemPage amazonItemPage = new AmazonItemPage();
//
//    @BeforeTest
//    @Parameters({"browser"})
//    public void setUp(@Optional String browser) throws MalformedURLException {
//        LOGGER.log(Level.INFO, "Launching Browser");
//        openBrowser(browser, "https://www.amazon.in/");
//        // This is used for open the browser in Selenium grid using docker
////        openRemoteBrowser("https://www.amazon.in/");
//    }
//
//    @Test1
//    public void veridyAboutItemTest() {
//        amazonHomePage.homePageHamburgerMenuClick();
//        amazonHomePage.validateShopByDepartment();
//        amazonHomePage.tvAppliancesElectronicsClick();
//        amazonHomePage.televisionsClick();
//        scrollDown(2500);
//        amazonTelevisionPage.selectBrandClick("Samsung");
//        amazonTelevisionPage.selectDropdownValue("price-desc-rank");
//        amazonTelevisionPage.secondHighestItemClick();
//        Iterator<String> it = getHandles();
//        String parent = it.next();
//        String newWindow = it.next();
//        switchWindow(newWindow);
//        scrollDown(700);
//        amazonItemPage.validateAboutItem();
//        switchWindow(parent);
//    }
//
//    @Test1
//    public void veridyAboutItemTestToShowParallelRun() {
//        amazonHomePage.homePageHamburgerMenuClick();
//        amazonHomePage.validateShopByDepartment();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        LOGGER.log(Level.INFO, "Quiting Browser");
//        driver.quit();
//    }
//}
