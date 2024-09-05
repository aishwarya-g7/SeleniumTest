package assignementTests;

import assignment.pageObjectFile.AddParticipantObjects;
import assignment.pageObjectFile.HomePageObjects;
import assignment.pageObjectFile.LoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CaseTest extends BasicSetup{

    LoginPageObjects loginPageObjects = new LoginPageObjects(getDriver());
    HomePageObjects homePageObjects = new HomePageObjects(getDriver());
    AddParticipantObjects addParticipantObjects = new AddParticipantObjects(getDriver());

    public CaseTest(){
       driver = getDriver();
    }

    @BeforeTest
   public void goToApplicationUrl(){
       launchBrowser();
   }

    @Test(priority = 1)
    public void loginIntoApp() throws InterruptedException {
        loginPageObjects.login("conveyancer@testconvey.co.uk","!Q2w3e4r");
        WebElement dashboardTitle= driver.findElement(By.xpath("//h5[normalize-space()='My cases']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
    }

    @Test(priority = 2)
    public void searchForCase() throws InterruptedException {
        homePageObjects.clickOnSearchAndView("481");
    }

    @Test(priority = 3)
    public void addNewParticipant() throws InterruptedException {
        addParticipantObjects.addParticipants();
    }
    @Test(priority = 4)
    public void  editAddedParticipant() throws InterruptedException {
        addParticipantObjects.editParticipants();
    }

    @Test(priority = 5)
    public void deleteAddedParticipant() throws InterruptedException {
        addParticipantObjects.deleteParticipants();
    }
}
