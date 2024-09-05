package assignment.pageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginPageObjects
{
    WebDriver driver;

    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
      PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    WebElement emailID;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    public void navigateToApplication(){
        driver.get("https://qa-vc-shrd-versa-ui.azurewebsites.net/");
    }

    public void login(String email, String pass) throws InterruptedException {
        Thread.sleep(9000);
        emailID.sendKeys(email);
        password.sendKeys(pass);
        Thread.sleep(2000);
        signInButton.click();
    }
}
