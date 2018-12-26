package Pages;

import Commons.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Base {

    public String checkboxCss = ".passport-Checkbox-View";
    public By passport = By.className("passp-auth");
    public By passportDomik = By.xpath("//div[@class='passport-Domik']");
    public By submitButton = By.xpath("//button[@type='submit']");
    public By passwordField = By.name("passwd");
    public By loginField = By.name("login");
    public By confirmPhoneField = By.xpath("//input[@data-field='phone']");
    public By diskLoginButton = By.xpath("//a[contains(@class,'button_login')]");
    public By checkbox = By.cssSelector(".passport-Checkbox");
    public By passportError = By.xpath("//div[contains(@class,'passport-Domik-Form-Error_active')]");
    public By passportErrorHelper = By.xpath("//a[contains(@class,'passport-Icon_error_help')]");
    public By diskLogo = By.xpath("//a[@class='logo__link logo__link_service'][@href='/client/disk']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPassport() {
        return webDriver.findElement(passport);
    }

    public WebElement getPassportDomik() {
        return webDriver.findElement(passportDomik);
    }

    public WebElement getSubmitButton() {
        return webDriver.findElement(submitButton);
    }

    public WebElement getPasswordField() {
        return webDriver.findElement(passwordField);
    }

    public WebElement getLoginField() {
        return webDriver.findElement(loginField);
    }

    public WebElement getConfirmPhoneField() {
        return webDriver.findElement(confirmPhoneField);
    }

    public WebElement getDiskLoginButton() {
        return webDriver.findElement(diskLoginButton);
    }

    public WebElement getCheckbox() {
        return webDriver.findElement(checkbox);
    }

    public WebElement getPassportError() {
        return webDriver.findElement(passportError);
    }

    public WebElement getPasswordErrorHelper() {
        return webDriver.findElement(passportErrorHelper);
    }

    public WebElement getDiskLogo() {
        return webDriver.findElement(diskLogo);
    }

    public LoginPage typeLogin(String login) {
        getLoginField().sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public void clickOnSubmit() {
        getSubmitButton().click();
        // wait for spinner
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
    }

    public void clickOnCheckbox() {
        waitAndClick(getCheckbox());
    }

    public void clearAllFields() {
        getLoginField().clear();
        getPasswordField().clear();
    }

    public void login() {
        webDriver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        waitAndClick(getDiskLoginButton());
        if (webDriver.findElements(passportDomik).size() > 0) {
            waitForClickable(getLoginField()).sendKeys(Constants.VALID_LOGIN);
            waitForClickable(getPasswordField()).sendKeys(Constants.VALID_PASSWORD);
            waitAndClick(getSubmitButton());
        } else if (webDriver.findElements(passport).size() > 0) {
            waitForClickable(getLoginField()).sendKeys(Constants.VALID_LOGIN);
            waitAndClick(getSubmitButton());
            retryingFindClick(getPasswordField());
            waitForClickable(getPasswordField()).sendKeys(Constants.VALID_PASSWORD);
            waitAndClick(getSubmitButton());
        }
    }

    public void waitDomikForm() {
        webDriver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        while (webDriver.findElements(passportDomik).size() == 0) {
            webDriver.manage().deleteAllCookies();
            webDriver.navigate().refresh();
        }
    }
}
