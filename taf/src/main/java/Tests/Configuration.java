package Tests;

import Commons.Site;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class Configuration {

    WebDriver webDriver;
    Actions action;
    WebDriverWait wait;
    Site site;
    SoftAssert softAssert;

    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // т.к. Ubuntu немного иначе работает с относительными путями
        System.setProperty("webdriver.chrome.driver", "/home/pasha/gtat2018q3_pavel_babrou/taf/src/main/resources/drivers/chromedriver");
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 30, 500);
        site = new Site(webDriver);
        action = new Actions(webDriver);
    }
}
