package assignment.pageObjectFile;

import com.sun.nio.file.ExtendedOpenOption;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddParticipantObjects {

    WebDriver driver;

    public AddParticipantObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnAddParticipant")
    WebElement addParticipantsOption;

    @FindBy(id = "ParticipantTypeDropdown")
    WebElement typeDropdown;

    @FindBy(id = "Correspondent_LastName")
    WebElement lastName;

    @FindBy(id = "Correspondent_FirstName")
    WebElement firstName;

    @FindBy(id = "Correspondent_Company")
    WebElement companyName;

    @FindBy(id = "Correspondent_Email")
    WebElement emailId;

    @FindBy(id = "Correspondent_MobilePhoneNumber")
    WebElement mobileNumber;

    @FindBy(id = "Correspondent_WorkPhoneNumber")
    WebElement workNumber;

    @FindBy(xpath = "//*[@value='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/i[1]")
    WebElement editOption;

    @FindBy(xpath = "//i[@class='bi-trash']")
    WebElement deleteOption;

    @FindBy(xpath = "//h5[normalize-space()='Delete participant']")
     WebElement deleteParticipantHeader;

    @FindBy(xpath = "//div[normalize-space()='Are you sure you want to delete this participant?']")
    WebElement deleteBodyText;

    @FindBy(xpath = "//*[@class='btn btn-primary primary']")
    WebElement YesButton;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


   public void addParticipants() throws InterruptedException {
       //Click on add participants
       addParticipantsOption.click();

       // Select any type
       Select select = new Select(typeDropdown);
       select.selectByVisibleText("Broker");

       Thread.sleep(4000);

       // Add details
       lastName.sendKeys("Gavade");
       firstName.sendKeys("Aish");
       companyName.sendKeys("Winjit");
       emailId.sendKeys("aish@winjit.com");
       mobileNumber.sendKeys("9237434832");
       workNumber.sendKeys("446888654");

       Thread.sleep(4000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,450)", "");

       Thread.sleep(4000);
       saveButton.click();

    }
    public void  editParticipants() throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOf(addParticipantsOption));

       //Click on edit button
        editOption.click();
        Thread.sleep(2000);

        //Edit company name
        companyName.clear();
        companyName.sendKeys("winjit technologies");

        //scroll up
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");

        //Click on save
        Thread.sleep(4000);
        saveButton.click();

    }

    public void deleteParticipants() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addParticipantsOption));

        //Click on delete button
        deleteOption.click();

        wait.until(ExpectedConditions.visibilityOf(deleteParticipantHeader));

        //Click on yes button
        Thread.sleep(4000);
        YesButton.click();

        wait.until(ExpectedConditions.visibilityOf(addParticipantsOption));

    }
}
