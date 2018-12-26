package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base {

    static WebDriver webDriver;
    static WebDriverWait wait;
    static JavascriptExecutor js;
    static Actions action;

    public Base(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 300);
        js = (JavascriptExecutor) webDriver;
        action = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitAndClick(WebElement element) {
        retryingFindClick(element);
    }

    public static boolean retryingFindClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public void analyzeLog() {
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

    public static String getElementCss(String element, String state, String cssValue) {
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('" + element + "'),':" + state + "').getPropertyValue('" + cssValue + "')");
    }
}
