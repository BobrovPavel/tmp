package Tests;

import Commons.Constants;
import Pages.Base;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LoginDomikTests extends Configuration {

    @BeforeClass
    public void setupClass() {
        setUp();
        webDriver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        webDriver.get("https://disk.yandex.ru/");
        Base.waitAndClick(site.loginPage().getDiskLoginButton());
        site.loginPage().waitDomikForm();
    }

    @BeforeMethod
    public void preCondition() throws InterruptedException {
        site.loginPage().getLoginField().clear();
        site.loginPage().getPasswordField().clear();
    }

    @Test
    public void checkedCheckboxDisplayed() {
        site.loginPage().clickOnCheckbox();
        Assert.assertEquals("visible",
                Base.getElementCss(site.loginPage().checkboxCss, "after", "visibility"), "Checkbox was not checked");
    }

    @Test
    public void allFieldsEmpty() {
        site.loginPage()
                .clickOnSubmit();
        softAssert.assertTrue(site.loginPage().getPassportError().isDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(site.loginPage().getPassportError().getText(), Constants.TEXT_NO_LOHIN_ERROR, "Error messages is not equals");
        softAssert.assertAll();
    }

    @Test
    public void validLoginAndemptyPassword() {
        site.loginPage()
                .typeLogin(Constants.VALID_LOGIN)
                .clickOnSubmit();
        softAssert.assertTrue(site.loginPage().getPassportError().isDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(site.loginPage().getPassportError().getText(), Constants.TEXT_NO_PASSWORD_ERROR, "Error messages is not equals");
        softAssert.assertAll();
    }

    @Test
    public void validPasswordAndemptyLogin() {
        new LoginPage(webDriver)
                .typePassword(Constants.VALID_PASSWORD)
                .clickOnSubmit();
        softAssert.assertTrue(site.loginPage().getPassportError().isDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(site.loginPage().getPassportError().getText(), Constants.TEXT_NO_LOHIN_ERROR, "Error messages is not equals");
        softAssert.assertAll();
    }

    @Test
    public void invalidLoginAndPassword() {
        new LoginPage(webDriver)
                .typeLogin(Constants.INVALID_LOGIN)
                .typePassword(Constants.INVALID_PASSWORD)
                .clickOnSubmit();
        softAssert.assertTrue(site.loginPage().getPassportError().isDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(site.loginPage().getPassportError().getText(), Constants.TEXT_NO_SOUCH_ACCOUNT_ERROR, "Error messages is not equals");
        softAssert.assertAll();
    }

    @Test
    public void validLoginAndInvalidPassword() {
        new LoginPage(webDriver)
                .typeLogin(Constants.VALID_LOGIN)
                .typePassword(Constants.INVALID_PASSWORD)
                .clickOnSubmit();
        softAssert.assertTrue(site.loginPage().getPassportError().isDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(site.loginPage().getPassportError().getText(), Constants.TEXT_INVALID_PASSWORD_ERROR, "Error messages is not equals");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validValues() {
        site.loginPage()
                .typeLogin(Constants.VALID_LOGIN)
                .typePassword(Constants.VALID_PASSWORD)
                .clickOnSubmit();
        Assert.assertTrue(site.loginPage().getDiskLogo().isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

