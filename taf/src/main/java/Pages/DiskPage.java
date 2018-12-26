package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DiskPage extends Base {

    public String recentTabContentLocator = "//div[@class='client-listing client-listing_type_recent']";
    public String fileTabContentLocator = "//div[@class='client-listing']";
    public String photoTabContentLocator = "//div[@class='page-stub page-stub_animated']";
    public String historyTabContentLocator = "//div[@class='journal-cluster']";
    public String archiveTabContentLocator = "//div[@class='root__listing']";
    public String trashTabContentLocator = "//div[@class='client-listing client-listing_type_trash']";
    By recentTab = By.xpath("//a[@href='/client/recent']");
    By fileTab = By.xpath("//a[@href='/client/disk']");
    By photoTab = By.xpath("//a[@href='/client/photo']");
    By sharedTab = By.xpath("//a[@href='/client/shared']");
    By historyTab = By.xpath("//a[@href='/client/journal']");
    By archiveTab = By.xpath("//a[@href='/client/mail']");
    By trashTab = By.xpath("//a[@href='/client/trash']");
    By rootListing = By.xpath("//div[@class='root__listing']");
    By rootListingTitle = By.xpath("//h1");
    By createNewButton = By.xpath("//span[@class='create-resource-popup-with-anchor']//button");
    By createNewFolder = By.xpath("//span[contains(@class,'file-icon_dir_plus')]");
    By inputFolderName = By.xpath("//div[@class='modal__content']//input[@class='textinput__control']");
    By confirmButton = By.xpath("//button[contains(@class,'confirmation-dialog__button')]");
    By modal = By.xpath("//div[contains(@class,'modal')]");
    By newFolderName = By.xpath("//h1[contains(@class,'listing-heading__title')]");
    By editorDockFrame = By.xpath("//iframe[@class='editor-doc__iframe']");
    public By dockTitle = By.id("BreadcrumbTitle");
    public By dockStatus = By.id("BreadcrumbSaveStatus");
    public By dockStatusSaving = By.xpath("//span[@class='BreadcrumbSaveStatus'][contains(text(),'Сохранение...')]");
    By inputLine = By.xpath("//div[@id='WACViewPanel_EditingElement']");
    By dockName = By.xpath("//span[@class='clamped-text']");
    By goToSaveDockButton = By.id("BreadcrumbFolder");
    public By createdDock = By.xpath("//div[@class='listing-item__fields']");
    By editDockButton = By.xpath("//div[@class='header__side-center']//span[@class='button2__text']/ancestor-or-self::a");
    By textInDock = By.xpath("//span[@class='SpellingError']");
    By deleteButton = By.xpath("//span[@class='button2__text'][contains(text(),'Удалить')]/parent::button");
    By helloWorldDock = By.xpath("//span[@class='clamped-text'][contains(text(),'Hello World!.docx')]");
    By clearTrashButton = By.xpath("//div[@class='listing-head__additional-actions']//button[@type='button']");
    By confirmDeleteButton = By.xpath("//button[contains(@class,' js-confirmation-accept')]");
    By recentTabContent = By.xpath("//div[@class='client-listing client-listing_type_recent']");
    By fileTabContent = By.xpath("//div[@class='client-listing']");
    By photoTabContent = By.xpath("//div[@class='page-stub page-stub_animated']");
    By historyTabContent = By.xpath("//div[@class='journal-cluster']");
    By archiveTabContent = By.xpath("//div[@class='root__listing']");
    By trashTabContent = By.xpath("//div[@class='client-listing client-listing_type_trash']");
    By publishedTabContent = By.xpath("//div[@class='listing-stub listing-stub_published']");

    public WebElement getRecentTabContent() {
        return webDriver.findElement(recentTabContent);
    }

    public WebElement getFileTabContent() {
        return webDriver.findElement(fileTabContent);
    }

    public WebElement getPhotoTabContent() {
        return webDriver.findElement(photoTabContent);
    }

    public WebElement getPublishedTabContent() {
        return webDriver.findElement(publishedTabContent);
    }

    public WebElement getHistoryTabContent() {
        return webDriver.findElement(historyTabContent);
    }

    public WebElement getArchiveTabContent() {
        return webDriver.findElement(archiveTabContent);
    }

    public WebElement getTrashTabContent() {
        return webDriver.findElement(trashTabContent);
    }

    public DiskPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDiskTab(String tabName) {
        return webDriver.findElement(By.xpath("//a[@href='/client/" + tabName + "']"));
    }

    public List<WebElement> getCreateNewPopupButtons() {
        return webDriver.findElements(By.xpath("//div[contains(@class,'popup2_visible_yes')]//button"));
    }

    public WebElement getCreateNewDockButton() {
        return getCreateNewPopupButtons().get(1);
    }

    public WebElement getRecentTab() {
        return webDriver.findElement(recentTab);
    }

    public WebElement getFileTab() {
        return webDriver.findElement(fileTab);
    }

    public WebElement getPhotoTab() {
        return webDriver.findElement(photoTab);
    }

    public WebElement getSharedTab() {
        return webDriver.findElement(sharedTab);
    }

    public WebElement getHistoryTab() {
        return webDriver.findElement(historyTab);
    }

    public WebElement getArchiveTab() {
        return webDriver.findElement(archiveTab);
    }

    public WebElement getTrashTab() {
        return webDriver.findElement(trashTab);
    }

    public WebElement getRootListing() {
        return webDriver.findElement(rootListing);
    }

    public WebElement getRootListingTitle() {
        return webDriver.findElement(rootListingTitle);
    }

    public WebElement getCreateNewButton() {
        return webDriver.findElement(createNewButton);
    }

    public WebElement getCreateNewFolder() {
        return webDriver.findElement(createNewFolder);
    }

    public WebElement getInputFolderName() {
        return webDriver.findElement(inputFolderName);
    }

    public WebElement getConfirmButton() {
        return webDriver.findElement(confirmButton);
    }

    public WebElement getModal() {
        return webDriver.findElement(modal);
    }

    public WebElement getNewFolderName() {
        return webDriver.findElement(newFolderName);
    }

    public WebElement getEditorDockFrame() {
        return webDriver.findElement(editorDockFrame);
    }

    public WebElement getDockTitle() {
        return webDriver.findElement(dockTitle);
    }

    public WebElement getInputLine() {
        return webDriver.findElement(inputLine);
    }

    public WebElement getDockName() {
        return webDriver.findElement(dockName);
    }

    public WebElement getCreatedDock() {
        return webDriver.findElement(createdDock);
    }

    public WebElement getClearTrashButton() {
        return webDriver.findElement(clearTrashButton);
    }

    public WebElement getConfirmDeleteButton() {
        return webDriver.findElement(confirmDeleteButton);
    }

    public List<WebElement> getCreatedDocks() {
        return webDriver.findElements(helloWorldDock);
    }

    public WebElement getDeleteButton() {
        return webDriver.findElement(deleteButton);
    }

    public WebElement getEditDockButton() {
        return webDriver.findElement(editDockButton);
    }

    public String getTextInDock() {
        return webDriver.findElement(textInDock).getText();
    }

    public void goToSaveDockButton() {
        waitAndClick(webDriver.findElement(goToSaveDockButton));
    }

    public String getNewFolderNameTitle() {
        return getNewFolderName().getAttribute("title");
    }

    public void openCreatedFolder(String folderName) {
        action.doubleClick(getCreatedFolder(folderName)).perform();
    }

    public void clickOnDiskTab(String tabName) {
        waitAndClick(getDiskTab(tabName));
    }

    public void clickOnSharedTab() {
        waitAndClick(getSharedTab());
    }

    public void createNewFolder(String folderName) {
        waitAndClick(getCreateNewButton());
        waitAndClick(getCreateNewFolder());
        wait.until(ExpectedConditions.elementToBeClickable(getInputFolderName())).click();
        getInputFolderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getInputFolderName().sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.attributeToBe(getInputFolderName(), "value", ""));
        getInputFolderName().sendKeys(folderName);
        getConfirmButton().click();
        wait.until(ExpectedConditions.invisibilityOf(getModal()));
        wait.until(ExpectedConditions.elementToBeClickable(getCreatedFolder(folderName)));
    }

    public void createNewDock() {
        waitAndClick(getCreateNewButton());
        waitAndClick(getCreateNewDockButton());
        List<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        switchToFrame(getEditorDockFrame());
        wait.until(ExpectedConditions.visibilityOfElementLocated(dockTitle));
    }

    public void reopenNewDock() {
        int attempts = 0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        while (webDriver.findElements(createdDock).size() == 0 && attempts < 5) {
            webDriver.navigate().refresh();
            attempts++;
        }
        action.doubleClick(getCreatedDock()).perform();
        List<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        waitAndClick(getEditDockButton());
        switchToFrame(getEditorDockFrame());
    }

    public DiskPage typeText(String text) {
        getInputLine().sendKeys(text);
        wait.until(ExpectedConditions.numberOfElementsToBe(dockStatusSaving, 0));
        return this;
    }

    public DiskPage typeDockName(String dockName) {
        wait.until(ExpectedConditions.elementToBeClickable(getDockTitle()));
        getDockTitle().click();
        getDockTitle().clear();
        getDockTitle().sendKeys(dockName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return this;
    }

    public void closeTabs() throws InterruptedException {
        List<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.close();
        webDriver.switchTo().window(tabs.get(1));
        webDriver.close();
        webDriver.switchTo().window(tabs.get(0));
    }

    public void switchToFrame(WebElement frame) {
        webDriver.switchTo().frame(frame);
    }

    public void deleteDock() {
        waitAndClick(getCreatedDock());
        waitAndClick(getDeleteButton());
    }

    public WebElement getCreatedFolder(String folderName) {
        return webDriver.findElement(By.xpath("//div[contains(@class,'listing-item_type_dir')]//span[contains(text(),'" + folderName + "')]"));
    }

    public void clearTrash() {
        waitAndClick(getTrashTab());
        waitAndClick(getClearTrashButton());
        waitAndClick(getConfirmDeleteButton());
        wait.until(ExpectedConditions.numberOfElementsToBe(helloWorldDock, 0));
    }
}
