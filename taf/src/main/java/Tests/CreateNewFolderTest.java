package Tests;

import Commons.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolderTest extends Configuration {

    String folderName;

    @BeforeClass
    public void setupClass() {
        setUp();
        webDriver.get("https://disk.yandex.ru/");
        site.loginPage().login();
        folderName = String.valueOf(System.currentTimeMillis());
    }

    @Test
    public void createFolder() {
        site.diskPage().createNewFolder(folderName);
        Assert.assertFalse(site.diskPage().getModal().isDisplayed());
        Assert.assertTrue(site.diskPage().getCreatedFolder(folderName).isDisplayed());
    }

    @Test(dependsOnMethods = "createFolder")
    public void visitToFolder() {
        site.diskPage().openCreatedFolder(folderName);
        Assert.assertEquals(site.diskPage().getNewFolderNameTitle(), folderName);
    }

    @Test(dependsOnMethods = "visitToFolder")
    public void createNewWordDock() {
        site.diskPage().createNewDock();
        site.diskPage().typeText(Constants.DOCK_TEXT);
        site.diskPage().typeDockName(Constants.DOCK_NAME);
        site.diskPage().goToSaveDockButton();
        Assert.assertEquals(site.diskPage().getDockName().getText(), Constants.DOCK_FILE_NAME);
    }

    @Test(dependsOnMethods = "createNewWordDock")
    public void reopenFile() {
        site.diskPage().reopenNewDock();
        Assert.assertEquals(site.diskPage().getTextInDock(), Constants.DOCK_TEXT);
    }

    @Test(dependsOnMethods = "reopenFile")
    public void deleteDock() throws InterruptedException {
        site.diskPage().closeTabs();
        site.diskPage().deleteDock();
        Assert.assertEquals(site.diskPage().getCreatedDocks().size(), 0);
    }

    @Test(dependsOnMethods = "deleteDock")
    public void clearTrash() {
        site.diskPage().clearTrash();
        Assert.assertEquals(site.diskPage().getCreatedDocks().size(), 0);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
