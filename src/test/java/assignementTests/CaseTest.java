package assignementTests;

import assignment.pageObjectFile.AddParticipantObjects;
import assignment.pageObjectFile.HomePageObjects;
import assignment.pageObjectFile.LoginPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
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

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    @BeforeTest
   public void goToApplicationUrl(){
        extent.attachReporter(spark);
        launchBrowser();
   }

    @Step("Login into the app")
    @Test(priority = 1)
    public void loginIntoApp() throws InterruptedException {
        ExtentTest test = extent.createTest("Valid login into the app").assignAuthor("Aishwarya").assignDevice("Chrome");
        test.log(Status.PASS,"User logged into the app successfully");
        loginPageObjects.login("conveyancer@testconvey.co.uk","!Q2w3e4r");
        WebElement dashboardTitle= driver.findElement(By.xpath("//h5[normalize-space()='My cases']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
    }
    @Step("Search for specific case")
    @Test(priority = 2)
    public void searchForCase() throws InterruptedException {
        ExtentTest test = extent.createTest("Search for specific case").assignAuthor("Aishwarya").assignDevice("Chrome");
        test.log(Status.PASS,"Search for specific case");
        homePageObjects.clickOnSearchAndView("482");
    }

    @Step("Add new participant with new data")
    @Test(priority = 3)
    public void addNewParticipant() throws InterruptedException {
        ExtentTest test = extent.createTest("Add new participant").assignAuthor("Aishwarya").assignDevice("Chrome");
        test.log(Status.PASS,"Add new participant with new data");
        addParticipantObjects.addParticipants();
    }

    @Step("Edit participant details")
    @Test(priority = 4)
    public void  editAddedParticipant() throws InterruptedException {
        ExtentTest test = extent.createTest("Edit participant details").assignAuthor("Aishwarya").assignDevice("Chrome");
        test.log(Status.PASS,"Edit participant details");
        addParticipantObjects.editParticipants();
    }

    @Step("delete participant")
    @Test(priority = 5)
    public void deleteAddedParticipant() throws InterruptedException {
        ExtentTest test = extent.createTest("Delete participant details").assignAuthor("Aishwarya").assignDevice("Chrome");
        test.log(Status.PASS,"Delete user");
        addParticipantObjects.deleteParticipants();
    }

    @AfterTest
    public void afterTest(){
        extent.flush();
    }
}
