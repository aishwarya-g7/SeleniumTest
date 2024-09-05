package assignment.pageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageObjects
{
    WebDriver driver;

    public HomePageObjects(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'All cases')]")
    WebElement allCasesOption;

    @FindBy(id = "Search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@title='Search button']")
    WebElement searchButton;

    @FindBy(xpath = "//a[normalize-space()='View']")
    WebElement viewCase;

    @FindBy(xpath = "//a[@class='nav-link bg-white '][1]")
    WebElement participantTab;

    public void clickOnSearchAndView(String caseNumber) throws InterruptedException {

        Thread.sleep(2000);

        //search case for given case number
        searchBox.click();
        searchBox.sendKeys(caseNumber);
        Thread.sleep(2000);
        searchButton.click();

        //After search view searched result
        Thread.sleep(2000);
        viewCase.click();

        //Click on participant Tab
        Thread.sleep(5000);
        participantTab.click();
    }
}
