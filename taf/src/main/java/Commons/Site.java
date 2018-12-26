package Commons;

import Pages.DiskPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Site {
    private WebDriver webDriver;

    public Site(WebDriver driver) {
        webDriver = driver;
    }

    public LoginPage loginPage() {
        return new LoginPage(webDriver);
    }

    public DiskPage diskPage() {
        return new DiskPage(webDriver);
    }
}
